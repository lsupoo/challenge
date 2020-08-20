package com.lsupoo.challenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
public class Usuario {

    @GeneratedValue
    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "USUARIO", unique = true, nullable = false)
    private String usuario;

    @Column(name = "CONTRASENA")
    private String contrasena;

    @Column(name = "ROL")
    private byte rol;

    @Column(name = "ACTIVO")
    private boolean activo;
}

