package com.lsupoo.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRequest {
    private float monto;
    private String monedaOrigen;
    private String monedaDestino;
}
