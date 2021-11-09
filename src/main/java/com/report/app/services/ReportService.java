package com.report.app.services;

import com.report.app.models.credit.Credit;
import com.report.app.models.credit.CreditCard;
import com.report.app.models.credit.CreditTransaction;
import com.report.app.models.current.CurrentAccount;
import com.report.app.models.current.TransactionCurrentAccount;
import com.report.app.models.customer.Customer;
import com.report.app.models.fixedTerm.FixedTerm;
import com.report.app.models.fixedTerm.TransactionFixedTerm;
import com.report.app.models.saving.SavingAccount;
import com.report.app.models.saving.SavingAccountTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface ReportService {
    // CUSTOMER
    public Mono<Customer> findCustomerByIdCustomer(String id);

    // CREDIT
    public Flux<CreditCard> findCreditCards();
    public Flux<Credit> findCreditByIdCreditCard(String id);
    public Flux<CreditTransaction> FindCreditPayByIdCreditCard(String id);
    public Flux<CreditCard> findCreditCardByIdCustomer(String id);

    // FIXED
    public Flux<FixedTerm> findFixeds();
    public Flux<TransactionFixedTerm> findTransactionFixedByIdFixed(String id);
    public Flux<FixedTerm> findFixedTermByIdCustomer(String id);

    // CURRENT
    public Flux<CurrentAccount> findCurrents();
    public Flux<TransactionCurrentAccount> findTransactionCurrentByIdCurrent(String id);
    public Flux<CurrentAccount> findCurrentAccountByIdCustomer(String id);

    // SAVING
    public Flux<SavingAccount> findSavings();
    public Flux<SavingAccountTransaction> findTransactionSavingsByIdSaving(String id);
    public Flux<SavingAccount> findSavingAccountByIdCustomer(String id);

    //TOOL
    boolean isWithInRange(LocalDateTime createAt, LocalDate start, LocalDate end);
}
