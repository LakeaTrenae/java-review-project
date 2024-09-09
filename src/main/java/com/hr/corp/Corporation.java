package com.hr.corp;

import com.gov.irs.TaxPayer;

public class Corporation implements TaxPayer {
    private String name;
    private double monthlyIncome;

    private static final double TAX_RATE = 0.20; // 20%

    public Corporation(String name, double monthlyIncome) {
        this.name = name;
        this.monthlyIncome = monthlyIncome;
    }

    public double computeMonthlyTaxToPay() {
        return monthlyIncome * TAX_RATE;
    }

    @Override
    public String toString() {
        return String.format("Corporation Name: %s\nMonthly Income: $%.2f\nMonthly Tax: $%.2f", name, monthlyIncome, computeMonthlyTaxToPay());
    }
}