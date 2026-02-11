package com.janus.inventory.dto;

import com.janus.inventory.model.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TransactionRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Long warehouseId;

    @NotNull
    private TransactionType transactionType;

    @NotNull
    @Positive
    private Integer quantity;

    @Size(max = 100)
    private String referenceId;

    @NotBlank
    private String createdBy;

}
