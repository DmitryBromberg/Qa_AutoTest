import com.codeborne.selenide.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;


public class TestRegistration extends BaseRegisterPageTest {

    RegistrPage r;

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
        r = new RegistrPage();
            List<SelenideElement>elem = r.errorOfEmptyFields();
            for(SelenideElement e:elem){
                e.shouldHave(Condition.text(Utils.errorMessage));
            }


        }
        ///Проверка отображения ошибок под полем email при не валидных параметрах
        @Test(dataProvider = "data-provider")
        public void invalidEmailChecking(String txt){
            r = new RegistrPage();
            r.invalidEmail(txt).shouldHave(Condition.text("Некорректный e-mail")).should(Condition.visible);
        }

        ////Успешная регистрация
        @Test
        public void validEmail(){
            String randEmail = Utils.getRandomEmail();
            String randName = Utils.getRandomName();
            r = new RegistrPage();
            r.successfulRegister(randEmail,randName,Utils.pass).shouldHave(Condition.text("Личный кабинет Леруа Мерлен Маркет"));
        }

    }


