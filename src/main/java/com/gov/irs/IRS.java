package com.gov.irs;

public class IRS {
    private TaxPayer[] taxPayers = new TaxPayer[100];
    private int currentIndex = 0;

    /**
     * Registers a new taxpayer in the system.
     */
    public void register(TaxPayer taxPayer) {
        if (currentIndex < taxPayers.length) {
            taxPayers[currentIndex] = taxPayer;
            currentIndex++;
        } else {
            System.out.println("Cannot register more taxpayers. The system is full.");
        }
    }

    /**
     * Computes the total monthly tax to collect from all registered taxpayers.
     *
     * @return the total monthly tax to collect
     */
    public double computeTotalMonthlyTaxToCollect() {
        double totalTax = 0.0;
        for (int i = 0; i < currentIndex; i++) {
            totalTax += taxPayers[i].computeMonthlyTaxToPay();
        }
        return totalTax;
    }
}
