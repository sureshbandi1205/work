package step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
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
import cucumber.api.java.it.Date;

public class datepicker {
	
	WebDriver driver;
	@Given("^that I am in ors page$")
	public void that_I_am_in_ors_page() {
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
		WebElement ros=driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/a/span"));
		ros.click();
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul[1]/li[2]/ul/li[1]/a/span")).click();


	}

	@When("^I click on date$")
	public void i_click_on_date() throws InterruptedException, ParseException
	{
		driver.switchTo().frame("OContent");
		driver.findElement(By.xpath(("//*[@id=\"txtstartdate\"]"))).click();
        Thread.sleep(2000);
        String month="December 2019";
       String day="31";
        while(true)
        {
        	String text=driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]")).getText();
        	if(text.equals(month))
        	{
        		break;
        	}
        	else
        	{
        		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[3]")).click();
        	}
        }
        Thread.sleep(2000);
        String beforeXpath="/html/body/div[3]/div[1]/table/tbody/tr[";
        String afterXpath="]/td[";
        final int weekdays=7;
        String dayVal=null;
        boolean flag=false;
        for(int r=2;r<=6;r++)
        {
        	for(int c=1;c<=7;c++)
        	{
        		try
        		{
        		dayVal=driver.findElement(By.xpath(beforeXpath+r+afterXpath+c+"]")).getText();
        		}
        		catch(NoSuchElementException e)
        		{
        			System.out.println("please enter correct date");
        			flag=false;
        		}
        		if(dayVal.equals(day))
        		{
        			Thread.sleep(2000);
        			System.out.println("ready");
        			driver.findElement(By.xpath(beforeXpath+r+afterXpath+c+"]")).click();
        			System.out.println("clicked");
        			flag=true;
        			break;
        		}
        				
        	}
        	if(flag)
        		break;
        }
     
	}
		
@Then("^date will selected and close the window$")
public void date_will_selected_and_close_the_window() {
	driver.close();
}

}