import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class MainPageTest extends BaseTest{

        MainPage ad;

        ///При добавлении товара с плитки товара в пустую корзину,счетчик меняется на 1
        @Test
        public void isProdIntheBasketFromPlt(){
            open("https://market.leroymerlin.ru/catalogue/dreli-bezudarnye/");
            ad= new MainPage();
            ad.addToBasketFromPlt().shouldHave(Condition.text("1"));
        }

       ///При добавлении товара с карточки товара в пустую корзину,счетчик меняется на 1
        @Test
        public void isProdIntheBasketFromCart(){
            open("https://market.leroymerlin.ru/catalogue/dreli-bezudarnye/");
            ad= new MainPage();
            ad.addToBasketFromCart().shouldHave(Condition.text("1"));
        }

        ///При добавлении товара с быстрого просмотра исчезает сообщение ваша корзина пуста
        @Test
        public void isProdFromquickLookPresent(){
            open("https://market.leroymerlin.ru/catalogue/dreli-bezudarnye/");
            ad= new MainPage();
            ad.addToBasketFromQuickLook().shouldNot(Condition.visible);
        }
}
