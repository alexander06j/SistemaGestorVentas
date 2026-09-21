package com.softwarePinas.SistemaControlVentas.exception;

import lombok.AllArgsConstructor;


public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje) {
        super(mensaje);
    }



}
