import com.codeborne.selenide.Condition;
import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class TestDreliPage extends BaseDreliPageTest{

         DreliPage dr;

        ///При добавлении товара с плитки товара в пустую корзину,счетчик меняется на 1
        @Test
        public void isProdIntheBasketFromPlt(){
            dr= new DreliPage();
            dr.addToBasketFromPlt().should(Condition.exist)
                                   .shouldBe(Condition.visible)
                                   .shouldHave(Condition.text("1"));
        }

       ///При добавлении товара с карточки товара в пустую корзину,счетчик меняется на 1
        @Test
        public void isProdIntheBasketFromCart(){
            dr= new DreliPage();
            dr.addToBasketFromCart().shouldHave(Condition.text("1"));
        }

        ///При добавлении товара с быстрого просмотра исчезает сообщение ваша корзина пуста
        @Test
        public void isProdFromquickLookPresent(){
            dr= new DreliPage();
            dr.addToBasketFromQuickLook().shouldNot(Condition.visible);
        }

        ///Добавление товара с плитки в список желаний
        @Test
        public void isProdInWishListFromPlt(){
           dr = new DreliPage();
           dr.addToWishListFromPlt().shouldBe(Condition.visible);
        }
        ///Проверка сортировки товаров по возрастанию
        @Test
        public void isAscendingOrderCorrect(){
            dr = new DreliPage();
            Assert.assertTrue(dr.isCollectionAscending());
        }
        //////Проверка сортировки товаров по убыванию
        @Test
        public void isDescetingOrderCorrect(){
            dr = new DreliPage();
            Assert.assertTrue(dr.isCollectionDesceting());
    }

    ///проверка сортировки по названию
        @Test
        public void isSortByNameCorrect(){
            dr = new DreliPage();
            Assert.assertTrue(dr.isCollectionSortByName());
        }

}
