import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseDreliPageTest {

    @BeforeMethod
    public static void setUp() {
        open("https://market.leroymerlin.ru/catalogue/dreli-bezudarnye/");
    }
    @AfterMethod
    public static void tearDown(){
        Selenide.close();
    }
}
