package com.report.app.controllers;

import com.report.app.models.ConsultationPerProduct;
import com.report.app.models.ReportGeneral;
import com.report.app.models.credit.CreditCardList;
import com.report.app.models.credit.ReportCreditCard;
import com.report.app.models.current.CurrentList;
import com.report.app.models.current.ReportCurrentAccount;
import com.report.app.models.customer.Customer;
import com.report.app.models.fixedTerm.FixedList;
import com.report.app.models.fixedTerm.ReportFixedAccount;
import com.report.app.models.saving.ReportSavingAccount;
import com.report.app.models.saving.SavingList;
import com.report.app.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/reports")
public class ReportController extends ReportCreditCard {
    @Autowired
    private ReportService service;

    @GetMapping("/general/{id}")
    public Mono<ReportGeneral> reportGeneral(@PathVariable String id) {

        Mono<Customer> customer = service.findCustomerByIdCustomer(id);

        Mono<ReportGeneral> report = customer.flatMap(cus -> service.findCreditCardByIdCustomer(cus.getId())
                .collectList()
                .flatMap(credit -> service.findCurrentAccountByIdCustomer(cus.getId()).collectList()
                        .flatMap(current -> service.findSavingAccountByIdCustomer(cus.getId()).collectList()
                                .flatMap(saving -> service.findFixedTermByIdCustomer(cus.getId()).collectList()
                                        .map(fixed -> new ReportGeneral(cus, credit, current, saving, fixed))))));
        return report;
    }

    @PostMapping("/byProduct/CreditCard")
    public Mono<ReportCreditCard> reportForCreditCard(@RequestBody ConsultationPerProduct consulta) {

        return service.findCreditCards()
                .filter(c -> service.isWithInRange(c.getCreateAt(), consulta.getStartDate(), consulta.getEndingDate()))
                .flatMap(cards -> {
                    return service.findCreditByIdCreditCard(cards.getId()).collectList()
                            .flatMap(credit -> service.FindCreditPayByIdCreditCard(cards.getId()).collectList()
                                    .map(pays -> new CreditCardList(cards, credit, pays)));
                }).collectList().map(rpt -> new ReportCreditCard(consulta, rpt));
    }

    @PostMapping("/byProduct/FixedTerm")
    public Mono<ReportFixedAccount> reportForFixedTerm(@RequestBody ConsultationPerProduct consulta) {

        return service.findFixeds()
                .filter(c -> service.isWithInRange(c.getCreateAt(), consulta.getStartDate(), consulta.getEndingDate()))
                .flatMap(card -> {
                    return service.findTransactionFixedByIdFixed(card.getId()).collectList()
                            .map(pays -> new FixedList(card, pays));
                }).collectList().map(rpt -> new ReportFixedAccount(consulta, rpt));
    }

    @PostMapping("/byProduct/CurrentAccount")
    public Mono<ReportCurrentAccount> reportForCurrentAccount(@RequestBody ConsultationPerProduct consulta) {

        return service.findCurrents()
                .filter(c -> service.isWithInRange(c.getCreateAt(), consulta.getStartDate(), consulta.getEndingDate()))
                .flatMap(card -> {
                    return service.findTransactionCurrentByIdCurrent(card.getId()).collectList()
                            .map(pays -> new CurrentList(card, pays));
                }).collectList().map(rpt -> new ReportCurrentAccount(consulta, rpt));
    }

    @PostMapping("/byProduct/SavingAccount")
    public Mono<ReportSavingAccount> reportForSavingAccount(@RequestBody ConsultationPerProduct consulta) {

        return service.findSavings()
                .filter(c -> service.isWithInRange(c.getCreateAt(), consulta.getStartDate(), consulta.getEndingDate()))
                .flatMap(card -> {
                    return service.findTransactionSavingsByIdSaving(card.getId()).collectList()
                            .map(pays -> new SavingList(card, pays));
                }).collectList().map(rpt -> new ReportSavingAccount(consulta, rpt));
    }
}
