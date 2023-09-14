package br.com.project.fiapfood.external.api;

import br.com.project.fiapfood.adapter.controller.CheckoutController;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
@Tag(name = "Checkout", description = "Access to checkout management")
public class CheckoutApi {

    private final CheckoutController checkoutController;

    @PostMapping("/{id}")
    public ResponseEntity<Void> checkout(@PathVariable @Schema(description = "order id") Long id){
        return checkoutController.checkout(id);
    }
}
