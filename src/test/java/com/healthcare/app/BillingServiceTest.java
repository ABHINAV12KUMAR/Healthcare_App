package com.healthcare.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BillingServiceTest {

    @Test
    void testCalculateBill() {
        BillingService service = new BillingService();
        double result = service.calculateBill(500, 200);
        assertEquals(700, result);
    }

    @Test
    void testDiscountEligible() {
        BillingService service = new BillingService();
        boolean result = service.isEligibleForDiscount(65);
        assertTrue(result);
    }
}
