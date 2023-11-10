package br.com.project.fiapfood.external.api;

import br.com.project.fiapfood.adapter.controller.PaymentController;
import br.com.project.fiapfood.adapter.dto.request.PaymentRequest;
import br.com.project.fiapfood.adapter.dto.request.ProductRequest;
import br.com.project.fiapfood.adapter.dto.response.PaymentResponse;
import br.com.project.fiapfood.adapter.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Tag(name = "Payments", description = "Access to payment management")
public class PaymentApi {

    private final PaymentController paymentController;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentResponse.class)) }),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content) })
    public ResponseEntity<PaymentResponse> savePayment(@RequestBody @Valid PaymentRequest paymentRequest){
        return paymentController.savePayment(paymentRequest);
    }
}
