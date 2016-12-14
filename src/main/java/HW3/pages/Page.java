package HW3.pages;

import HW3.Data.PathsData;
import org.openqa.selenium.WebDriver;

public class Page {
    protected WebDriver webDriver;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void openHomePage() {
        webDriver.get(PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString());
    }

    public void openPlayersPage(){
        webDriver.get(PathsData.URL.toString() + PathsData.PLAYERS_PAGE.toString());
    }
}
