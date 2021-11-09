package com.report.app.models.current;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentList {
    private CurrentAccount current;
    private List<TransactionCurrentAccount> transactions;
}
