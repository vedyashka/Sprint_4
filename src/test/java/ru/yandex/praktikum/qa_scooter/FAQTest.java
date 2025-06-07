package ru.yandex.praktikum.qa_scooter;

import config.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page_object.MainPage;

@RunWith(Parameterized.class)
public class FAQTest {
    private WebDriver driver;
    private final String text;
    private final int index;
    private final String browser;

    public FAQTest(String text, int index, String browser) {
        this.text = text;
        this.index = index;
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswerList() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0, "chrome"},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1, "chrome"},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2, "firefox"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3, "firefox"},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4, "chrome"},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5, "chrome"},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6, "firefox"},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7, "firefox"},
                {"Тестовый текст", 0, "chrome"},
                {"Тестовый текст", 1, "chrome"},
                {"Тестовый текст", 2, "firefox"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3, "firefox"},
                {"Тестовый текст", 4, "chrome"},
                {"Тестовый текст", 5, "chrome"},
                {"Тестовый текст", 6, "firefox"},
                {"Тестовый текст", 7, "firefox"},
        };
    }

    @Test
    public void checkDropDownListTest() {
        driver = WebDriverFactory.getWebDriver(browser);
        MainPage mainPage = new MainPage(driver);

        mainPage.getFAQSection();
        mainPage.clickDropDownList(index);
        Assert.assertEquals("Ошибка в тексте", text, mainPage.getAnswer(index));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}