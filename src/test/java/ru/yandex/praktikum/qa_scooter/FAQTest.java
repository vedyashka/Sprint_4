package ru.yandex.praktikum.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.MainPage;

@RunWith(Parameterized.class)
public class FAQTest {
    private WebDriver driver;
    private final String text;
    private final int index;

    public FAQTest(String text, int index) {
        this.text = text;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswerList() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
                {"Тестовый текст", 0},
                {"Тестовый текст", 1},
                {"Тестовый текст", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Тестовый текст", 4},
                {"Тестовый текст", 5},
                {"Тестовый текст", 6},
                {"Тестовый текст", 7},
        };
    }

    @Test
    public void checkDropDownListChrome() {
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.getFAQSection();
        mainPage.clickDropDownList(index);
        Assert.assertEquals("Ошибка в тексте", text, mainPage.getAnswer(index));
    }

    @Test
    public void checkDropDownListFireFox() {
        driver = new FirefoxDriver();
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