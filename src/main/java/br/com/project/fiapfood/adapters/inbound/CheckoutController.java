package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.application.core.domain.Checkout;
import br.com.project.fiapfood.application.port.in.CheckoutServicePort;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
@Tag(name = "Checkout", description = "Access to checkout management")
public class CheckoutController {

    private final CheckoutServicePort checkoutServicePort;

    @PostMapping("/{id}")
    public void checkout(@PathVariable @Schema(description = "order id") Long id){

        checkoutServicePort.save(new Checkout(null, id));

    }
}
