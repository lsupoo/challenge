package com.lsupoo.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequest {
    private float change;
    private String symbol;
}
