package br.com.project.fiapfood.adapters.mapper;

import br.com.project.fiapfood.adapters.dto.request.ItemOrderRequest;
import br.com.project.fiapfood.adapters.dto.response.ItemOrderResponse;
import br.com.project.fiapfood.domain.model.ItemOrder;
import br.com.project.fiapfood.domain.model.Product;
import br.com.project.fiapfood.domain.usecase.ProductUseCase;
import br.com.project.fiapfood.infrastructure.entity.ItemOrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class ItemOrderMapper {

    @Autowired
    private ProductUseCase productUseCase;

    @Mapping(target = "product", source = "productId", qualifiedByName = "fromUUIDToProduct")
    public abstract ItemOrder itemOrderRequestToItemOrder(ItemOrderRequest itemOrderRequest);

    @Named("fromUUIDToProduct")
    protected Product fromUUIDToProduct(UUID id) {
        return productUseCase.findById(id);
    }

    @Mapping(target = "order", ignore = true)
    public abstract ItemOrder itemOrderEntityToItemOrder(ItemOrderEntity itemOrderEntity);


    public abstract ItemOrderEntity itemOrderToItemOrderEntity(ItemOrder itemOrder);

    public abstract ItemOrderResponse itemOrderToItemOrderResponse(ItemOrder itemOrder);

    @Named("fromItemOrderEntityToItemOrder")
    protected List<ItemOrder> fromItemOrderEntityToItemOrder(List<ItemOrderEntity> itemOrderEntities) {

        List<ItemOrder> itemOrders = new ArrayList<>();

        for (ItemOrderEntity itemOrderEntity: itemOrderEntities) {
            itemOrders.add(itemOrderEntityToItemOrder(itemOrderEntity));
        }
        return itemOrders;
    }

    public abstract List<ItemOrderEntity> itemOrderListToOrderEntityList(List<ItemOrder> ItemOrder);
    public abstract List<ItemOrder> itemOrderEntityListToOrderList(List<ItemOrderEntity> itemOrderEntities);

}
