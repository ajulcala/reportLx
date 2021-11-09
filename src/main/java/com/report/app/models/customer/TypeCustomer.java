package com.report.app.models.customer;

import lombok.Data;

@Data
public class TypeCustomer {
    private String id;
    private EnumTypeCustomer value;
    private SubType subType;
    public enum EnumTypeCustomer {
        EMPRESARIAL, PERSONAL
    }
}
