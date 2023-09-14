package br.com.project.fiapfood.domain.enums;


import br.com.project.fiapfood.adapters.dto.response.exceptions.ErrorMessage;
import br.com.project.fiapfood.application.exception.InvalidFieldException;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public enum Category {
    HAMBURGUER, ACCOMPANIMENT, DRINK, DESSERT;

    @JsonCreator
    public static Category create(String value) {
        if (value == null) {
            return null;
        }
        for (Category v : values()) {
            if (value.equalsIgnoreCase(v.name())) {
                return v;
            }
        }
        throw InvalidFieldException.builder().message("The field status cannot have the value "+value).causeErrorList(List.of(
                ErrorMessage.CauseError.builder().cause("Invalid value").field("category").build()
        )).build();
    }
}
