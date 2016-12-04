package HW3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import HW3.Data.LogInPageData;

public class LoginPage extends Page{

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private void setUserName(String userName) {
        webDriver.findElement(By.id(LogInPageData.USER_NAME_INPUT_ID_LOGIN_PAGE.toString())).clear();
        webDriver.findElement(By.id(LogInPageData.USER_NAME_INPUT_ID_LOGIN_PAGE.toString())).sendKeys(userName);
    }

    private void setPassword(String password) {
        webDriver.findElement(By.id(LogInPageData.PASSWORD_INPUT_ID_LOGIN_PAGE.toString())).clear();
        webDriver.findElement(By.id(LogInPageData.PASSWORD_INPUT_ID_LOGIN_PAGE.toString())).sendKeys(password);
    }

    private void clickOnLogin() {
        webDriver.findElement(By.id(LogInPageData.LOGIN_BUTTON_INPUT_ID_LOGIN_PAGE.toString())).click();
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickOnLogin();
    }

    public String getErrMessage(){
        return webDriver.findElement(By.xpath(LogInPageData.ERROR_MESSAGE_XPATH_LOGIN_PAGE.toString())).getText();
    }

    public String getErrMessageEmptyUserNameField(){
        return webDriver.findElement(By.xpath(LogInPageData.ERROR_MESSAGE_EMPTY_USER_NAME_XPATH_LOGIN_PAGE.toString())).getText();
    }

    public String getErrMessageEmptyPasswordField(){
        return webDriver.findElement(By.xpath(LogInPageData.ERROR_MESSAGE_EMPTY_PASSWORD_XPATH_LOGIN_PAGE.toString())).getText();
    }
}
