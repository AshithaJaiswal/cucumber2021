package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginWithSingleData
{
	WebDriver driver;
	@Given("^Launch in chrome browser$")
	public void launch_in_chrome_browser() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	     driver=new ChromeDriver();
	     driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	     driver.manage().window().maximize();
	}

	@When("^Enter user name and Enter password$")
	public void enter_user_name_and_Enter_password() throws Throwable 
	{
	     driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	     driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	}

	@When("^Click on login button$")
	public void click_on_login_button() throws Throwable 
	{
	     driver.findElement(By.name("Submit")).click();
	}

	@Then("^verify url$")
	public void verify_url() throws Throwable 
	{
	     if(driver.getCurrentUrl().contains("dash"))
	     {
	    	 Reporter.log("login success",true);
	     }
	     else
	    	 Reporter.log("login fail",true);
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable 
	{
	     driver.close();
	}


}
