package br.com.project.fiapfood.application.exception;

import br.com.project.fiapfood.adapters.dto.response.exceptions.ErrorMessage;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InvalidFieldException extends RuntimeException {
    String message;
    List<ErrorMessage.CauseError> causeErrorList;

}
