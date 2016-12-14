package dragAndDrop;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionPage {
    @FindBy(xpath = ".//ul[@id='sortable']/li[1]")
    private WebElement sourceElement;

    @FindBy(id = "drop")
    private WebElement targetElement;

    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=1]")
    private WebElement firstBlock;
    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=2]")
    private WebElement secondBlock;
    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=3]")
    private WebElement thirdBlock;
    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=4]")
    private WebElement forthBlock;
    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=5]")
    private WebElement fifthBlock;
    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=6]")
    private WebElement sixthBlock;
    @FindBy(xpath = ".//ul[@id='sortable']/li[text()=7]")
    private WebElement seventhBlock;

    private static WebDriver webDriver;
    private final static String URL = "A:\\TeamInternational\\CoursesAutomationQA\\Tasks\\AH3\\src\\main\\java\\dragAndDrop\\index.html";

    public ActionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void open(){
        webDriver.get(URL);
    }

    public void dragAndDrop(String number){
        new Actions(webDriver).dragAndDrop(webDriver.findElement(By.xpath(".//ul[@id='sortable']/li[text()=number]".replace("number", number))), targetElement).perform();
    }

    public void dismissDelete(){
        webDriver.switchTo().alert().dismiss();
    }

    public void acceptDelete(){
        webDriver.switchTo().alert().accept();
    }


    public boolean isDeleted(String number){
        try{
            webDriver.findElement(By.xpath(".//ul[@id='sortable']/li[text()=number]".replace("number", number)));
            return false;
        }catch (NoSuchElementException e){
            /*NOP*/
        }
        return true;
    }

    public void asceSort(){
        int [] numbers = new int[7];
        WebElement [] elements = new WebElement[7];

        elements[0] = firstBlock;
        elements[1] = secondBlock;
        elements[2] = thirdBlock;
        elements[3] = forthBlock;
        elements[4] = fifthBlock;
        elements[5] = sixthBlock;
        elements[6] = seventhBlock;

        numbers[0] = Integer.parseInt(firstBlock.getText());
        numbers[1] = Integer.parseInt(secondBlock.getText());
        numbers[2] = Integer.parseInt(thirdBlock.getText());
        numbers[3] = Integer.parseInt(forthBlock.getText());
        numbers[4] = Integer.parseInt(fifthBlock.getText());
        numbers[5] = Integer.parseInt(sixthBlock.getText());
        numbers[6] = Integer.parseInt(seventhBlock.getText());

        Actions actions = new Actions(webDriver);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]){
                    int y = elements[i].getLocation().getY();
                    int x = elements[i].getLocation().getX();

                    actions.dragAndDrop(elements[i], elements[j]).perform();
                    actions.clickAndHold(elements[j]).perform();
                    actions.moveByOffset(x, y).perform();
                    actions.release().perform();

                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
    }

    public void descSort(){
        int [] numbers = new int[7];
        WebElement [] elements = new WebElement[7];

        elements[0] = firstBlock;
        elements[1] = secondBlock;
        elements[2] = thirdBlock;
        elements[3] = forthBlock;
        elements[4] = fifthBlock;
        elements[5] = sixthBlock;
        elements[6] = seventhBlock;

        numbers[0] = Integer.parseInt(firstBlock.getText());
        numbers[1] = Integer.parseInt(secondBlock.getText());
        numbers[2] = Integer.parseInt(thirdBlock.getText());
        numbers[3] = Integer.parseInt(forthBlock.getText());
        numbers[4] = Integer.parseInt(fifthBlock.getText());
        numbers[5] = Integer.parseInt(sixthBlock.getText());
        numbers[6] = Integer.parseInt(seventhBlock.getText());

        Actions actions = new Actions(webDriver);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]){
                    int y = elements[i].getLocation().getY();
                    int x = elements[i].getLocation().getX();

                    actions.dragAndDrop(elements[i], elements[j]).perform();
                    actions.clickAndHold(elements[j]).perform();
                    actions.moveByOffset(x, y).perform();
                    actions.release().perform();

                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
    }

    public boolean hasDescSorted(){
        int [] numbers = new int[7];

        numbers[0] = Integer.parseInt(seventhBlock.getText());
        numbers[1] = Integer.parseInt(sixthBlock.getText());
        numbers[2] = Integer.parseInt(fifthBlock.getText());
        numbers[3] = Integer.parseInt(forthBlock.getText());
        numbers[4] = Integer.parseInt(thirdBlock.getText());
        numbers[5] = Integer.parseInt(secondBlock.getText());
        numbers[6] = Integer.parseInt(firstBlock.getText());

        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                return false;
            }
            max = numbers[i];
        }

        return true;
    }

    public boolean hasAsceSorted(){
        int [] numbers = new int[7];

        numbers[0] = Integer.parseInt(firstBlock.getText());
        numbers[1] = Integer.parseInt(secondBlock.getText());
        numbers[2] = Integer.parseInt(thirdBlock.getText());
        numbers[3] = Integer.parseInt(forthBlock.getText());
        numbers[4] = Integer.parseInt(fifthBlock.getText());
        numbers[5] = Integer.parseInt(sixthBlock.getText());
        numbers[6] = Integer.parseInt(seventhBlock.getText());

        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                return false;
            }
            min = numbers[i];
        }

        return true;
    }
}
