package br.com.project.fiapfood.adapter.gateway;

import br.com.project.fiapfood.domain.model.Payment;

public interface PaymentGateway {
    Payment save(Payment payment);

}
