package Taxes;

public class TaxReceipt {
    private String BusinessName;
    private double amount;

    public TaxReceipt(String BusinessName, double amount) {
        this.BusinessName = BusinessName;
        if (amount < 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }
    public String getBusinessName() { return BusinessName; }
    public double getAmount() { return amount; }
}

