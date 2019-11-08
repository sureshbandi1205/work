package step;

import java.awt.List;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class select {
	
WebDriver driver;
@Given("^that I am on ors page$")
public void that_I_am_on_ors_page() {
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
	driver.manage().window().maximize();
	driver.get("http://smartcommute.optum.com");
	driver.findElement(By.xpath("//*[@id=\"Table1\"]/tbody/tr[4]/td[3]/p/input")).sendKeys("bsures14");
	driver.findElement(By.name("PASSWORD")).sendKeys("Optum#2019");
	WebElement s=driver.findElement(By.xpath("//*[@id=\"Button2\"]"));
	s.click();
	WebElement ros=driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/a/span"));
	ros.click();
	driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/ul/li[1]/a/span")).click();

}

@When("^I select dropdown details$")
public void i_select_dropdown_details() throws Exception{
	driver.switchTo().frame("OContent");
	WebElement name=driver.findElement(By.xpath("//*[@id=\"myInput\"]"));
	name.sendKeys("suresh bandi");
	WebElement drop1=driver.findElement(By.xpath("//*[@id=\"PddlLocation\"]"));
	Select location = new Select(drop1);
	location.selectByVisibleText("HYD4");
	Thread.sleep(3000);
	Select shift = new Select(driver.findElement(By.xpath("//*[@id=\"ddlPickShift\"]")));
	shift.selectByVisibleText("11:00");
}
@When("^select checkbox emoliyee details$")
public void select_checkbox_emoliyee_details()  throws Exception {
	Thread.sleep(3000);
	Select dlocation = new Select(driver.findElement(By.id("DddlLocation")));
	dlocation.selectByVisibleText("HYD4");
	Thread.sleep(3000);
	Select dshift = new Select(driver.findElement(By.id("ddlDropShift")));
	dshift.selectByVisibleText("20:30");
}

@Then("^closes the page$")
public void closes_the_page() throws Exception {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"cbWO_3\"]")).click();
	boolean a=driver.findElement(By.xpath("//*[@id=\"cbWO_3\"]")).isSelected();
	System.out.println(a);
	Thread.sleep(2000);
	driver.findElement(By.xpath(("//*[@id=\"txtstartdate\"]"))).click();
	driver.close();
}

}