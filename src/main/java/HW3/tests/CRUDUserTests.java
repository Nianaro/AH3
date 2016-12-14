package HW3.tests;

import HW3.Entities.PokerPlayer;
import HW3.pages.EditPlayerPage;
import HW3.pages.LoginPage;
import HW3.pages.PlayersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class CRUDUserTests {

    private WebDriver webDriver;
    private PlayersPage playersPage;
    private EditPlayerPage editPlayerPage;
    private LoginPage logInPage;
    private PokerPlayer pokerPlayer;

    @DataProvider
    public Object[][] createUserData(){
        return new Object[][]{{
            "admin", "123", "Players", "Players - Edit", "@gmail.com", "FN", "LN", "UK", "Kharkov", "address", "+1234567890"
        }};
    }
    @DataProvider
    public Object[][] readUserData(){
        return new Object[][]{{
                "admin", "123", "Players", "Players - Edit", "@gmail.com", "FN", "LN", "UK", "Kharkov", "address", "+1234567890"
        }};
    }
    @DataProvider
    public Object[][] updateUserData(){
        return new Object[][]{{
                "admin", "123", "Players", "Players - Edit", "@gmail.com", "FN", "LN", "UK", "Kharkov", "address", "+1234567890", "First Name", "Last Name", "Kiev", "new", "no phone"
        }};
    }
    @DataProvider
    public Object[][] deleteData(){
        return new Object[][]{{
                "Player has been deleted", "admin", "123", "Players", "Players - Edit", "@gmail.com", "FN", "LN", "UK", "Kharkov", "address", "+1234567890"
        }};
    }

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
     * 1. Open login page.
     */
    @BeforeMethod
    public void beforeMethod(){
        logInPage = new LoginPage(webDriver);
        logInPage.openHomePage();
    }

    /**
     * Steps to reproduce:
     * 1. Create player.
     * 2. Log in.
     * 3 Open "Insert - Player" page.
     * 4. Add new player.
     * 5. Verify that title equals "Players".
     * 6. Find player by email.
     * 7. Open edit page for the player.
     * 8. Verify that title equals "Players - Edit".
     */
    @Test(dataProvider = "createUserData")
    public void create(String username, String password, String playersTitle, String editPlayersTitle, String emailDomein, String firstName, String lastName, String country, String city, String address, String phone){
        pokerPlayer = new PokerPlayer(emailDomein, firstName, lastName, country, city, address, phone);

        logInPage.login(username, password);

        playersPage = new PlayersPage(webDriver);
        playersPage.openInsertPlayerPage();

        editPlayerPage = new EditPlayerPage(webDriver);
        editPlayerPage.addPlayer(pokerPlayer);

        Assert.assertEquals(playersTitle, webDriver.getTitle(), "Title of site is wrong");

        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        Assert.assertEquals(editPlayersTitle, webDriver.getTitle(), "Player has not been added");

        editPlayerPage.openPlayersPage();
    }

    /**
     * Steps to reproduce:
     * 1. Create player.
     * 2. Find player by email.
     * 3. Open edit page for the player.
     * 4. Read data for player.
     */
    @Test(dataProvider = "createUserData")
    public void read(String username, String password, String playersTitle, String editPlayersTitle, String emailDomein, String firstName, String lastName, String country, String city, String address, String phone){
        create(username, password, playersTitle, editPlayersTitle, emailDomein, firstName, lastName, country, city, address, phone);

        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        EditPlayerPage editPlayerPage = new EditPlayerPage(webDriver);
        editPlayerPage.readPokerPlayers();
    }

    /**
     * Steps to reproduce:
     * 1. Create player.
     * 2. Find the player by email.
     * 3. Open edit page for the player.
     * 4. Verify that title of page equals "Players - Edit".
     * 5. Change information about the player.
     * 6. Verify that title of page equals "Players".
     * 7. Find the player by email.
     * 8. Open edit page for the player.
     * 9. Read information about the player.
     * 10. Check update of the player.
     */
    @Test(dataProvider = "updateUserData")
    public void update(String username, String password, String playersTitle, String editPlayersTitle, String emailDomein, String firstName, String lastName, String country, String city, String address, String phone, String newFirstName, String newLastName, String newCity, String newAddress, String newPhone){
        create(username, password, playersTitle, editPlayersTitle, emailDomein, firstName, lastName, country, city, address, phone);

        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        Assert.assertEquals(editPlayersTitle, webDriver.getTitle(), "Can not find user");

        pokerPlayer.setFirstName(newFirstName);
        pokerPlayer.setLastName(newLastName);
        pokerPlayer.setCity(newCity);
        pokerPlayer.setAddress(newAddress);
        pokerPlayer.setPhone(newPhone);
        editPlayerPage.editPlayer(pokerPlayer);

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(playersTitle, webDriver.getTitle(), "Can not edit");
        soft.assertAll();

        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.openEditPlayerPage(pokerPlayer.getEmail());

        EditPlayerPage editPlayerPage = new EditPlayerPage(webDriver);
        PokerPlayer actual = editPlayerPage.readPokerPlayers();
        editPlayerPage.assertPokerPlayer(actual, pokerPlayer);
    }

    /**
     * Steps to reproduce:
     * 1. Create player.
     * 2. Search player by email.
     * 3. Delete player.
     * 4. Check delete message.
     */
    @Test(dataProvider = "deleteData")
    public void delete(String deleteMsg, String username, String password, String playersTitle, String editPlayersTitle, String emailDomein, String firstName, String lastName, String country, String city, String address, String phone) {
        create(username, password, playersTitle, editPlayersTitle, emailDomein, firstName, lastName, country, city, address, phone);

        playersPage.searchPlayerByEmail(pokerPlayer.getEmail());
        playersPage.deletePlayer(pokerPlayer.getEmail());
        webDriver.switchTo().alert().accept();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(playersPage.getDeleteMessage(), deleteMsg,"Player does not delete");
        soft.assertAll();
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
