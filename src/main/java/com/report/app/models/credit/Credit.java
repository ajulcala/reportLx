package com.report.app.models.credit;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
    private String id;
    private CreditCard creditCard;
    private Status status;
    private Double amount;
    private LocalDateTime date;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate expirationDate;

    public enum Status{
        CREATED,
        PAIDOUT,
        DEFEATED
    }
}
