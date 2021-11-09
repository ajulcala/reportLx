package com.report.app.services.impl;

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
import com.report.app.services.ReportService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class ReportServiceImpl implements ReportService {
    private final WebClient webClient;

    @Value("${config.base.apigatewey}")
    private String uri;

    public ReportServiceImpl() {
        this.webClient = WebClient.builder().baseUrl(this.uri).build();
    }

    @Override
    public Mono<Customer> findCustomerByIdCustomer(String id) {
        return webClient.get().uri(this.uri + "/customer/customer/find/{id}", id).accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Customer.class);
    }

    @Override
    public Flux<CreditCard> findCreditCards() {
        return webClient.get().uri(this.uri + "/creditcard/creditcard/list")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditCard.class);
    }

    @Override
    public Flux<Credit> findCreditByIdCreditCard(String id) {
        return webClient.get().uri(this.uri + "/credit-charge/creditCharge/findByIdCreditCard/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(Credit.class);
    }

    @Override
    public Flux<CreditTransaction> FindCreditPayByIdCreditCard(String id) {
        return webClient.get().uri(this.uri + "/credit-pay/creditPaid/findByIdCreditCard/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditTransaction.class);
    }

    @Override
    public Flux<CreditCard> findCreditCardByIdCustomer(String id) {
        return webClient.get().uri(this.uri + "/creditcard/creditcard/findCreditCards/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CreditCard.class);
    }

    @Override
    public Flux<FixedTerm> findFixeds() {
        return webClient.get().uri(this.uri + "/fixed-account/fixedTerm/list")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(FixedTerm.class);
    }

    @Override
    public Flux<TransactionFixedTerm> findTransactionFixedByIdFixed(String id) {
        return webClient.get().uri(this.uri + "/fixed-term-transaction/transactionFixedTerm/findByFixedId/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(TransactionFixedTerm.class);
    }

    @Override
    public Flux<FixedTerm> findFixedTermByIdCustomer(String id) {
        return webClient.get().uri(this.uri + "/fixed-account/fixedTerm/findAccountByCustomerId/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(FixedTerm.class);
    }

    @Override
    public Flux<CurrentAccount> findCurrents() {
        return webClient.get().uri(this.uri + "/current-account/currentAccount/list")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CurrentAccount.class);
    }

    @Override
    public Flux<TransactionCurrentAccount> findTransactionCurrentByIdCurrent(String id) {
        return webClient.get().uri(this.uri + "/current-account-transaction/transactionCurrentAccount/findByCurrentAccountId/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(TransactionCurrentAccount.class);
    }

    @Override
    public Flux<CurrentAccount> findCurrentAccountByIdCustomer(String id) {
        return webClient.get().uri(this.uri + "/current-account/currentAccount/findAccountByCustomerId/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(CurrentAccount.class);
    }

    @Override
    public Flux<SavingAccount> findSavings() {
        return webClient.get().uri(this.uri + "/saving-account/savingAccount/list")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccount.class);
    }

    @Override
    public Flux<SavingAccountTransaction> findTransactionSavingsByIdSaving(String id) {
        return webClient.get().uri(this.uri + "/saving-account-transaction/transactionSavingAccount/findBySavingAccountId/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccountTransaction.class);
    }

    @Override
    public Flux<SavingAccount> findSavingAccountByIdCustomer(String id) {
        return webClient.get().uri(this.uri + "/saving-account/savingAccount/findAccountByCustomerId/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(SavingAccount.class);
    }

    @Override
    public boolean isWithInRange(LocalDateTime createAt, LocalDate start, LocalDate end) {
        return createAt.toLocalDate().isAfter(start) && createAt.toLocalDate().isBefore(end);
    }
}
