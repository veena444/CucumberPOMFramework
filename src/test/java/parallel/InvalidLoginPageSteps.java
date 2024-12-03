package parallel;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InvalidLoginPageSteps {

    private LoginPage loginPage;
    private Hooks hooks;

    public InvalidLoginPageSteps(Hooks hooks){
        this.loginPage=hooks.getLoginPage();
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        loginPage.doInvalidLogin(username,password);
    }


    @Then("user should get the error message")
    public void user_should_get_the_error_message(){
        String expectedErrorMsg = "Warning: No match for E-Mail Address and/or Password.";
        String actualErrorMsg = loginPage.isErrorMsgDisplayed();
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg);

    }

}
