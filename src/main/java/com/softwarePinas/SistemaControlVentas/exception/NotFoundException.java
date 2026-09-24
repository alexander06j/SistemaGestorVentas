package com.softwarePinas.SistemaControlVentas.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}
