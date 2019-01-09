import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class addProducsTest {

        addProducs ad;

        @BeforeClass
        public static void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\X3M\\Desktop\\chromedriver.exe");
            Configuration.browser = "chrome";
            open("https://market.leroymerlin.ru/catalogue/dreli-bezudarnye/");

        }
        @Test
        public void isProductIntheBasketFromPlt(){
            ad= new addProducs();
            ad.addToBasketFromPlt().shouldBe(Condition.visible);
        }
        @Test
        public void isProductIntheBasketFromCart(){
            ad= new addProducs();
            ad.addToBasketFromPlt().shouldBe(Condition.visible);
        }

}
