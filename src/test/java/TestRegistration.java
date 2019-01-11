import com.codeborne.selenide.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;
import java.util.Random;



public class TestRegistration extends BaseTest {

    RegistrPage r;
    String errorMessage = "Обязательное поле";
    String pass = "Qwert1993";
    ////Генератор параметров
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

        ///Проверка отображения ошибок под пустыми полями
        @Test
        public void emptyFieldsChecking(){
            open("https://market.leroymerlin.ru");
            r = new RegistrPage();
            List<SelenideElement>elem = r.errorOfEmptyFields();
            for(SelenideElement e:elem){
                e.shouldHave(Condition.text(errorMessage));
            }


        }
        ///Проверка отображения ошибок под полем email при не валидных параметрах
        @Test(dataProvider = "data-provider")
        public void invalidEmailChecking(String txt){
            open("https://market.leroymerlin.ru");
            r = new RegistrPage();
            r.invalidEmail(txt).shouldHave(Condition.text("Некорректный e-mail")).should(Condition.visible);
        }

        ////Успешная регистрация
        @Test
        public void validEmail(){
            open("https://market.leroymerlin.ru");
            String randEmail = getRandomEmail();
            String randName = getRandomName();
            r = new RegistrPage();
            r.successfulRegister(randEmail,randName,pass).shouldHave(Condition.text("Личный кабинет Леруа Мерлен Маркет"));
        }
    }


