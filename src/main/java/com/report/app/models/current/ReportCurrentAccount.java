package com.report.app.models.current;

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
public class ReportCurrentAccount {
    private ConsultationPerProduct data;
    private List<CurrentList> result;
}
