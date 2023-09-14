package br.com.project.fiapfood.external.infrastructure.repository;

import br.com.project.fiapfood.adapter.gateway.CheckoutGateway;
import br.com.project.fiapfood.external.infrastructure.entity.CheckoutEntity;
import br.com.project.fiapfood.adapter.mapper.CheckoutMapper;
import br.com.project.fiapfood.external.infrastructure.repository.JPA.CheckoutRepository;
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
