package org.yatra.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yatra.commoncodes.YatraCommonCodes;

public class YatraHomePage extends YatraCommonCodes {

	public WebDriver driver;
	public YatraHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[starts-with(@class,'css-w7k25o')]")
	private WebElement calanderAccess;
	@FindBy(xpath = "(//*[starts-with(@aria-label,'MAHA SHIVARATHIRI')])")
	private List<WebElement> monthlyDates;
	@FindBy(xpath = "(//*[starts-with(@type,'button')])[2]")
	private WebElement clickSearch;
	@FindBy(xpath = "//*[starts-with(@class,'fs-18 bold price-color text-center fare-price')]")
	private List<WebElement> flightPrices;
	@FindBy(xpath = "//*[starts-with(@class,'react-datepicker__week')]")
	private List<WebElement>secondBlockCalandar;
	public void clickSearch() {
		clickSearch.click();
	}
	public void checkFlightPrices() {
		flightPrices.stream().forEach(p->System.out.println(p.getText()));
	}
	public void clickCalander() {
		waitAlways(calanderAccess);
	}
	public void clickSpecificDepatureDate(String dateNumber) {
		monthlyDates.stream().filter(p->p.getText().contains(dateNumber)).findFirst().orElse(null).click();
//		monthlyDates.stream().forEach(p->System.out.println(p.getText()));
		clickSearch.click();
	}
	public void clickSpecificDepatureDateModified() {
//		monthlyDates.stream().filter(p->p.getAttribute("Choose Friday, August 1st, 2025").contains(number)).findAny().orElse(null).click();
//		secondBlockCalandar.stream().filter(p->p.getText().contains(num)).findFirst().orElse(null).click();
		secondBlockCalandar.stream().forEach(p->System.out.println(p.getText()));
		
	}
}
