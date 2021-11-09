package com.report.app.models;

import com.report.app.models.credit.CreditCard;
import com.report.app.models.current.CurrentAccount;
import com.report.app.models.customer.Customer;
import com.report.app.models.fixedTerm.FixedTerm;
import com.report.app.models.saving.SavingAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportGeneral {
    private Customer customer;
    private List<CreditCard> creditCards;
    private List<CurrentAccount> currentsAccounts;
    private List<SavingAccount> savingAccounts;
    private List<FixedTerm> fixedTermAccounts;
}
