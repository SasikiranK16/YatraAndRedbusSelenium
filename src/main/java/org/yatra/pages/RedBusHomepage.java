package org.yatra.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusHomepage {

	public WebDriver driver;
	public WebDriverWait webDriverWait;

	public RedBusHomepage(WebDriver driver) {
		this.driver = driver;
		this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[starts-with(@class,'placeHolderContainer___2f65b9')])[1]")
	private WebElement fromSource;
	@FindBy(xpath = "(//*[starts-with(@class,'inputField___44716f')])")
	private WebElement inputWrapper;
	@FindBy(xpath = "(//*[starts-with(@class,'listHeader___40b031')])")
	private List<WebElement> suggestionLists;
	@FindBy(xpath = "(//*[starts-with(@class,'placeHolderContainer___2f65b9')])[2]")
	private WebElement toSource;
	@FindBy(xpath = "//*[starts-with(@class,'listItem___f7c71e hoverHighlight___bb9ff6 ')]")
	private List<WebElement> tosourceSuggestions;
	@FindBy(xpath = "//*[starts-with(@class,'inputField___44716f')]")
	private WebElement toInput;
	@FindBy(xpath = "//*[starts-with(@class,'listHeader___40b031')]")
	private List<WebElement> toinputSuggestions;
	@FindBy(xpath = "//*[starts-with(@class,'primaryButton___93b44e searchButtonWrapper___8e4b13')]")
	private WebElement searchBuses;
	@FindBy(xpath = "//*[starts-with(@class,'container___023201  ')]")
	private List<WebElement> filterBuses;
	public void clickFilterBuses(String text) {
		filterBuses.stream().filter(p->p.getText().contains(text)).findFirst().orElseThrow(null).click();
	}
	public void clickSpecificToAddress(String text) {
		toinputSuggestions.stream().filter(p->p.getText().contains(text)).findFirst().orElseThrow(null).click();
		searchBuses.click();
	}
	
	public void clickToSource() {
		toSource.click();
		
	}

	public void clickFromSource(String cityName) {
		fromSource.click();
		inputWrapper.sendKeys(cityName);
		suggestionLists.stream().filter(p -> p.getText().contains(cityName)).findFirst().orElse(null).click();
	}
}
