package parallel;

import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Veena Hegde
 */
public class RegisterPageSteps {

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private Hooks hooks;


    public RegisterPageSteps(Hooks hooks){
        this.loginPage = hooks.getLoginPage();
    }

    @Given("user is on the register page")
    public void user_is_on_the_register_page() {
        registerPage = loginPage.navigateToRegisterPage();

    }

    @When("user enters following user details")
    public void user_enters_following_user_details(DataTable dataTable) {
      List<Map<String,String>> userDetails=  dataTable.asMaps(String.class, String.class);
      String randomEmail =  getRandomEmail();
      for(Map<String,String> user: userDetails){
                boolean accCreationMsg =  registerPage.userRegister(
                  user.get("firstName"),
                  user.get("lastName"),
                  randomEmail,
                  user.get("telephone"),
                  user.get("password"),
                  user.get("subscribe"));
                if(accCreationMsg){
                    System.out.println("PASS");
                }
                
      }


    }

    @Then("user registration should be successful")
    public void user_registration_should_be_successful() {
        System.out.println("PASS--Users registered successfully");
    }

    private String getRandomEmail() {
        return "uiautomation" +System.currentTimeMillis()+"@open.com";
    }
}
