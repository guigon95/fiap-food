package br.com.project.fiapfood.adapter.mapper;

import br.com.project.fiapfood.domain.model.Checkout;
import br.com.project.fiapfood.external.infrastructure.entity.CheckoutEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {

    Checkout checkoutEntityToCheckout(CheckoutEntity checkoutEntity);

    CheckoutEntity checkouToCheckoutEntity(Checkout checkout);


}
