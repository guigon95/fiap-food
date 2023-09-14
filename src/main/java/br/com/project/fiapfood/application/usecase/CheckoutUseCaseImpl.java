package br.com.project.fiapfood.application.usecase;

import br.com.project.fiapfood.adapter.gateway.CheckoutGateway;
import br.com.project.fiapfood.domain.model.Checkout;
import br.com.project.fiapfood.domain.usecase.CheckoutUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckoutUseCaseImpl implements CheckoutUseCase {

    private final CheckoutGateway checkoutGateway;

    @Override
    public Checkout createCheckout(Checkout checkout) {

        Checkout checkoutOld = checkoutGateway.findByOrderId(checkout.getOrderId());
        if(checkoutOld != null)
            return checkoutOld;

        return checkoutGateway.save(checkout);
    }
}
