 package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	
	private static String title;
	
	
@Given("user is on login page")
public void user_is_on_login_page() {

DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");


}

@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {

	 title = loginPage.getLoginTitle();
	
	System.out.println("Page Title is " +title);
	
}

@Then("page title should be {string}")
public void page_title_should_be(String expectedTitleName) {
    
	Assert.assertTrue(title.contains(expectedTitleName));
	
}

@Then("forgot your password link should be display")
public void forgot_your_password_link_should_be_display() {
    
	Assert.assertTrue(loginPage.ForgotPasswordLink());
}

@When("user enters username {string}")
public void user_enters_username(String username) {
    
	loginPage.enterUsername(username);
	
}

@When("user enters password {string}")
public void user_enters_password(String password) {
	
	loginPage.enterPassword(password);
    } 

@When("user clicks on Login button")
public void user_clicks_on_login_button() {
    
	loginPage.clickOnLogin();
}



}
