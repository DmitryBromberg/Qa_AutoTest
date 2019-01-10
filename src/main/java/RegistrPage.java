import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;



public class RegistrPage {


    SelenideElement buttonRegister = $(By.xpath("//a[@href='/register/']"));
    SelenideElement fieldName = $(By.xpath("//input[@id='reg-name']"));
    SelenideElement fieldEmail = $(By.xpath("//input[@id='reg-email']"));
    SelenideElement regNameError = $(By.xpath("//p[@id='reg-name-error']"));
    SelenideElement EmptyfieldEmailError = $(By.xpath("//p[@id='reg-email-error']"));
    SelenideElement fieldPass = $(By.xpath("//input[@id='reg-pass']"));
    SelenideElement EmptyFieldPassError = $(By.xpath("//p[@id='reg-pass-error']"));
    SelenideElement CheckBoxPersonalDat = $(By.xpath("//*[@id=\"vue-app\"]/section[1]/div[2]/div/form/div[1]/div[4]/label[1]"));
    SelenideElement checkBoxAgree = $(By.xpath("//label[@class='custom-check custom-check_type_checkbox order-auth__agreement']"));
    SelenideElement passConfirm = $(By.xpath("//*[@id=\"vue-app\"]/section[1]/div[2]/div/form/div[1]/p[3]/button"));
    SelenideElement textLk = $(By.xpath("//h1[@class='profile-main-title profile-main-title_visible-desktop']"));


    public ArrayList<SelenideElement> errorOfEmptyFields(){
        buttonRegister.click();
        fieldName.click();
        Selenide.executeJavaScript("window.scrollBy(0,200)");
        fieldEmail.click();
        fieldPass.click();
        Selenide.executeJavaScript("window.scrollBy(0,50)");
        $(CheckBoxPersonalDat).click();
        ArrayList<SelenideElement> arr = new ArrayList<SelenideElement>();
        arr.add(regNameError);
        arr.add(EmptyfieldEmailError);
        arr.add(EmptyFieldPassError);
        return arr;

    }


    public SelenideElement invalidEmail(String txt){
        buttonRegister.click();
        fieldEmail.setValue(txt).pressEnter();
        return EmptyfieldEmailError;
    }

    public SelenideElement successfulRegister(String email,String name,String pass){
        buttonRegister.click();
        fieldName.setValue(name);
        fieldEmail.setValue(email);
        Selenide.executeJavaScript("window.scrollBy(0,200)");
        fieldPass.setValue(pass);
        checkBoxAgree.click();
        Selenide.executeJavaScript("javascript:window.scrollBy(0,150)");
        passConfirm.click();
        return textLk;
    }


}
