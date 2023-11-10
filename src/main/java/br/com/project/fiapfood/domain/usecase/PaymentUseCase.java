package br.com.project.fiapfood.domain.usecase;

import br.com.project.fiapfood.domain.model.Payment;

public interface PaymentUseCase {
    Payment createPayment(Payment payment);
}
