package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.application.core.domain.Checkout;
import br.com.project.fiapfood.application.port.in.CheckoutServicePort;
import br.com.project.fiapfood.application.port.out.CheckoutPort;
import org.springframework.stereotype.Component;

@Component
public class CheckoutService implements CheckoutServicePort {
    private final CheckoutPort checkoutPort;

    public CheckoutService(CheckoutPort checkoutPort) {
        this.checkoutPort = checkoutPort;
    }

    @Override
    public Checkout save(Checkout checkout) {
        return checkoutPort.save(checkout);
    }
}
