package org.yatra.commoncodes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraCommonCodes {

	public static WebDriverWait webDriverWait;
	public static WebDriver driver;
	public static WebDriverWait waitAlways(WebElement locator) {
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		return webDriverWait;
	}
}
