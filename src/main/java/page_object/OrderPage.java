package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;

    //Локаторы
    private final String url = "https://qa-scooter.praktikum-services.ru/"; //Адрес сайта
    private final By confirmCookieButton = By.xpath(".//button[@id='rcc-confirm-button']");  //Кнопка принять куки
    private final By orderButtonInHeader = By.xpath(".//div[@class='Header_Header__214zg']//button[@class='Button_Button__ra12g']");  //Кнопка "Заказать" в верхнем тулбаре
    private final By orderButtonInText = By.xpath(".//button[text()='Заказать']");  //Кнопка "Заказать" в середине страницы
    private final By subHeaderFAQ = By.xpath(".//button[@class='Button_Button__ra12g']");  //Заголовок в тексте "Вопросы о важном"
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");  //Поле "Имя"
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");  //Поле "Фамилия"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");  //Поле "Адрес"
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");  //Поле "Станция метро"
    private final By chosenMetroStationButton = By.xpath(".//div[text()='Черкизовская']");  //Выбранная станция метро
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");  //Поле "Телефон"
    private final By actionGoButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");  //Кнопка "Далее"
    private final By whenBeginningRentField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");  //Поле "Когда привезти самокат"
    private final By dateBeginningRentButton = By.xpath(".//div[contains(@class,'react-datepicker__day react-datepicker__day')and text()='12']");  //Кнопка с конкретной датой в календаре
    private final By rentalPeriodField = By.xpath(".//div[text()='* Срок аренды']");  //Поле "Срок аренды"
    private final By rentalPeriodButton = By.xpath(".//div[text()='двое суток']");  //Кнопка со сроком аренды
    private final By scooterColorCheckBox = By.xpath(".//input[@id='black']");  //Чек-бокс с цветом самоката
    private final By commentForCourierField = By.xpath(".//input[@placeholder='Комментарий для курьера']");  //Поле "Комментарий для курьера"
    private final By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");  //Кнопка "Заказать" на странице заказа
    private final By yesButton = By.xpath(".//button[text()='Да']");  //Кнопка "Да"
    private final By finalModalWindow = By.xpath(".//button[text()='Посмотреть статус']");  //Модальное окно с номером заказа

    //Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    public void open() {   //Открыть страницу
        driver.get(url);
    }

    public void clickConfirmCookieButton() {   //Принять куки
        driver.findElement(confirmCookieButton).click();
    }

    public void scrollToElement() {   //Проскроллить до выбранного элемента
        WebElement element = driver.findElement(subHeaderFAQ);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderButtonInText() {   //Кликнуть "Заказать" в тексте
        driver.findElement(orderButtonInText).click();
    }

    public void clickOrderButtonInHeader() {  //Кликнуть "Заказать" вверху страницы
        driver.findElement(orderButtonInHeader).click();
    }

    public void clickOrderButtonMiddle() {   //Шаг для клика по кнопке "Заказать" в тексте
        open();
        clickConfirmCookieButton();
        scrollToElement();
        clickOrderButtonInText();
    }

    public void clickOrderButtonUp() {   //Шаг для клика по кнопке "Заказать" вверху страницы
        open();
        clickConfirmCookieButton();
        clickOrderButtonInHeader();
    }

    public void sendValueNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void sendValueSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void sendValueAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void clickMetroStationField() {
        driver.findElement(metroStationField).click();
    }

    public void clickChosenMetroStationButton() {
        driver.findElement(chosenMetroStationButton).click();
    }

    public void sendValuePhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public boolean checkActionGoButton() {
        if (driver.findElement(actionGoButton).isEnabled() && driver.findElement(actionGoButton).isDisplayed()) {
            driver.findElement(actionGoButton).click();
            if (driver.findElement(whenBeginningRentField).isEnabled() && driver.findElement(whenBeginningRentField).isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public void sendFirstOrderPage(String name, String surname, String address, String phoneNumber) {   //Шаг для заполнения формы с перс. данными
        sendValueNameField(name);
        sendValueSurnameField(surname);
        sendValueAddressField(address);
        clickMetroStationField();
        clickChosenMetroStationButton();
        sendValuePhoneNumberField(phoneNumber);
    }


    public void clickWhenBeginningRentField() {
        driver.findElement(whenBeginningRentField).click();
    }

    public void clickDateBeginningRentButton() {
        driver.findElement(dateBeginningRentButton).click();
    }

    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }

    public void clickRentalPeriodButton() {
        driver.findElement(rentalPeriodButton).click();
    }

    public void clickScooterColorCheckBox() {
        driver.findElement(scooterColorCheckBox).click();
    }

    public void sendCommentForCourierField(String comment) {
        driver.findElement(commentForCourierField).sendKeys(comment);
    }

    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }

    public boolean checkClickYesButton() {
        if (driver.findElement(yesButton).isDisplayed() && driver.findElement(yesButton).isEnabled()) {
            driver.findElement(yesButton).click();
            if (driver.findElement(finalModalWindow).isDisplayed() && driver.findElement(finalModalWindow).isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFinalModalWindow() {
        return driver.findElement(finalModalWindow).isDisplayed();
    }

    public void sendSecondOrderPage(String comment) {
        clickWhenBeginningRentField();
        clickDateBeginningRentButton();
        clickRentalPeriodField();
        clickRentalPeriodButton();
        clickScooterColorCheckBox();
        sendCommentForCourierField(comment);
        clickFinalOrderButton();
    }
}