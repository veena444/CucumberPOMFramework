package parallel;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * @author Veena Hegde
 */
public class AccountsPageSteps {

    private Hooks hooks;
    private LoginPage loginPage;
    private AccountsPage accPage;
    private SearchResultsPage searchResultsPage;
    private String title;
    private String url;
    private List<String> headers;

    public AccountsPageSteps(Hooks hooks) {
        this.hooks = hooks;
        loginPage = hooks.getLoginPage();
    }

    @Given("user is logged in and on the accounts page")
    public void user_is_logged_in_and_on_the_accounts_page() {
       accPage = loginPage.doLogin(hooks.getProperties().getProperty("username"), hooks.getProperties().getProperty("password"));
    }

    @When("user checks the page headers")
    public void user_checks_the_page_headers() {
       headers =  accPage.getAccPageHeaders();
    }

    @Then("page headers should be:")
    public void page_headers_should_be(DataTable expectedHeadersTable) {
       List<String> expectedHeaders = expectedHeadersTable.asList();
       Assert.assertEquals(expectedHeaders,headers);
    }

    @When("user searches for {string}")
    public void user_searches_for(String searchKey) {
         searchResultsPage = accPage.doSearch(searchKey);
    }
    @Then("result count should be {int}")
    public void result_count_should_be(int expectedCount) {
         Assert.assertEquals(expectedCount,searchResultsPage.getSearchResultsCount());
    }
}
