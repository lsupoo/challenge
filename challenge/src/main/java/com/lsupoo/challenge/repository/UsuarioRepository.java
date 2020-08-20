package com.lsupoo.challenge.repository;

import com.lsupoo.challenge.model.Exchange;
import com.lsupoo.challenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

    public abstract Usuario findByUsuario(String usuario);
}
