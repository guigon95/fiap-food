package br.com.project.fiapfood.adapters.inbound;

import br.com.project.fiapfood.application.core.domain.Checkout;
import br.com.project.fiapfood.application.port.in.CheckoutServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutServicePort checkoutServicePort;

    @PostMapping("/{id}")
    public void checkout(@PathVariable Long id){

        checkoutServicePort.save(new Checkout(null, id));

    }
}
