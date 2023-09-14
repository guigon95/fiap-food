package br.com.project.fiapfood.adapters.mapper;

import br.com.project.fiapfood.domain.model.Checkout;
import br.com.project.fiapfood.infrastructure.entity.CheckoutEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {

    Checkout checkoutEntityToCheckout(CheckoutEntity checkoutEntity);

    CheckoutEntity checkouToCheckoutEntity(Checkout checkout);


}
