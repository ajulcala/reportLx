package com.report.app.models.credit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardList {
    private CreditCard creditCard;
    private List<Credit> credits;
    private List<CreditTransaction> creditsPays;
}
