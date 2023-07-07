package br.com.project.fiapfood.adapters.inbound.mapper;

import br.com.project.fiapfood.adapters.inbound.entity.ItemOrderEntity;
import br.com.project.fiapfood.adapters.inbound.request.ItemOrderRequest;
import br.com.project.fiapfood.adapters.inbound.response.ItemOrderResponse;
import br.com.project.fiapfood.application.core.domain.ItemOrder;
import br.com.project.fiapfood.application.core.domain.Product;
import br.com.project.fiapfood.application.port.in.ProductServicePort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class ItemOrderMapper {

    @Autowired
    private ProductServicePort productServicePort;

    @Mapping(target = "product", source = "productId", qualifiedByName = "fromUUIDToProduct")
    public abstract ItemOrder itemOrderRequestToItemOrder(ItemOrderRequest itemOrderRequest);

    @Named("fromUUIDToProduct")
    protected Product fromUUIDToProduct(UUID id) {
        return productServicePort.findById(id);
    }

    @Mapping(target = "order", ignore = true)
    public abstract ItemOrder itemOrderEntityToItemOrder(ItemOrderEntity itemOrderEntity);

    public abstract ItemOrderEntity itemOrderToItemOrderEntity(ItemOrder itemOrder);

    public abstract ItemOrderResponse itemOrderToItemOrderResponse(ItemOrder itemOrder);
}
