package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Generic_Method.Utility_Method;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Analytics_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate to APPlication open UrL")
	public void i_navigate_to_APPlication_open_UrL() throws IOException {
	
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_119.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");	
	 
	}

	@When("user Enter UsernamE and PassworD by clicK on login Button")
	public void user_Enter_UsernamE_and_PassworD_by_clicK_on_login_Button() throws InterruptedException, IOException {
		 
		Thread.sleep(1000);
		WebElement LoginBtn=driver.findElement(By.xpath("//input[@name='Login']"));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		Thread.sleep(1000);
		WebElement Pwd=driver.findElement(By.xpath("//input[@name='user_password']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin';",Pwd);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", LoginBtn);
		System.out.println("Login Sucessfully");
		Thread.sleep(2000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/Anaylitis.png"));
		System.out.println("Takes Screnshot");    
	}

	@Then("user is in VtigerCRM HOme page")
	public void user_is_in_VtigerCRM_HOme_page() throws InterruptedException {
		Thread.sleep(2000);
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("HomePage Title Matched");    
	}

	@Then("User has click on Analytics tab")
	public void user_has_click_on_Analytics_tab() throws InterruptedException {
		
		Thread.sleep(2000);
		//WebElement anylitcsBtn=driver.findElement(By.xpath("//a[text()='Analytics']"));
		//anylitcsBtn.click();
		Utility_Method.captureScreenShot(driver);
		Thread.sleep(2000);
		
		
		
	}

	@Then("User has click on Reports tab")
	public void user_has_click_on_Reports_tab() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ReportsBtn=driver.findElement(By.xpath("//a[text()='Analytics']"));
		Actions act=new Actions(driver);
		act.moveToElement(ReportsBtn).build().perform();
		Thread.sleep(2000);
		WebElement ReportsBtnn=driver.findElement(By.xpath("//div[@id='Analytics_sub']//a[text()='Reports']"));
		ReportsBtnn.click();
		
	    
	}

	@Then("User verify and click on new report in Analytics Page")
	public void user_verify_and_click_on_new_report_in_Analytics_Page() throws InterruptedException, IOException {
		
		//WebElement ReportsBtn=driver.findElement(By.xpath("//div[@id='Analytics_sub']//a[text()='Reports']"));
		//ReportsBtn.click();
	    driver.findElement(By.xpath("//img[@title='Create Report...']")).click();
	    Thread.sleep(2000);
	    List<WebElement>AllList=driver.findElements(By.xpath("//div[@id='reportLay']/table/tbody/tr[2]//a"));
	    
	    for(WebElement list:AllList) {
	    	
	    	if(list.getText().equals("- Accounts")) {
	    		
	    		list.click();
	    		break;
	    	}
	    }
	    	
	     Thread.sleep(2000);
	     String mainwindow=driver.getWindowHandle();
	     System.out.println(mainwindow);
	     Set<String>set=driver.getWindowHandles();
	     Iterator<String>itr=set.iterator();
	     while(itr.hasNext()==true) {
	    	 
	    	 String childwindow=itr.next();
	    	 System.out.println(childwindow);
	    	 String Title=driver.switchTo().window(childwindow).getTitle();
	    	 System.out.println(Title);
	    	 
	    	 if(Title.equalsIgnoreCase("vtiger CRM - Create Report")) {
	    		 
	    		 break;
	    	 }
	     }
	     System.out.println("Multiple window Handling");
	     driver.manage().window().maximize();
	     WebElement reprtname=driver.findElement(By.xpath("//input[@name='reportname']"));
	     reprtname.sendKeys("Test");
	     Thread.sleep(2000);
	     List<WebElement>AllDropList=driver.findElements(By.xpath("//table[@class='small']//select/option"));
	     //int size=AllDropList.size();
	         //for(int i=0;i<=size-1;i++) {
	        	
	        	 //AllDropList.get(i).click();
	        	 //Thread.sleep(2000);
	         //}
	         //System.out.println("All List Verify");
	     
	     for(WebElement List1:AllDropList) {
	    	 
	    	 if(List1.getText().equals("Activity Reports")) {
	    		 
	    		 List1.click();
	    		 break;
	    	 }
	    	 
	     }
	      Thread.sleep(1000);
	      JavascriptExecutor js1=(JavascriptExecutor)driver;
	      WebElement textArea=driver.findElement(By.xpath("//textarea[@name='reportdes']"));
	      js1.executeScript("arguments[0].value='Test';",textArea);
	      Thread.sleep(1000);
	      WebElement nextBtn=driver.findElement(By.xpath("//input[@id='next']"));
	      //JavascriptExecutor js1=(JavascriptExecutor)driver;
	      js1.executeScript("arguments[0].click()",nextBtn);
	      Thread.sleep(2000);
	      
	      //////////////////Select All Related Module//////////////////////////////////////
	      ///multiple window////////
	      String maincheckwindow=driver.getWindowHandle();
	      System.out.println(maincheckwindow);
	      Set<String>set1=driver.getWindowHandles();
	      Iterator<String>itr1= set1.iterator();
	      
	      while(itr1.hasNext()) {
	    	  
	    	 String childcheckwindow= itr1.next();
	    	 System.out.println(childcheckwindow);
	    	 if(childcheckwindow.equalsIgnoreCase("vtiger CRM - Create Report")) {
	    		 
	    		 break;
	    	 }
	      }
	       System.out.println("Multiple window Handling");
	       Thread.sleep(2000);
	       //List<WebElement> selectAll=driver.findElements(By.xpath("//table[@class='small']//input"));
	       List<WebElement> checkboxclkElement=driver.findElements(By.xpath("//*[@id='step2']/table/tbody/tr[3]/td[2]/table/tbody//input"));
	       for(int i=0;i<checkboxclkElement.size();i++) {
	    	   
	    	   checkboxclkElement.get(i).click();
	       Thread.sleep(1000);
	    	 System.out.println("Select All Related Module checked");
	       }
	       //checkboxclkElement.click();
	       Thread.sleep(3000);
	       //////////TakeScreenshot//////////////
	       
	       File Scrr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       
	       FileUtils.copyFile(Scrr, new File("./Screenshots/checkBox.png"));
	       System.out.println("Taking All Check Box Screnshot");
	       Thread.sleep(2000);
	       ///////////ScrollDown//////////
	       
	       JavascriptExecutor js2=(JavascriptExecutor)driver;
	       //js2.executeScript("window.scrollBy,0,450");
	       WebElement Nextclk=driver.findElement(By.xpath("//input[@name='next']"));
	       js2.executeScript("arguments[0].scrollIntoView(true);", Nextclk);
	       Thread.sleep(3000);
	       /////////////click Next Button///
	       
	       WebElement Nextclk1=driver.findElement(By.xpath("//input[@name='next']"));
	       js2.executeScript("arguments[0].click();",Nextclk1);
	       Thread.sleep(2000);
	       
	}
	
	
	
	

}













