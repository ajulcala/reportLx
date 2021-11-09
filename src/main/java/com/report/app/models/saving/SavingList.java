package com.report.app.models.saving;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingList {
    private SavingAccount saving;
    private List<SavingAccountTransaction> transactions;
}
