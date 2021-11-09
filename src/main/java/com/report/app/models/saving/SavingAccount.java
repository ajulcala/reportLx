package com.report.app.models.saving;

import com.report.app.models.customer.Customer;
import com.report.app.models.customer.Managers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingAccount {
    private String id;
    private Customer customer;
    private String cardNumber;
    private Integer limitTransactions;
    private Integer freeTransactions;
    private Double commissionTransactions;
    private Double balance;
    private Double minAverageVip;
    private LocalDateTime createAt;
    private List<Managers> owners;
    private List<Managers> signatories;
}
