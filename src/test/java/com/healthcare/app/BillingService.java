package com.healthcare.app;

public class BillingService {

    public double calculateBill(double consultationFee, double medicineCost) {
        return consultationFee + medicineCost;
    }

    public boolean isEligibleForDiscount(int age) {
        return age > 60;
    }
}
