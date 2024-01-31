package br.com.project.fiapfood.adapter.mapper;

import br.com.project.fiapfood.adapter.dto.request.OrderRequest;
import br.com.project.fiapfood.adapter.dto.request.PaymentRequest;
import br.com.project.fiapfood.adapter.dto.response.PaymentResponse;
import br.com.project.fiapfood.domain.model.Order;
import br.com.project.fiapfood.domain.model.Payment;
import br.com.project.fiapfood.domain.usecase.OrderUseCase;
import br.com.project.fiapfood.external.infrastructure.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper {

    @Autowired
    private OrderUseCase orderUseCase;

    public abstract Payment paymentEntityToPayment(PaymentEntity paymentEntity);

    public abstract PaymentEntity paymentToPaymentEntity(Payment payment);

    @Mapping(target = "order", source = "order", qualifiedByName = "fromOrderIdToOrder")
    public abstract Payment paymentRequestToPayment(PaymentRequest paymentRequest);

    @Named("fromOrderIdToOrder")
    protected Order fromOrderIdToOrder(Long order) {
        if(order != null)
            return orderUseCase.findById(order);

        return null;
    }

    public abstract PaymentResponse paymentToPaymentResponse(Payment payment);
}
