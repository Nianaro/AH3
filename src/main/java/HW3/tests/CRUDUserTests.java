package HW3.tests;

import HW3.Data.EditPlayerPageData;
import HW3.Data.LogInPageData;
import HW3.Data.PlayersPageData;
import HW3.Entities.PokerPlayer;
import HW3.Utils.Util;
import HW3.pages.EditPlayerPage;
import HW3.pages.LoginPage;
import HW3.pages.PlayersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CRUDUserTests {

    private WebDriver webDriver;
    private PlayersPage playersPage;
    private EditPlayerPage editPlayerPage;
    private PokerPlayer pokerPlayer;

    /**
     * Precondition:
     * 1. Open browser.
     */
    @BeforeTest
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Precondition:
     * 1. Create player.
     * 2. Open login page.
     * 3. Log in.
     * 4. Open "Insert - Player" page.
     * 5. Add new player.
     * 6. Verify that title equals "Players".
     */
    @BeforeMethod
    public void beforeMethod(){
        pokerPlayer = new PokerPlayer(EditPlayerPageData.NEW_USER_EMAIL_DOMEN_INPUT_VALUE_INSERT_EDIT_PAGE.toString(), EditPlayerPageData.NEW_USER_FIRST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE.toString(), EditPlayerPageData.NEW_USER_LAST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE.toString(), EditPlayerPageData.NEW_USER_COUNTRY_INPUT_VALUE_INSERT_EDIT_PAGE.toString(), EditPlayerPageData.NEW_USER_CITY_INPUT_VALUE_INSERT_EDIT_PAGE.toString(), EditPlayerPageData.NEW_USER_ADDRESS_INPUT_VALUE_INSERT_EDIT_PAGE.toString(), EditPlayerPageData.NEW_USER_PHONE_INPUT_VALUE_INSERT_EDIT_PAGE.toString());

        LoginPage logInPage = new LoginPage(webDriver);
        logInPage.openHomePage();
        logInPage.login(LogInPageData.USER_NAME_INPUT_VALUE_LOGIN_PAGE.toString(), LogInPageData.PASSWORD_INPUT_VALUE_LOGIN_PAGE.toString());

        playersPage = new PlayersPage(webDriver);
        playersPage.openInsertPlayerPage();

        editPlayerPage = new EditPlayerPage(webDriver);
        editPlayerPage.addPlayer(pokerPlayer);

        Assert.assertEquals(PlayersPageData.TITLE_PLAYERS_PAGE.toString(), webDriver.getTitle(), "Title of site is wrong");

    }

    /**
     * Steps to reproduce:
     * 1. Find player by email.
     * 2. Open edit page for the player.
     * 3. Verify that title equals "Players - Edit".
     */
    @Test
    public void create(){
        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        Assert.assertEquals(EditPlayerPageData.TITLE_EDIT_PAGE.toString(), webDriver.getTitle(), "Player has not been added");
    }

    /**
     * Steps to reproduce:
     * 1. Find player by email.
     * 2. Open edit page for the player.
     * 3. Read data for player.
     */
    @Test
    public void read(){
        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        PokerPlayer actual = Util.readPokerPlayers(webDriver);
    }

    /**
     * Steps to reproduce:
     * 1. Find the player by email.
     * 2. Open edit page for the player.
     * 3. Verify that title of page equals "Players - Edit".
     * 4. Change information about the player.
     * 5. Verify that title of page equals "Players".
     * 6. Find the player by email.
     * 7. Open edit page for the player.
     * 8. Read information about the player.
     * 9. Check update of the player.
     */
    @Test
    public void update(){
        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        Assert.assertEquals(EditPlayerPageData.TITLE_EDIT_PAGE.toString(), webDriver.getTitle(), "Can not find user");

        pokerPlayer.setFirstName(EditPlayerPageData.EDIT_USER_FIRST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE.toString());
        pokerPlayer.setLastName(EditPlayerPageData.EDIT_USER_LAST_NAME_INPUT_VALUE_INSERT_EDIT_PAGE.toString());
        pokerPlayer.setCity(EditPlayerPageData.EDIT_USER_CITY_INPUT_VALUE_INSERT_EDIT_PAGE.toString());
        pokerPlayer.setAddress(EditPlayerPageData.EDIT_USER_ADDRESS_INPUT_VALUE_INSERT_EDIT_PAGE.toString());
        pokerPlayer.setPhone(EditPlayerPageData.EDIT_USER_PHONE_INPUT_VALUE_INSERT_EDIT_PAGE.toString());
        editPlayerPage.editPlayer(pokerPlayer);

        Assert.assertEquals(PlayersPageData.TITLE_PLAYERS_PAGE.toString(), webDriver.getTitle(), "Can not edit");

        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        PokerPlayer actual = Util.readPokerPlayers(webDriver);
        Util.assertPokerPlayer(actual, pokerPlayer);
    }

    @Test
    public void delete() {
        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.deletePlayer(pokerPlayer.getEmail());
        webDriver.switchTo().alert().accept();

        Assert.assertEquals(playersPage.deleteMessage(), PlayersPageData.DELETE_MASSEGE_TEXT_PLAYERS_PAGE.toString(),"Player does not delete");
    }

    /**
     * Post-conditions:
     * 1. Close page.
     */
    @AfterMethod
    public void afterMethod(){
        webDriver.close();
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
