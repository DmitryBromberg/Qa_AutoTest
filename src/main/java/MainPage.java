import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement cartProduct = $(By.xpath("//*[@id=\"vue-app\"]/div[4]/div[2]/div[4]/div/ul[2]/li[1]/div[2]/div[1]/div[1]/p/a"));
    private SelenideElement catalogAddButton = $(By.xpath("//li[@data-product-id='8142']//button[@class='catalog__buy btn btn_red btn_block']"));
    private SelenideElement cartAddButton = $(By.xpath("//div[@class='product__price-block']//button"));
    private SelenideElement btnQuickLook = $(By.xpath("//li[@data-product-id=\"8142\"]//button[@class='catalog__fast-view btn btn_sm btn_lc']"));
    private SelenideElement indikator = $(By.xpath("//span[@class='cart-quick__qt cart-quick__qt--ny19']"));
    private SelenideElement quickLookAddButton = $(By.xpath("//div[@class='product__row product__row--align-top']//button"));
    private SelenideElement iconSmallBsket = $(By.xpath("//div[@id='small-basket']/a[@href='/basket/']"));
    private SelenideElement quickLookClose = $(By.xpath("//a[@title='Закрыть']"));
    private SelenideElement EmptyBusket = $(By.xpath("//p[@class='cart-empty__title']"));
    private SelenideElement conFirm = $(By.xpath("//button[@class='btn btn_lc cookies-agree__btn cookies-agree__btn_confirm']"));


    ///Добавление с плитки товаров
    public SelenideElement addToBasketFromPlt() {
        catalogAddButton.click();
        iconSmallBsket.click();
        return indikator;
    }


    public SelenideElement addToBasketFromCart() {
        Selenide.executeJavaScript("javascript:window.scrollBy(0,300)");
        cartProduct.click();
        conFirm.click();
        Selenide.actions().moveToElement(cartAddButton).click().perform();
        return indikator;
    }

    public SelenideElement addToBasketFromQuickLook() {
        Selenide.executeJavaScript("javascript:window.scrollBy(0,150)");
        btnQuickLook.click();
        quickLookAddButton.click();
        quickLookClose.click();
        iconSmallBsket.click();
        return EmptyBusket;
    }
}
