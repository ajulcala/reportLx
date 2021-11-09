package com.report.app.models.saving;

import com.report.app.models.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavingAccountTransaction {
    @Id
    private String id;
    @NotNull
    private SavingAccount savingAccount;
    @NotBlank
    private String transactionCode;
    @NotNull
    private TypeTransaction typeTransaction;
    @NotNull
    private Double transactionAmount;
    private Double commissionAmount;
    private LocalDateTime transactionDate;
}
