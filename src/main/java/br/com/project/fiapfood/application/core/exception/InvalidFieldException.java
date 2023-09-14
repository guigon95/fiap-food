package br.com.project.fiapfood.application.core.exception;

import br.com.project.fiapfood.adapters.inbound.response.exceptions.ErrorMessage;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InvalidFieldException extends RuntimeException {
    String message;
    List<ErrorMessage.CauseError> causeErrorList;

}
