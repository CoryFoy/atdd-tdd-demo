package com.coryfoy.discounter;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class DiscountCalculatorTest extends TestCase {

    @Test
    public void testCalculatorReturnsNoDiscountForNoAmount() {
        DiscountCalculator calc = new DiscountCalculator();
        double orderTotal = 0.00;
        double expectedDiscountTotal = 0.00;
        assertEquals(expectedDiscountTotal, calc.discountFor(orderTotal));
    }

    @Test
    public void testCalculatorReturnsPercentForSmallTotals() {
        DiscountCalculator calc = new DiscountCalculator();
        double orderTotal = 5.00;
        double expectedDiscountTotal = 0.50;
        assertEquals(expectedDiscountTotal, calc.discountFor(orderTotal));
    }

    @Test
    public void testCalculatorReturnsFixedDiscountForMediumTotals() {
        DiscountCalculator calc = new DiscountCalculator();
        double orderTotal = 15.00;
        double expectedDiscountTotal = 1.00;
        assertEquals(expectedDiscountTotal, calc.discountFor(orderTotal));
    }

    @Test
    public void testCalculatorReturnsLargePercentageDiscountForLargeTotals() {
        DiscountCalculator calc = new DiscountCalculator();
        double orderTotal = 30.00;
        double expectedDiscountTotal = 6.00;
        assertEquals(expectedDiscountTotal, calc.discountFor(orderTotal));
    }

    @Test
    public void testCalculatorReturnsTwoDecimalPrecision() {
        DiscountCalculator calc = new DiscountCalculator();
        double orderTotal = 9.99;
        double expectedDiscountTotal = 0.99;
        assertEquals(expectedDiscountTotal, calc.discountFor(orderTotal));
    }

    @Test
    public void testCalculatorConsidersTwentyDollarsLarge() {
        DiscountCalculator calc = new DiscountCalculator();
        double orderTotal = 20.00;
        double expectedDiscountTotal = 4.00;
        assertEquals(expectedDiscountTotal, calc.discountFor(orderTotal));
    }
}