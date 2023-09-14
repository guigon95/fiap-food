package br.com.project.fiapfood.adapter.controller;

import br.com.project.fiapfood.domain.model.Checkout;
import br.com.project.fiapfood.domain.usecase.CheckoutUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutUseCase checkoutUseCase;

    public ResponseEntity<Void> checkout(Long id){
        checkoutUseCase.createCheckout(new Checkout(null, id));
        return ResponseEntity.ok().build();
    }
}
