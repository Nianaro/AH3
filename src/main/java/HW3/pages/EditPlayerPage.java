package HW3.pages;

import HW3.Entities.PokerPlayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class EditPlayerPage extends Page{

    @FindBy(xpath = ".//input[contains(@id,'us_login')]")
    private WebElement userName;

    @FindBy(xpath = ".//input[contains(@id,'email')]")
    private WebElement email;

    @FindBy(xpath = ".//input[contains(@id,'us_password')]")
    private WebElement password;

    @FindBy(xpath = ".//input[contains(@id,'confirm_password')]")
    private WebElement confirmPassword;

    @FindBy(xpath = ".//input[contains(@id, 'fname')]")
    private WebElement firstName;

    @FindBy(xpath = ".//input[contains(@id, 'lname')]")
    private WebElement lastName;

    @FindBy(xpath = ".//input[contains(@id, 'city')]")
    private WebElement city;

    @FindBy(xpath = ".//select[contains(@id,'country')]")
    private WebElement country;

    @FindBy(xpath = ".//textarea[contains(@id, 'address')]")
    private WebElement address;

    @FindBy(xpath = ".//input[contains(@id, 'phone')]")
    private WebElement phone;

    @FindBy(xpath = ".//input[@value='Save']")
    private WebElement saveBtn;

    public EditPlayerPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void editPlayer(PokerPlayer player) {
        firstName.clear();
        firstName.sendKeys(player.getFirstName());

        lastName.clear();
        lastName.sendKeys(player.getLastName());

        city.clear();
        city.sendKeys(player.getCity());

        country.sendKeys(player.getCountry());

        address.clear();
        address.sendKeys(player.getAddress());

        phone.clear();
        phone.sendKeys(player.getPhone());

        saveBtn.click();
    }

    public void addPlayer(PokerPlayer player) {
        userName.sendKeys(player.getUserName());

        email.sendKeys(player.getEmail());

        password.sendKeys(player.getPassword());

        confirmPassword.sendKeys(player.getPassword());

        editPlayer(player);
    }

    public PokerPlayer readPokerPlayers() {
        PokerPlayer expected = new PokerPlayer();
        expected.setEmail(email.getAttribute("value"), "");
        expected.setFirstName(firstName.getAttribute("value"));
        expected.setLastName(lastName.getAttribute("value"));
        expected.setCity(city.getAttribute("value"));
        expected.setCountry(country.getAttribute("value"));
        expected.setAddress(address.getAttribute("value"));
        expected.setPhone(phone.getAttribute("value"));
        return expected;
    }

    public void assertPokerPlayer(PokerPlayer actual, PokerPlayer expected){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual.getEmail(), expected.getEmail(), "Inappropriate email");
        softAssert.assertEquals(actual.getFirstName(), expected.getFirstName(), "Inappropriate first name");
        softAssert.assertEquals(actual.getLastName(), expected.getLastName(), "Inappropriate last name");
        softAssert.assertEquals(actual.getCity(), expected.getCity(), "Inappropriate city");
        softAssert.assertEquals(actual.getCountry(), expected.getCountry(), "Inappropriate country");
        softAssert.assertEquals(actual.getAddress(), expected.getAddress(), "Inappropriate address");
        softAssert.assertEquals(actual.getPhone(), expected.getPhone(), "Inappropriate phone");
        softAssert.assertAll();
    }


}
