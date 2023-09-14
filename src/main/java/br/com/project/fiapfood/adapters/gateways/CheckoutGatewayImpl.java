package br.com.project.fiapfood.adapters.gateways;

import br.com.project.fiapfood.external.gateway.CheckoutGateway;
import br.com.project.fiapfood.infrastructure.entity.CheckoutEntity;
import br.com.project.fiapfood.adapters.mapper.CheckoutMapper;
import br.com.project.fiapfood.infrastructure.repository.JPA.CheckoutRepository;
import br.com.project.fiapfood.domain.model.Checkout;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CheckoutGatewayImpl implements CheckoutGateway {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutMapper checkoutMapper;

    @Override
    public Checkout save(Checkout checkout) {
        var checkoutEntity = checkoutMapper.checkouToCheckoutEntity(checkout);
        return checkoutMapper.checkoutEntityToCheckout(checkoutRepository.save(checkoutEntity));
    }

    @Override
    public Checkout findByOrderId(Long id) {
        CheckoutEntity checkout = checkoutRepository.findByOrderId(id).
                orElse(null);
            return checkoutMapper.checkoutEntityToCheckout(checkout);
    }
}
