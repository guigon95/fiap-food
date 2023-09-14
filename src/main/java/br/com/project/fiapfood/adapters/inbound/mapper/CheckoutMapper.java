package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.CheckoutEntity;
import br.com.project.fiapfood.adapters.inbound.entity.ClientEntity;
import br.com.project.fiapfood.application.core.domain.Checkout;
import br.com.project.fiapfood.application.core.domain.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {

    Checkout checkoutEntityToCheckout(CheckoutEntity checkoutEntity);

    CheckoutEntity checkouToCheckoutEntity(Checkout checkout);


}
