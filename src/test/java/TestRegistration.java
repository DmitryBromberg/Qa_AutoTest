import com.codeborne.selenide.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.url;

public class TestRegistration {

    Registration r;

        @BeforeClass
        public static void setUp(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\X3M\\Desktop\\chromedriver.exe");
            Configuration.browser = "chrome";
            open("https://market.leroymerlin.ru");
        }
    @DataProvider(name = "data-provider")
        public static Object[][] someParam() {
            return new Object[][]{
                    {"test"},
                    {"test@"},
                    {"@yandex."},
                    {"@yandex.r"},
                    {"@yandex.ru"},
            };
        }


        @Test
        public void emptyFieldsChecking(){
            r = new Registration();
            r.errorOfEmptyFields().get(0).shouldHave(Condition.text("Обязательное поле"));
            r.errorOfEmptyFields().get(1).shouldHave(Condition.text("Обязательное поле"));
            r.errorOfEmptyFields().get(2).shouldHave(Condition.text("Обязательное поле"));

        }
        @Test(dataProvider = "data-provider")
        public void invalidEmailChecking(String txt){
            r = new Registration();
            r.invalidEmail(txt).shouldHave(Condition.text("Некорректный e-mail")).should(Condition.visible);
        }
    }


