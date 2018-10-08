package com.coryfoy.stepdefinitions;

import com.coryfoy.discounter.DiscountCalculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class DiscountStepDefs {
    double orderTotal;
    double discountTotal;

    @Given("^the order (.*)$")
    public void theOrderTotal(double orderItemTotal) throws Throwable {
        orderTotal = orderItemTotal;
    }

    @When("^the discount is calculated$")
    public void theDiscountIsCalculated() throws Throwable {
        DiscountCalculator calculator = new DiscountCalculator();
        discountTotal = calculator.discountFor(orderTotal);
    }

    @Then("^the discount total is (.*)$")
    public void theDiscountTotalIsDiscountAmount(double expectedDiscountAmount) throws Throwable {
        assertEquals(expectedDiscountAmount, discountTotal, 0.001);
    }
}
