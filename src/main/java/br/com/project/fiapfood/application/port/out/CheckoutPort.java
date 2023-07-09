package br.com.project.fiapfood.application.port.out;

import br.com.project.fiapfood.application.core.domain.Checkout;

public interface CheckoutPort {
    Checkout save(Checkout checkout);
}
