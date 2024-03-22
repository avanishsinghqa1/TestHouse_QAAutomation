package stepdefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Suport_TestScript {
	
	public static WebDriver driver;
	//public static Properties prop;
	
	
	
	@Given("I navigate To Application open URl")
	public void i_navigate_To_Application_open_URl() throws IOException, InterruptedException {
	
		FileInputStream fis=new FileInputStream("Config.properties");
		Properties file=new Properties();
		file.load(fis);
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver_108.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(file.getProperty("Url"));
		Thread.sleep(2000);
		System.out.println("Browser Launch");
	}

	@When("user Enter Username and Password By click on Login button")
	public void user_Enter_Username_and_Password_By_click_on_Login_button() {
		
		
	   
	}

	@Then("User is in VtigercRM home page")
	public void user_is_in_VtigercRM_home_page() {
	   
	}

	@Then("User has click on Support tab")
	public void user_has_click_on_Support_tab() {
	    
	}

	@Then("User has click on Contacts tab")
	public void user_has_click_on_Contacts_tab() {
	   
	}

	@Then("User verify the Creating Contacts in Support by click on Save button")
	public void user_verify_the_Creating_Contacts_in_Support_by_click_on_Save_button() {
	   
	}
    
	///Date-1-10-2023
	@Then("User has click on Documents tab")
	public void user_has_click_on_Documents_tab() {
	   
	}
     
	///Date-1-10-2023
	@Then("User verify the Creating Documents in Support Tab by click on Save button")
	public void user_verify_the_Creating_Documents_in_Support_Tab_by_click_on_Save_button() {
	    
	}

}
