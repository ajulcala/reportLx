package com.report.app.models.fixedTerm;

import com.report.app.models.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFixedTerm {
    private String id;
    private FixedTerm fixedTerm;
    private String transactionCode;
    private TypeTransaction typeTransaction;
    private Double transactionAmount;
    private Double commissionAmount;
    private LocalDateTime transactionDateTime;
}
