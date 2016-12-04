package HW3.Utils;
import HW3.Data.EditPlayerPageData;
import HW3.Entities.PokerPlayer;
import HW3.Errors.InappropriatePokerPlayerFieldException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {
    public static PokerPlayer readPokerPlayers(WebDriver webDriver) {
        PokerPlayer expected = new PokerPlayer();
        expected.setEmail(webDriver.findElement(By.xpath(EditPlayerPageData.EMAIL_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"), "");
        expected.setFirstName(webDriver.findElement(By.xpath(EditPlayerPageData.FIRST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"));
        expected.setLastName(webDriver.findElement(By.xpath(EditPlayerPageData.LAST_NAME_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"));
        expected.setCity(webDriver.findElement(By.xpath(EditPlayerPageData.CITY_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"));
        expected.setCountry(webDriver.findElement(By.xpath(EditPlayerPageData.COUNTRY_SELCT_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"));
        expected.setAddress(webDriver.findElement(By.xpath(EditPlayerPageData.ADDRESS_TEXTAREA_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"));
        expected.setPhone(webDriver.findElement(By.xpath(EditPlayerPageData.PHONE_INPUT_XPATH_INSERT_EDIT_PAGE.toString())).getAttribute("value"));
        return expected;
    }

    public static void assertPokerPlayer(PokerPlayer actual, PokerPlayer expected){
        if (!expected.equals(actual)) {
            if (!actual.getEmail().equals(expected.getEmail())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate email");
            } else if (!actual.getFirstName().equals(expected.getFirstName())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate first name");
            } else if (!actual.getLastName().equals(expected.getLastName())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate last name");
            } else if (!actual.getCity().equals(expected.getCity())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate city");
            } else if (!actual.getCountry().equals(expected.getCountry())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate country");
            } else if (!actual.getAddress().equals(expected.getAddress())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate address");
            } else if (!actual.getPhone().equals(expected.getPhone())) {
                throw new InappropriatePokerPlayerFieldException("Inappropriate phone");
            }
        }
    }

}
