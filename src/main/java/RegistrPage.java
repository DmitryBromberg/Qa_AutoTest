import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import java.util.ArrayList;
import java.util.List;


public class RegistrPage {


    private SelenideElement buttonRegister = $(By.xpath("//a[@href='/register/']"));
    private SelenideElement fieldName = $(By.xpath("//input[@id='reg-name']"));
    private SelenideElement fieldEmail = $(By.xpath("//input[@id='reg-email']"));
    private SelenideElement regNameError = $(By.xpath("//p[@id='reg-name-error']"));
    private SelenideElement emptyfieldEmailError = $(By.xpath("//p[@id='reg-email-error']"));
    private SelenideElement fieldPass = $(By.xpath("//input[@id='reg-pass']"));
    private SelenideElement emptyFieldPassError = $(By.xpath("//p[@id='reg-pass-error']"));
    private SelenideElement сheckBoxPersonalDat = $(By.xpath("//*[@id=\"vue-app\"]/section[1]/div[2]/div/form/div[1]/div[4]/label[1]"));
    private SelenideElement checkBoxAgree = $(By.xpath("//label[@class='custom-check custom-check_type_checkbox order-auth__agreement']"));
    private SelenideElement passConfirm = $(By.xpath("//*[@id=\"vue-app\"]/section[1]/div[2]/div/form/div[1]/p[3]/button"));
    private SelenideElement textLk = $(By.xpath("//h1[@class='profile-main-title profile-main-title_visible-desktop']"));


    public List<com.codeborne.selenide.SelenideElement> errorOfEmptyFields(){
        buttonRegister.click();
        fieldName.click();
        Selenide.executeJavaScript("window.scrollBy(0,200)");
        fieldEmail.click();
        fieldPass.click();
        Selenide.executeJavaScript("window.scrollBy(0,50)");
        сheckBoxPersonalDat.click();
        ArrayList<SelenideElement> arr = new ArrayList<SelenideElement>();
        arr.add(regNameError);
        arr.add(emptyfieldEmailError);
        arr.add(emptyFieldPassError);
        return arr;

    }


    public SelenideElement invalidEmail(String txt){
        buttonRegister.click();
        fieldEmail.setValue(txt).pressEnter();
        return emptyfieldEmailError;
    }

    public SelenideElement successfulRegister(String email,String name,String pass){
        buttonRegister.click();
        fieldName.setValue(name);
        fieldEmail.setValue(email);
        Selenide.executeJavaScript("window.scrollBy(0,200)");
        fieldPass.setValue(pass);
        checkBoxAgree.click();
        Selenide.executeJavaScript("window.scrollBy(0,150)");
        passConfirm.click();
        return textLk;
    }


}
