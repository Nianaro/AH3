package HW3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "logIn")
    private WebElement logInInput;

    @FindBy(xpath = ".//ul[@class='errors']/li")
    private WebElement errMsg;

    @FindBy(xpath = ".//dd[@id='username-element']/ul/li")
    private WebElement errMsgEmptyUserNameField;

    @FindBy(xpath = ".//dd[@id='password-element']/ul/li")
    private WebElement errMsgEmptyPassField;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    private void setUserName(String userName) {
        usernameInput.clear();
        usernameInput.sendKeys(userName);
    }

    private void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    private void clickOnLogin() {
        logInInput.click();
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickOnLogin();
    }

    public String getErrMessage(){
        return errMsg.getText();
    }

    public String getErrMessageEmptyUserNameField(){
        return errMsgEmptyUserNameField.getText();
    }

    public String getErrMessageEmptyPasswordField(){
        return errMsgEmptyPassField.getText();
    }
}
