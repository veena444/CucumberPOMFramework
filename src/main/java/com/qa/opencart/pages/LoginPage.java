package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Veena Hegde
 */
public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. Page Objects: By Locators:

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	// 2. public const.. of the page:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page actions/methods
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME);
		System.out.println("login page title : " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME);
		System.out.println("login page url : " + url);
		return url;
	}

	public boolean checkForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}

	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("user creds : " + username + ":" + pwd);
		eleUtil.doSendKeys(emailId, username, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);

	}

	public void doInvalidLogin(String userName, String pwd) {
		WebElement usernameElement = eleUtil.waitForElementVisible(emailId, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.doSendKeys(usernameElement,userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
//		String errorMsg = eleUtil.waitForElementVisible(loginErrorMessage, TimeUtil.DEFAULT_TIME).getText();
//		System.out.println("Login error ===> "+ errorMsg);
//		if(errorMsg.contains(AppConstants.LOGIN_ERROR_MESSAGE)) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}

	public String isErrorMsgDisplayed(){
		String errorMsg = eleUtil.waitForElementVisible(loginErrorMessage, TimeUtil.DEFAULT_TIME).getText();
		System.out.println("Login error ===> "+ errorMsg);
		return errorMsg;
//		if(errorMsg.contains(AppConstants.LOGIN_ERROR_MESSAGE)) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}

	public RegisterPage navigateToRegisterPage() {
		eleUtil.doClick(registerLink, TimeUtil.DEFAULT_TIME);
		return new RegisterPage(driver);
	}

}
