package br.com.project.fiapfood.adapters.inbound.response.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InvalidFieldException extends RuntimeException {
    String message;
    List<ErrorMessage.CauseError> causeErrorList;

}
