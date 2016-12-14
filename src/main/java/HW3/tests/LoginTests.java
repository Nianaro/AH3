package HW3.tests;

import HW3.Data.PathsData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import HW3.pages.LoginPage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    private WebDriver webDriver;
    private LoginPage loginPage;
    private SoftAssert softAssert;

    @DataProvider
    public Object[][] positiveLoginData(){
        return new Object[][]{
                {"admin", "123", "Players"}
        };
    }
    @DataProvider
    public Object[][] wrongPasswordLoginData(){
        return new Object[][]{
                {"admin", "12345", "Login", "Invalid username or password"}
        };
    }
    @DataProvider
    public Object[][] wrongLoginData(){
        return new Object[][]{
                {"ada", "123", "Login", "Invalid username or password"}
        };
    }
    @DataProvider
    public Object[][] emptyFieldsLoginData(){
        return new Object[][]{
                {"", "", "Login", "Value is required and can't be empty"}
        };
    }

    @DataProvider
    public Object[][] emptyPasswordLoginData(){
        return new Object[][]{
                {"admin", "", "Login", "Value is required and can't be empty"}
        };
    }

    /**
     * Preconditions:
     * 1. Open browser.
     */
    @BeforeTest
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Preconditions:
     * 1. Open Log In page.
     */
    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        loginPage.openHomePage();
        softAssert = new SoftAssert();
    }

    /**
     * Steps to reproduce:
     * 1. Log In with correct data.
     * 2. Verify that title equals "Players".
     * 3. Verify that URL not equals URL of login page.
     */
    /*@Parameters({"username", "password", "title"})*/
    @Test(dataProvider = "positiveLoginData", dependsOnGroups = "negative")
    public void positiveTest(String username, String password, String title) {
        loginPage.login(username, password);

        softAssert.assertEquals(webDriver.getTitle(), title, "Wrong title after login");
        softAssert.assertNotEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are still on login page");
        softAssert.assertAll();
    }

    /**
     * Steps to reproduce:
     * 1. Log in with wrong password.
     * 2. Verify that URL equals URL of login page.
     * 3. Verify that title equals "Login".
     * 4. Verify that error message equals "Invalid username or password".
     */
    /*@Parameters({"username", "password", "title", "expectedMessage"})*/
    @Test(dataProvider = "wrongPasswordLoginData", groups = "negative")
    public void negativeTestWrongPassword(String username, String password, String title, String expectedMessage){
        loginPage.login(username, password);

        softAssert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        softAssert.assertEquals(webDriver.getTitle(), title, "Wrong title after unsuccessful login");
        softAssert.assertEquals(loginPage.getErrMessage(), expectedMessage, "Invalid error message in login page");
        softAssert.assertAll();
    }

    /**
     * Steps to reproduce:
     * 1. Log in with wrong login.
     * 2. Verify that URL equals URL of login page.
     * 3. Verify that title equals "Login".
     * 4. Verify that error message equals "Invalid username or password".
     */
    /*@Parameters({"username", "password", "title", "expectedMessage"})*/
    @Test(dataProvider = "wrongLoginData", groups = "negative")
    public void negativeTestWrongLogin(String username, String password, String title, String expectedMessage){
        loginPage.login(username, password);

        softAssert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        softAssert.assertEquals(webDriver.getTitle(), title, "Wrong title after unsuccessful login");
        softAssert.assertEquals(loginPage.getErrMessage(), expectedMessage, "Invalid error message in login page");
        softAssert.assertAll();
    }

    /**
     * Steps to reproduce:
     * 1. Log In with empty username and password.
     * 2. Verify that URL equals URL of login page.
     * 3. Verify that title equals "Login".
     * 4. Verify that error message for username equals "Value is required and can't be empty".
     * 5. Verify that error message for password equals "Value is required and can't be empty".
     */
    /*@Parameters({"username", "password", "title", "expectedMessage"})*/
    @Test(dataProvider = "emptyFieldsLoginData", groups = "negative")
    public void negativeTestEmptyFields(String username, String password, String title, String expectedMessage){
        loginPage.login(username, password);

        softAssert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        softAssert.assertEquals(webDriver.getTitle(), title, "Wrong title after unsuccessful login");
        softAssert.assertEquals(loginPage.getErrMessageEmptyUserNameField(), expectedMessage, "Invalid error message in username login page");
        softAssert.assertEquals(loginPage.getErrMessageEmptyPasswordField(), expectedMessage, "Invalid error message in password login page");
        softAssert.assertAll();
    }

    /*@Parameters({"username", "password", "title", "expectedMessage"})*/
    @Test(dataProvider = "emptyPasswordLoginData", groups = "negative")
    public void negativeTestEmptyPassword(String username, String password, String title, String expectedMessage){
        loginPage.login(username,password);

        softAssert.assertEquals(webDriver.getCurrentUrl(), PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString(), "You are not on login page");
        softAssert.assertEquals(webDriver.getTitle(), title, "Wrong title after unsuccessful login");
        softAssert.assertEquals(loginPage.getErrMessageEmptyPasswordField(), expectedMessage, "Invalid error message in password login page");
        softAssert.assertAll();
    }

    /**
     * Post-conditions:
     * 1. Close browser.
     */
    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }

}
