package br.com.project.fiapfood.application.core.exception;

import lombok.Builder;
import lombok.Data;
import br.com.project.fiapfood.adapter.dto.response.exceptions.ErrorMessage;
import lombok.EqualsAndHashCode;

import java.util.List;

@Builder
@Data
public class InvalidFieldException extends RuntimeException {
    String message;
    List<ErrorMessage.CauseError> causeErrorList;

}
