package HW3.pages;

import HW3.Data.PathsData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class Page {
    protected WebDriver webDriver;

    public Page() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public Page(WebDriver webDriver, long time, TimeUnit timeUnit) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public void openHomePage() {
        webDriver.get(PathsData.URL.toString() + PathsData.LOGIN_PAGE.toString());
    }
}
