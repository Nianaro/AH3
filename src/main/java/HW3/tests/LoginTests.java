package HW3.tests;

import HW3.Data.LogInPageData;
import HW3.Data.PathsData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import HW3.pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver webDriver;
    private LoginPage loginPage;

    @BeforeTest
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        loginPage.openHomePage();
    }

    @Test
    public void positiveTest() {
        loginPage.login(LogInPageData.USER_NAME_INPUT_VALUE_LOGIN_PAGE.toString(), LogInPageData.PASSWORD_INPUT_VALUE_LOGIN_PAGE.toString());

        Assert.assertEquals(webDriver.getTitle(), "Players", "Wrong title after login");
        Assert.assertNotEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are still on login page");
    }

    @Test
    public void negativeTestWrongPassword(){
        loginPage.login(LogInPageData.USER_NAME_INPUT_VALUE_LOGIN_PAGE.toString(), LogInPageData.INCORRECT_PASSWORD_INPUT_VALUE_PAGE.toString());

        Assert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        Assert.assertEquals(webDriver.getTitle(), LogInPageData.TITLE_LOGIN_PAGE.toString(), "Wrong title after unsuccessful login");
        Assert.assertEquals(loginPage.getErrMessage(), LogInPageData.ERROR_MESSAGE_TEXT_LOGIN_PAGE.toString(), "Invalid error message in login page");
    }

    @Test
    public void negativeTestWrongLogin(){
        loginPage.login(LogInPageData.INCORRECT_USER_NAME_INPUT_VALUE_PAGE.toString(), LogInPageData.PASSWORD_INPUT_VALUE_LOGIN_PAGE.toString());

        Assert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        Assert.assertEquals(webDriver.getTitle(), LogInPageData.TITLE_LOGIN_PAGE.toString(), "Wrong title after unsuccessful login");
        Assert.assertEquals(loginPage.getErrMessage(), LogInPageData.ERROR_MESSAGE_TEXT_LOGIN_PAGE.toString(), "Invalid error message in login page");
    }

    @Test
    public void negativeTestEmptyFields(){
        loginPage.login("", "");

        Assert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        Assert.assertEquals(webDriver.getTitle(), LogInPageData.TITLE_LOGIN_PAGE.toString(), "Wrong title after unsuccessful login");
        Assert.assertEquals(loginPage.getErrMessageEmptyUserNameField(), LogInPageData.ERROR_MESSAGE_EMPTY_USER_NAME_TEXT_LOGIN_PAGE.toString(), "Invalid error message in username login page");
        Assert.assertEquals(loginPage.getErrMessageEmptyPasswordField(), LogInPageData.ERROR_MESSAGE_EMPTY_PASSWORD_TEXT_LOGIN_PAGE.toString(), "Invalid error message in password login page");
    }

    @AfterMethod
    public void afterMethod(){
        webDriver.close();
    }

    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }

}
