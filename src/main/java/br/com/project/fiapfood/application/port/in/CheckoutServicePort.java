package br.com.project.fiapfood.application.port.in;

import br.com.project.fiapfood.application.core.domain.Checkout;

public interface CheckoutServicePort {
    Checkout save(Checkout checkout);
}
