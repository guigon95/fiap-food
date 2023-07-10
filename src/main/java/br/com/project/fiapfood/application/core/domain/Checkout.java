package br.com.project.fiapfood.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Checkout {

    private Long ordem;
    private Long orderId;
}
