package br.com.project.fiapfood.application.usecase;

import br.com.project.fiapfood.adapter.gateway.OrderGateway;
import br.com.project.fiapfood.adapter.gateway.PaymentGateway;
import br.com.project.fiapfood.domain.model.Payment;
import br.com.project.fiapfood.domain.usecase.OrderUseCase;
import br.com.project.fiapfood.domain.usecase.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentUseCaseImpl implements PaymentUseCase {

    private final PaymentGateway paymentGateway;

    private final OrderUseCase orderUseCase;
    @Override
    public Payment createPayment(Payment payment) {
        var order = orderUseCase.findById(payment.getOrder().getId());
        return paymentGateway.save(payment);
    }
}
