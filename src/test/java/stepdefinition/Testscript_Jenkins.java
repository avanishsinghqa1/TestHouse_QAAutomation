package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Testscript_Jenkins {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User navigate to application open UrL")
	public void user_navigate_to_application_open_UrL() throws IOException, InterruptedException {
		
	  FileInputStream fis=new FileInputStream("Jenkins.properties") ;
	  files=new Properties();
	  files.load(fis);
	  System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_23.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(files.getProperty("Url"));
	  System.out.println("Browser Launch");
	  Thread.sleep(2000);
		  
		  
		  
	  }
		
	  
	@When("User is in Application Home Page")
	public void user_is_in_Application_Home_Page() {
	    
	}
	
	

	@Then("User verify the Contact US deatils in Application")
	public void user_verify_the_Contact_US_deatils_in_Application() {
	  
		
	}
	

}
