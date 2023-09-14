package br.com.project.fiapfood.domain.usecase;

import br.com.project.fiapfood.domain.model.Checkout;

public interface CheckoutUseCase {
    Checkout createCheckout(Checkout checkout);
}
