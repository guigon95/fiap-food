package br.com.project.fiapfood.domain.enums;


import br.com.project.fiapfood.adapters.dto.response.exceptions.ErrorMessage;
import br.com.project.fiapfood.application.exception.InvalidFieldException;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public enum Status {
    ACTIVE, DESACTIVE;

    @JsonCreator
    public static Status create(String value) {
        if (value == null) {
            return null;
        }
        for (Status v : values()) {
            if (value.equalsIgnoreCase(v.name())) {
                return v;
            }
        }
        throw InvalidFieldException.builder().message("The field status cannot have the value "+value).causeErrorList(List.of(
                ErrorMessage.CauseError.builder().cause("Invalid value").field("status").build()
        )).build();
    }
}
