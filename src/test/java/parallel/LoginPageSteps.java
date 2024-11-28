package parallel;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author Veena Hegde
 */
public class LoginPageSteps {

    private LoginPage loginPage;
    private AccountsPage accPage;
    private Hooks hooks;

    public LoginPageSteps(Hooks hooks) {
        this.loginPage = hooks.getLoginPage();
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // Assuming the driver is already on the login page
    }

    @When("user checks the page title")
    public void user_checks_the_page_title() {
        String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, expectedTitle);
    }

    @When("user checks the page URL")
    public void user_checks_the_page_url() {
        String actURL = loginPage.getLoginPageURL();
        Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
    }

    @Then("URL should contain {string}")
    public void url_should_contain(String fractionURL) {
        String actURL = loginPage.getLoginPageURL();
        Assert.assertTrue(actURL.contains(fractionURL));
    }

    @When("user checks the forgot password link")
    public void user_checks_the_forgot_password_link() {
        Assert.assertTrue(loginPage.checkForgotPwdLinkExist());
    }

    @Then("forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.checkForgotPwdLinkExist());
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        accPage = loginPage.doLogin(username, password);
    }

    @Then("user should be redirected to the accounts page with title {string}")
    public void user_should_be_redirected_to_the_accounts_page_with_title(String expectedTitle) {
        Assert.assertEquals(accPage.getAccPageTitle(), expectedTitle);
    }
}
