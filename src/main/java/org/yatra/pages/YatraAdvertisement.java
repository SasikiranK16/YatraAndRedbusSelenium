package org.yatra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YatraAdvertisement {
	
	public WebDriver driver;
	public YatraAdvertisement(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[starts-with(@alt,'cross')])[1]")
	private WebElement clickClose;
	public void closeAdd() {
		clickClose.click();
	}

}
