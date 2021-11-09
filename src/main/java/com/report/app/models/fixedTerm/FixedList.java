package com.report.app.models.fixedTerm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedList {
    private FixedTerm fixed;
    private List<TransactionFixedTerm> transactions;
}
