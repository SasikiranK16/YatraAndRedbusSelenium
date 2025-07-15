package org.yatra.bases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yatra.pages.RedBusHomepage;
import org.yatra.pages.YatraAdvertisement;
import org.yatra.pages.YatraHomePage;

public class YatraBase {

	public static Properties properties;
	public static RedBusHomepage redBusHomepage;
	public static FileInputStream fileInputStream;
	public static WebDriver driver;
	public static YatraAdvertisement yatraAdvertisement;
	public static YatraHomePage yatraHomePage;
	public static WebDriverWait webDriverWait;
	public static Properties getProperties() {
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\org\\yatra\\utils\\Prop.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public static WebDriver optBrowser(String browserName,String urlName) {
		getProperties();
		if (getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("msedge")) {
			driver = new EdgeDriver();
		}
		else {
			System.err.println("Please Verify Once!!");
		}
		driver.get(urlName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	public static WebDriverWait waitAlways(WebElement locator) {
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		return webDriverWait;
	}
	public static WebDriver commonDrivers(WebDriver driver) {
		yatraAdvertisement = new YatraAdvertisement(driver);
		yatraHomePage = new YatraHomePage(driver);
		redBusHomepage = new RedBusHomepage(driver);
		return driver;
	}
	
}
