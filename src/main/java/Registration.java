import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.url;

public class Registration {
    By buttonRegister = By.xpath("//a[@href='/register/']");
    By fieldName = By.xpath("//input[@id='reg-name']");
    By fieldEmail = By.xpath("//input[@id='reg-email']");
    By EmptyfieldNameError = By.xpath("//p[@id='reg-name-error']");
    By InvalidEmailError = By.xpath("//p[text()='Некорректный e-mail']]");
    By EmptyfieldEmailError = By.xpath("//p[@id='reg-email-error']");
    By fieldPass = By.xpath("//input[@id='reg-pass']");
    By EmptyFieldPassError = By.xpath("//p[@id='reg-pass-error']");
    By CheckBoxPersonalDat = By.xpath("//*[@id=\"vue-app\"]/section[1]/div[2]/div/form/div[1]/div[4]/label[1]");
    // By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']/..");


    public String presentOfPopap(){
        $(buttonRegister).click();
        return url();

    }

    public ArrayList<SelenideElement> errorOfEmptyFields(){
        $(buttonRegister).click();
        $(fieldName).click();
        $(fieldEmail).click();
        Selenide.executeJavaScript("window.scrollBy(0,400)");
        $(fieldPass).click();
        Selenide.executeJavaScript("window.scrollBy(0,50)");
        $(CheckBoxPersonalDat).click();
        ArrayList<SelenideElement> arr = new ArrayList<SelenideElement>();
        arr.add($(EmptyfieldNameError));
        arr.add($(EmptyfieldEmailError));
        arr.add($(EmptyFieldPassError));
        //Selenide.actions().moveByOffset(400,500).perform();
        //return $(EmptyfieldNameError);
        return arr;

    }


    public SelenideElement invalidEmail(String txt){
        $(buttonRegister).click();
        $(fieldEmail).setValue(txt).pressEnter();

        return $(EmptyfieldEmailError);
    }
}
