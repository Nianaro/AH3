package HW3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayersPage extends Page{

    @FindBy(xpath = ".//a[contains(@href,'/players/insert')]")
    private WebElement linkToInsertPage;

    @FindBy(xpath = ".//input[contains(@id,'__email')]")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[contains(@value,'Search')]")
    private WebElement searchBtn;

    @FindBy(xpath = ".//tr[.//a[text()='email']]//img[@alt='Edit']")
    private WebElement linkToEditPage;

    @FindBy(xpath = ".//img[@alt='Delete']")
    private WebElement deleteBtn;

    @FindBy(xpath = ".//div[contains(@id,'datagrid_flash')]/ul/li")
    private WebElement deleteMsg;

    public PlayersPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void openInsertPlayerPage() {
        linkToInsertPage.click();
    }

    public void searchPlayerByEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        searchBtn.click();
    }

    public void openEditPlayerPage(String email) {
        webDriver.findElement(By.xpath(".//tr[.//a[text()='email']]//img[@alt='Edit']".replaceFirst("email", email))).click();
    }


    public void deletePlayer(String email){
        deleteBtn.click();
    }

    public String getDeleteMessage(){
        return deleteMsg.getText();
    }
}
