package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class vwo_proj {
    @Test
    public void testVWOLoginTitle() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");

        WebDriver driver = new EdgeDriver(options);
        //driver.get("app.vwo.com"); // http mandatory
        driver.get("https://app.vwo.com");
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("sudheepjk@hotmail.com");

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("12qwaszx!@QW");

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardName = webDriverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sudheep Joseph Kurian')]")));

        Assert.assertEquals(dashboardName.getText(), "Sudheep Joseph Kurian");
        System.out.println(dashboardName.getText());



        driver.quit();
    }
}