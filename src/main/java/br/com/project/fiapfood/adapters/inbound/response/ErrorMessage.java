package br.com.project.fiapfood.adapters.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    HttpStatus httpStatus;
    LocalDateTime localDateTime;
    String message;

}
