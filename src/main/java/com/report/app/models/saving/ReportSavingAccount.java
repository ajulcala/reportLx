package com.report.app.models.saving;

import com.report.app.models.ConsultationPerProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ReportSavingAccount {
    private ConsultationPerProduct data;
    private List<SavingList> result;
}
