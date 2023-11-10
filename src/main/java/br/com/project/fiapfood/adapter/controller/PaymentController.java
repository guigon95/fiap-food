package br.com.project.fiapfood.adapter.controller;

import br.com.project.fiapfood.adapter.dto.request.PaymentRequest;
import br.com.project.fiapfood.adapter.dto.response.PaymentResponse;
import br.com.project.fiapfood.adapter.mapper.PaymentMapper;
import br.com.project.fiapfood.domain.usecase.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentMapper paymentMapper;

    private final PaymentUseCase paymentUseCase;
    public ResponseEntity<PaymentResponse> savePayment(PaymentRequest paymentRequest) {
        var payment = paymentMapper.paymentRequestToPayment(paymentRequest);
        return ResponseEntity.ok(paymentMapper.paymentToPaymentResponse(paymentUseCase.createPayment(payment)));
    }
}
