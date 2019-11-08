package step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ors {
	WebDriver driver;
	@Given("^you are in transport page$")
	public void you_are_in_transport_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\Chrome_driver_77.0.3865.40\\chromedriver.exe");
		System.setProperty("webdriver.firefox.marionette", "true");
		System.setProperty("BrowserType", "firefox");
		System.setProperty("BrowserVersion", "60.6.1");
		System.setProperty("ExecutionEnv", "Stage");
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
		
		ChromeOptions options = new ChromeOptions();
		//options.setBinary("/path/to/other/chrome/binary");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty("BrowserType", "chrome");
		System.setProperty("ExecutionEnv", "Stage");
		//DesiredCapabilities  capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability(CapabilityType.VERSION, "76.0.3809.132");
		capabilities.setCapability(CapabilityType.PLATFORM, "Windows 10");
		capabilities.setCapability("screenResolution", "1280x1024");
		 System.out.println("WebDriver...starting");
		
		 //ChromeOptions options = new ChromeOptions();
	    options.addArguments("test-type");
	    options.addArguments("start-maximized");
	    options.addArguments("window-size=800,600");
	    options.addArguments("window-position=x,y");
	    options.addArguments("--js-flags=--expose-gc");
	    options.addArguments("--enable-precise-memory-info");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--disable-default-apps");
	    options.addArguments("--enable-automation");
	    options.addArguments("test-type=browser");
	    options.addArguments("disable-infobars");
	    options.addArguments("disable-extensions"); 
	    options.setExperimentalOption("useAutomationExtension", false);
	   // options.AddAdditionalCapability("useAutomationExtension", false);


	//DesiredCapabilities dc = new FirefoxOptions().setProfile(firefoxProfile).addTo(DesiredCapabilities.firefox());

		if (driver == null)
		{
			 System.out.println("WebDriver...pleasewait");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			PageFactory.initElements(driver, this);
		}
		driver.get("http://smartcommute.optum.com");
		driver.findElement(By.xpath("//*[@id=\"Table1\"]/tbody/tr[4]/td[3]/p/input")).sendKeys("bsures14");
		driver.findElement(By.name("PASSWORD")).sendKeys("Optum#2019");
		WebElement s=driver.findElement(By.xpath("//*[@id=\"Button2\"]"));
		s.click();

		
	}

	@When("^you click on smart roster$")
	public void you_click_on_smart_roster() {
		WebElement ros=driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/a/span"));
		ros.click();
	}

	@When("^you click on ORS update$")
	public void you_click_on_ORS_update() {
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/ul/li[1]/a/span")).click();
	}

	@Then("^it shows required page$")
	public void it_shows_required_page() {
		driver.close();
	}

}
