package com.coryfoy.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class OrderEntryStepDefs {
    WebDriver browser;
    int currentLineItem = 1;

    @Given("^I am on the order form$")
    public void iAmOnTheOrderForm() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/foyc/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        browser = new ChromeDriver(options);

        browser.navigate().to("http://localhost:8080/orderprocessor");
    }

    @After
    public void tearDown() throws Throwable {
        browser.quit();
    }

    @And("^I enter in a \"([^\"]*)\" that costs \"([^\"]*)\"$")
    public void iEnterInAThatCosts(String item, String cost) throws Throwable {
        String itemBoxId = "item" + currentLineItem;
        String amountBoxId = "amount" + currentLineItem;
        browser.findElement(By.id(itemBoxId)).sendKeys(item);
        browser.findElement(By.id(amountBoxId)).sendKeys(cost);
        browser.switchTo().activeElement().sendKeys(Keys.TAB);
        currentLineItem = currentLineItem + 1;
    }

    @Then("^I should see a discount amount of \"([^\"]*)\"$")
    public void iShouldSeeADiscountAmountOf(String expectedDiscount) throws Throwable {
        String displayedDiscount = browser.findElement(By.id("discounts-display")).getText();
        assertEquals(expectedDiscount, displayedDiscount);
    }

    @And("^I should see a total of \"([^\"]*)\"$")
    public void iShouldSeeATotalOf(String expectedTotal) throws Throwable {
        String displayedTotal = browser.findElement(By.id("total-display")).getText();
        assertEquals(expectedTotal, displayedTotal);
    }
}
