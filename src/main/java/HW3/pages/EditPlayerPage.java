package HW3.pages;

import HW3.Data.EditPlayerPageData;
import HW3.Entities.PokerPlayer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EditPlayerPage extends Page{
    public EditPlayerPage() {
        super();
    }

    public EditPlayerPage(WebDriver webDriver){super(webDriver);}

    public EditPlayerPage(WebDriver webDriver, long time, TimeUnit timeUnit) {
        super(webDriver, time, timeUnit);
    }

    public void editPlayer(PokerPlayer player) {
        webDriver.findElement(By.xpath(EditPlayerPageData.FIRST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.FIRST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getFirstName());

        webDriver.findElement(By.xpath(EditPlayerPageData.LAST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.LAST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getLastName());

        webDriver.findElement(By.xpath(EditPlayerPageData.CITY_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.CITY_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getCity());

        webDriver.findElement(By.xpath(EditPlayerPageData.COUNTRY_SELCT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getCountry());

        webDriver.findElement(By.xpath(EditPlayerPageData.ADDRESS_TEXTAREA_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.ADDRESS_TEXTAREA_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getAddress());


        webDriver.findElement(By.xpath(EditPlayerPageData.PHONE_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.PHONE_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getPhone());

        webDriver.findElement(By.xpath(EditPlayerPageData.SAVE_BUTTON_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).click();
    }

    public void addPlayer(PokerPlayer player) {
        webDriver.findElement(By.xpath(EditPlayerPageData.USER_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getUserName());

        webDriver.findElement(By.xpath(EditPlayerPageData.EMAIL_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getEmail());

        webDriver.findElement(By.xpath(EditPlayerPageData.PASSWORD_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getPassword());

        webDriver.findElement(By.xpath(EditPlayerPageData.CONFIRM_PASSWORD_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getPassword());

        webDriver.findElement(By.xpath(EditPlayerPageData.FIRST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.FIRST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getFirstName());

        webDriver.findElement(By.xpath(EditPlayerPageData.LAST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.LAST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getLastName());

        webDriver.findElement(By.xpath(EditPlayerPageData.CITY_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.CITY_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getCity());

        webDriver.findElement(By.xpath(EditPlayerPageData.COUNTRY_SELCT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getCountry());

        webDriver.findElement(By.xpath(EditPlayerPageData.ADDRESS_TEXTAREA_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.ADDRESS_TEXTAREA_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getAddress());


        webDriver.findElement(By.xpath(EditPlayerPageData.PHONE_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(EditPlayerPageData.PHONE_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).sendKeys(player.getPhone());

        webDriver.findElement(By.xpath(EditPlayerPageData.SAVE_BUTTON_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).click();
    }

}
