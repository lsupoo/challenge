package com.lsupoo.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeResponse {
    private float monto;
    private float montoResultado;
    private String monedaOrigen;
    private String monedaDestino;
    private float cambio;

}
