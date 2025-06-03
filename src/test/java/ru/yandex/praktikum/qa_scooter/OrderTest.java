package ru.yandex.praktikum.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String comment;


    public OrderTest(String name, String surname, String address, String phoneNumber, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderPageData() {
        return new Object[][]{
                {"Райан", "Гослинг", "Москва", "89993332211", "Обязательно оставь самокат на парковке у дома"},
                {"Слава", "Мэрлоу", "Санкт-Петербург", "896533322135635636", "Домофон не работает"},
                {"Валерий", "Кипелов", "Saratov", "89101782211", "Оставьте самокат у двери"},
        };
    }

    @Test
    //Заказ самоката по кнопке "Заказать" в середине страницы на FIREFOX
    public void checkOrderScooterByMiddleButtonFireFox() {
        driver = new FirefoxDriver();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickOrderButtonMiddle();  //Кликнули на "Заказать" в тексте
        orderPage.sendFirstOrderPage(name, surname, address, phoneNumber);  //Заполнили форму "Для кого самокат"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Далее'", orderPage.checkActionGoButton());

        orderPage.sendSecondOrderPage(comment);  //Заполнили форму "Про аренду"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Да'", orderPage.checkClickYesButton());

        Assert.assertTrue("Что-то пошло не так", orderPage.checkFinalModalWindow());
    }

    @Test
    //Заказ самоката по кнопке "Заказать" в середине страницы на CHROME
    public void checkOrderScooterByMiddleButtonChrome() {
        driver = new ChromeDriver();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickOrderButtonMiddle();  //Кликнули на "Заказать" в тексте
        orderPage.sendFirstOrderPage(name, surname, address, phoneNumber);  //Заполнили форму "Для кого самокат"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Далее'", orderPage.checkActionGoButton());

        orderPage.sendSecondOrderPage(comment);  //Заполнили форму "Про аренду"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Да'", orderPage.checkClickYesButton());

        Assert.assertTrue("Что-то пошло не так", orderPage.checkFinalModalWindow());
    }

    @Test
    //Заказ самоката по кнопке "Заказать" вверху страницы на FIREFOX
    public void checkOrderScooterByHeaderButtonFireFox() {
        driver = new FirefoxDriver();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickOrderButtonUp();  //Кликнули на "Заказать" в тексте
        orderPage.sendFirstOrderPage(name, surname, address, phoneNumber);  //Заполнили форму "Для кого самокат"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Далее'", orderPage.checkActionGoButton());

        orderPage.sendSecondOrderPage(comment);  //Заполнили форму "Про аренду"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Да'", orderPage.checkClickYesButton());

        Assert.assertTrue("Что-то пошло не так", orderPage.checkFinalModalWindow());
    }

    @Test
    //Заказ самоката по кнопке "Заказать" вверху страницы на CHROME
    public void checkOrderScooterByHeaderButtonChrome() {
        driver = new ChromeDriver();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.clickOrderButtonUp();  //Кликнули на "Заказать" в тексте
        orderPage.sendFirstOrderPage(name, surname, address, phoneNumber);  //Заполнили форму "Для кого самокат"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Далее'", orderPage.checkActionGoButton());

        orderPage.sendSecondOrderPage(comment);  //Заполнили форму "Про аренду"
        Assert.assertTrue("Ошибка при нажатии кнопки 'Да'", orderPage.checkClickYesButton());

        Assert.assertTrue("Что-то пошло не так", orderPage.checkFinalModalWindow());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}