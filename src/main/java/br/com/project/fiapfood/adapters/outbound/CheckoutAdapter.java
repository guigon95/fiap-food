package br.com.project.fiapfood.adapters.outbound;

import br.com.project.fiapfood.adapters.inbound.entity.CheckoutEntity;
import br.com.project.fiapfood.adapters.inbound.mapper.CheckoutMapper;
import br.com.project.fiapfood.adapters.outbound.repository.CheckoutRepository;
import br.com.project.fiapfood.application.core.domain.Checkout;
import br.com.project.fiapfood.application.port.out.CheckoutPort;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CheckoutAdapter implements CheckoutPort {

    private final CheckoutRepository checkoutRepository;

    private final CheckoutMapper checkoutMapper;

    @Override
    public Checkout save(Checkout checkout) {
        var checkoutEntity = checkoutMapper.checkouToCheckoutEntity(checkout);

        Optional<CheckoutEntity> optional = checkoutRepository.findByIdPedido(checkoutEntity.getIdPedido());
        if(optional.isPresent())
            return checkoutMapper.checkoutEntityToCheckout(optional.get());

        return checkoutMapper.checkoutEntityToCheckout(checkoutRepository.save(checkoutEntity));
    }
}
