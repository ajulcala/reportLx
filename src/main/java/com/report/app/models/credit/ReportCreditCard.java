package com.report.app.models.credit;

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
public class ReportCreditCard {
    private ConsultationPerProduct data;
    private List<CreditCardList> result;
}
