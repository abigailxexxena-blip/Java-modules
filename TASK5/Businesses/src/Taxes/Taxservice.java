package Taxes;

import Registration.Business;

public class Taxservice {
    // Returns null if there is no business or the income is not positive
    public TaxReceipt fileTax(Business business, double income) {
        if (business == null) {
            return null;
        }
        if (income <= 0) {
            return null;
        }
        return new TaxReceipt(business.getName(), income * 0.30);   // 30% tax
    }
}
