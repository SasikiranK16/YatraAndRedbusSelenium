package org.yatra.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.yatra.bases.YatraBase;

public class RedBus extends YatraBase {
	@BeforeSuite
	public void launch() {
		getProperties();
		System.out.println(getProperties().getProperty("url"));
		System.out.println(getProperties().getProperty("browser"));
		optBrowser(getProperties().getProperty("browser"),getProperties().getProperty("url"));
		commonDrivers(driver);
	}
	@Test
	public void testOne() throws Exception {
		redBusHomepage.clickFromSource("Hyd");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[starts-with(@class,'inputField___44716f')]")).sendKeys("Pun");
		Thread.sleep(1000);
		redBusHomepage.clickSpecificToAddress("Pune");
		redBusHomepage.clickFilterBuses("Primo Bus");
		redBusHomepage.clickFilterBuses("18:00");
		Thread.sleep(5000);
		List<WebElement>busesLists = driver.findElements(By.xpath("//*[starts-with(@class,'travelsName___495898')]"));
		System.out.println(busesLists.size());
		busesLists.stream().forEach(p->System.out.println(p.getText()));
	}
}
