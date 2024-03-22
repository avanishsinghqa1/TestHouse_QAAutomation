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

public class Quick_Create_TestScript {
	
    public static WebDriver driver;
    public static Properties files;
	
	
	@Given("I navigate to application Open Url")
	public void i_navigate_to_application_Open_Url() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_116.exe");
		driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		driver.get(files.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Browser Launch Successfully");
		Thread.sleep(2000);
		   
	}

	@When("User Enter username and password by click On login Button")
	public void user_Enter_username_and_password_by_click_On_login_Button() {
		
		
	    
	}

	@Then("User is In vtigerCRM Home page")
	public void user_is_In_vtigerCRM_Home_page() {
		
		
	    
	}

	@Then("User has click on Quick Create dropdown Item field")
	public void user_has_click_on_Quick_Create_dropdown_Item_field() {
	    
		
		
	}

}
