package br.com.project.fiapfood.external.infrastructure.repository;

import br.com.project.fiapfood.adapter.gateway.PaymentGateway;
import br.com.project.fiapfood.adapter.mapper.PaymentMapper;
import br.com.project.fiapfood.domain.model.Payment;
import br.com.project.fiapfood.external.infrastructure.repository.JPA.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public Payment save(Payment payment) {
        var paymentEntity = paymentMapper.paymentToPaymentEntity(payment);
        return paymentMapper.paymentEntityToPayment(paymentRepository.save(paymentEntity));
    }
}
