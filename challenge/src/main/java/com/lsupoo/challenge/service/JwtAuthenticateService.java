package com.lsupoo.challenge.service;

import com.lsupoo.challenge.model.Usuario;
import com.lsupoo.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("jwtAuthenticateService")
public class JwtAuthenticateService implements UserDetailsService {
    @Autowired
    @Qualifier("usuarioRepository")
    UsuarioRepository usuarioRepository;

    BCryptPasswordEncoder encoder = passwordEncoder();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsuario(username);
        return new User(user.getUsuario(), encoder.encode(user.getContrasena()), user.isActivo(),
                user.isActivo(), user.isActivo(), user.isActivo(),
                buildGranted(user.getRol()));
    }

    public List<GrantedAuthority> buildGranted(byte rol) {
        String roles[] = {"LECTOR", "USUARIO", "ADMIN"};
        List<GrantedAuthority> auths = new ArrayList<>();

        for (int i=0; i<rol; i++) {
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }

        return auths;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
