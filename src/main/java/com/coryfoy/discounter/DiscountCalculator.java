package com.coryfoy.discounter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountCalculator {
    public double discountFor(double orderTotal) {
        double result = 1.0;

        if(orderTotal >= 20.0) {
            result = orderTotal * 0.20;
        } else if(orderTotal < 10.0) {
            result = orderTotal * 0.10;
        }

        BigDecimal dec = new BigDecimal(result);
        return dec.setScale(2, RoundingMode.FLOOR).doubleValue();
    }
}
