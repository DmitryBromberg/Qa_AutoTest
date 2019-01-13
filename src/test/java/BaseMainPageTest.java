import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BaseMainPageTest {
    @BeforeClass
    public static void setUp() {
        open("https://market.leroymerlin.ru/catalogue/dreli-bezudarnye/");
    }
}
