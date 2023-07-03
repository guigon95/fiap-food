package br.com.project.fiapfood.application.core.exception;

import jakarta.persistence.EntityNotFoundException;

public class OrderNotFoundException extends EntityNotFoundException {
    public OrderNotFoundException(){
        super();
    }
}
