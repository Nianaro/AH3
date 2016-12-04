package HW3.pages;

import HW3.Data.PlayersPageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PlayersPage extends Page{

    public PlayersPage() {
        super();
    }

    public PlayersPage(WebDriver webDriver){super(webDriver);}

    public PlayersPage(WebDriver webDriver, long time, TimeUnit timeUnit) {
        super(webDriver, time, timeUnit);
    }

    public void openInsertPlayerPage() {
        webDriver.findElement(By.xpath(PlayersPageData.INSERT_LINK_XPATH_PLAYERS_PAGE.toString())).click();
    }

    public void searchPlayerByEmail(String email) {
        webDriver.findElement(By.xpath(PlayersPageData.EMAIL_INPUT_XPATH_PLAYERS_PAGE.toString())).clear();
        webDriver.findElement(By.xpath(PlayersPageData.EMAIL_INPUT_XPATH_PLAYERS_PAGE.toString())).sendKeys(email);
        webDriver.findElement(By.xpath(PlayersPageData.SEARCH_BUTTON_INPUT_XPATH_PLAYERS_PAGE.toString())).click();
    }

    public void openEditPlayerPage(String email) {
        webDriver.findElement(By.xpath(PlayersPageData.EDIT_LINK_XPATH_PLAYERS_PAGE.toString().replaceFirst("email", email))).click();
    }


    public void deletePlayer(String email){
        webDriver.findElement(By.xpath(PlayersPageData.DELETE_USER_BUTTON_XPATH_PLAYERS_PAGE.toString())).click();
    }

    public String deleteMessage(){
        return webDriver.findElement(By.xpath(PlayersPageData.DELETE_MESSAGE_XPATH_PLAYERS_PAGE.toString())).getText();
    }
}
