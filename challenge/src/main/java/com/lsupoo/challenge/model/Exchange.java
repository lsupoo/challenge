package com.lsupoo.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "exchange_rate")
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name= "symbol")
    private String symbol;
    @Column(name= "change")
    private float change;


}
