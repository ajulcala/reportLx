package com.report.app.models.current;

import com.report.app.models.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCurrentAccount {
    @Id
    private String id;
    @NotNull
    private CurrentAccount currentAccount;
    @NotBlank
    private String transactionCode;
    @Valid
    private TypeTransaction typeTransaction;
    @NotNull
    private Double transactionAmount;
    private Double commissionAmount;
    private LocalDateTime transactionDate;
}
