package br.com.project.fiapfood.external.gateway;

import br.com.project.fiapfood.domain.model.Checkout;

public interface CheckoutGateway  {
    Checkout save(Checkout checkout);
    Checkout findByOrderId(Long id);
}

