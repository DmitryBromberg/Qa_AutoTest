import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class TestMainPage extends BaseMainPageTest{

        MainPage ad;

        ///При добавлении товара с плитки товара в пустую корзину,счетчик меняется на 1
        @Test
        public void isProdIntheBasketFromPlt(){
            ad= new MainPage();
            ad.addToBasketFromPlt().shouldBe(Condition.visible).
                                    shouldHave(Condition.text("1"));
        }

       ///При добавлении товара с карточки товара в пустую корзину,счетчик меняется на 1
        @Test
        public void isProdIntheBasketFromCart(){
            ad= new MainPage();
            ad.addToBasketFromCart().shouldHave(Condition.text("1"));
        }

        ///При добавлении товара с быстрого просмотра исчезает сообщение ваша корзина пуста
        @Test
        public void isProdFromquickLookPresent(){
            ad= new MainPage();
            ad.addToBasketFromQuickLook().shouldNot(Condition.visible);
        }

        ///Добавление товара с плитки в список желаний
        @Test
        public void isProdInWishListFromPlt(){
           ad = new MainPage();
           ad.addToWishListFromPlt().shouldBe(Condition.visible);
        }
}
