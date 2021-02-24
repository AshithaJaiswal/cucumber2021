package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_multiple
{
	WebDriver driver;
	@Given("^launch url in \"([^\"]*)\"$")
	public void launch_url_in(String brw) throws Throwable 
	{
	     if(brw.equalsIgnoreCase("chrome"))
	     {
	    	 System.out.println("Executing in chrome browser");
	    	 driver=new ChromeDriver();
	    	 driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	    	 driver.manage().window().maximize();
	    }
	     else if(brw.equalsIgnoreCase("firefox"))
	     {
	    	 System.out.println("Executing in firefox browser");
	    	 driver=new FirefoxDriver();
	    	 driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	     }
	     else
	    	 System.out.println("browser is not matching");
	}

	@When("^user enter \"([^\"]*)\" in username textbox field$")
	public void user_enter_in_username_textbox_field(String username) throws Throwable
	{
	     driver.findElement(By.name("txtUsername")).sendKeys(username);
	     
	     
	}

	@When("^user enter \"([^\"]*)\" in password textbox field$")
	public void user_enter_in_password_textbox_field(String password) throws Throwable
	{
		driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("Submit")).click();
	}

	@Then("^user verify url text$")
	public void user_verify_url_text() throws Throwable 
	{
		if(driver.getCurrentUrl().contains("dash"))
	     {
	    	 Reporter.log("login success",true);
	     }
	     else
	    	 Reporter.log("login fail",true);
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable 
	{
	     driver.close();
	}


}
