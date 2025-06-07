package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By confirmCookieButton = By.xpath(".//button[@id='rcc-confirm-button']");  //Кнопка куки "да все привыкли"
    private final By subHeaderFAQ = By.xpath(".//button[@class='Button_Button__ra12g']");  //Заголовок в тексте "Вопросы о важном"

    private By dropDownListButton0 = By.xpath(".//div[@id='accordion__heading-0']");  //Выпадающий список 1
    private By dropDownListButton1 = By.xpath(".//div[@id='accordion__heading-1']");  //Выпадающий список 2
    private By dropDownListButton2 = By.xpath(".//div[@id='accordion__heading-2']");  //Выпадающий список 3
    private By dropDownListButton3 = By.xpath(".//div[@id='accordion__heading-3']");  //Выпадающий список 4
    private By dropDownListButton4 = By.xpath(".//div[@id='accordion__heading-4']");  //Выпадающий список 5
    private By dropDownListButton5 = By.xpath(".//div[@id='accordion__heading-5']");  //Выпадающий список 6
    private By dropDownListButton6 = By.xpath(".//div[@id='accordion__heading-6']");  //Выпадающий список 7
    private By dropDownListButton7 = By.xpath(".//div[@id='accordion__heading-7']");  //Выпадающий список 8
    private By answerText0 = By.xpath(".//div[@id='accordion__panel-0']");
    private By answerText1 = By.xpath(".//div[@id='accordion__panel-1']");
    private By answerText2 = By.xpath(".//div[@id='accordion__panel-2']");
    private By answerText3 = By.xpath(".//div[@id='accordion__panel-3']");
    private By answerText4 = By.xpath(".//div[@id='accordion__panel-4']");
    private By answerText5 = By.xpath(".//div[@id='accordion__panel-5']");
    private By answerText6 = By.xpath(".//div[@id='accordion__panel-6']");
    private By answerText7 = By.xpath(".//div[@id='accordion__panel-7']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickConfirmCookieButton() {
        driver.findElement(confirmCookieButton).click();
    }

    public void scrollToElement() {
        WebElement element = driver.findElement(subHeaderFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void getFAQSection() {
        open();
        clickConfirmCookieButton();
        scrollToElement();
    }

    public void clickDropDownList(int index) {
        if (index == 0) {
            driver.findElement(dropDownListButton0).click();
        } else if (index == 1) {
            driver.findElement(dropDownListButton1).click();
        } else if (index == 2) {
            driver.findElement(dropDownListButton2).click();
        } else if (index == 3) {
            driver.findElement(dropDownListButton3).click();
        } else if (index == 4) {
            driver.findElement(dropDownListButton4).click();
        } else if (index == 5) {
            driver.findElement(dropDownListButton5).click();
        } else if (index == 6) {
            driver.findElement(dropDownListButton6).click();
        } else if (index == 7) {
            driver.findElement(dropDownListButton7).click();
        }
    }

    public String getAnswer(int index) {
        if (index == 0) {
            return driver.findElement(answerText0).getText();
        } else if (index == 1) {
            return driver.findElement(answerText1).getText();
        } else if (index == 2) {
            return driver.findElement(answerText2).getText();
        } else if (index == 3) {
            return driver.findElement(answerText3).getText();
        } else if (index == 4) {
            return driver.findElement(answerText4).getText();
        } else if (index == 5) {
            return driver.findElement(answerText5).getText();
        } else if (index == 6) {
            return driver.findElement(answerText6).getText();
        } else if (index == 7) {
            return driver.findElement(answerText7).getText();
        } else return null;
    }
}