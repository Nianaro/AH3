package dragAndDrop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class ActionTest {
    private WebDriver webDriver;
    private ActionPage actionPage;
    private SoftAssert softAssert;

    @DataProvider
    public Object[][] deletingElement(){
        return new Object[][]{{
                "7"
        }};
    }

    @BeforeTest
    public void beforeTest(){
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actionPage = new ActionPage(webDriver);
    }

    @BeforeMethod
    public void beforeMethod(){
        softAssert = new SoftAssert();
    }

    @Test(dataProvider = "deletingElement")
    public void dragAndDropTest(String number){
        actionPage.open();
        actionPage.dragAndDrop(number);
        actionPage.dismissDelete();

        softAssert.assertFalse(actionPage.isDeleted(number), "Element was deleted");

        actionPage.dragAndDrop(number);
        actionPage.acceptDelete();
        softAssert.assertTrue(actionPage.isDeleted(number), "Element was not deleted");

        softAssert.assertAll();
    }

    @Test
    public void descSort(){//2-1
        actionPage.open();
        actionPage.descSort();
        softAssert.assertTrue(actionPage.hasDescSorted(), "Does not sort");
        softAssert.assertAll();
    }

    @Test
    public void asceSort(){//1-2
        actionPage.open();
        actionPage.asceSort();
        softAssert.assertTrue(actionPage.hasAsceSorted(), "Does not sort");
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest(){
        webDriver.quit();
    }
}
