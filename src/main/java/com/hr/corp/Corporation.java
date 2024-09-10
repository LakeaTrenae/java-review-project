package com.hr.corp;

import com.gov.irs.TaxPayer;


public class Corporation implements TaxPayer {
    private String name;
    private double monthlyIncome;
    private Auditor auditor;

    private static final double TAX_RATE = 0.20; // 20%
    public static final double MONTHLY_FIXED_COST = 10000.0;
    public static final double MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY = 10000.0;
    public static final double MINIMUM_PROFIT_TO_MAKE_TO_BE_OK = 0.0;

    public Corporation(String name, double monthlyIncome) {
        this.name = name;
        this.monthlyIncome = monthlyIncome;
    }

    public Corporation(String name, double monthlyIncome, Auditor auditor) {
        this.name = name;
        this.monthlyIncome = monthlyIncome;
        this.auditor = auditor;
    }

    public double computeMonthlyTaxToPay() {
        return monthlyIncome * TAX_RATE;
    }

    public double computeMonthlyProfit(double monthlyFixedCost) {
        if (auditor == null) {
            // Handle case where auditor is not set; return a default value or handle accordingly
            return 0.0;
        }
        return auditor.computeMonthlyProfit(monthlyIncome, monthlyFixedCost, computeMonthlyTaxToPay());
    }

    public CompanyHealth performMonthlyAudit() {
        if (auditor == null) {
            return CompanyHealth.SICK;
        }

        double monthlyProfit = auditor.computeMonthlyProfit(monthlyIncome, MONTHLY_FIXED_COST, computeMonthlyTaxToPay());

        CompanyHealth companyHealth = CompanyHealth.SICK;

        if (monthlyProfit >= MINIMUM_PROFIT_TO_MAKE_TO_BE_HEALTHY) {
            companyHealth = CompanyHealth.HEALTHY;
        } else if (monthlyProfit >= MINIMUM_PROFIT_TO_MAKE_TO_BE_OK) {
            companyHealth = CompanyHealth.OK;
        }

        return companyHealth;
    }

    @Override
    public String toString() {
        return String.format("Corporation Name: %s\nMonthly Income: $%.2f\nMonthly Tax: $%.2f",
                name, monthlyIncome, computeMonthlyTaxToPay());
    }
}