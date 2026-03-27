package com.healthcare.app;
// Bhaii BillingService Kyu Add kiya 
public class BillingService {

    public double calculateBill(double consultationFee, double medicineCost) {
        return consultationFee + medicineCost;
    }

    public boolean isEligibleForDiscount(int age) {
        return age > 60;
    }
}
