import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement cartTextProduct = $(By.xpath("//p[@class='catalog__name']/a[@data-product-id=\"8142\"]"));;
    private SelenideElement catalogAddButton = $(By.xpath("//li[@data-product-id='8142']//button[@class='catalog__buy btn btn_red btn_block']"));
    private SelenideElement cartAddButton = $(By.xpath("//div[@class='product__price-block']//button"));
    private SelenideElement btnQuickLook = $(By.xpath("//li[@data-product-id=\"8142\"]//button[@class='catalog__fast-view btn btn_sm btn_lc']"));
    private SelenideElement indikator = $(By.xpath("//span[@class='cart-quick__qt cart-quick__qt--ny19']"));
    private SelenideElement quickLookAddButton = $(By.xpath("//div[@class='product__row product__row--align-top']//button"));
    private SelenideElement iconSmallBsket = $(By.xpath("//div[@id='small-basket']/a[@href='/basket/']"));
    private SelenideElement quickLookClose = $(By.xpath("//a[@class='fancybox-item fancybox-close']"));
    private SelenideElement emptyBusket = $(By.xpath("//p[@class='cart-empty__title']"));
    private SelenideElement conFirm = $(By.xpath("//button[@class='btn btn_lc cookies-agree__btn cookies-agree__btn_confirm']"));
    private SelenideElement addToWishList = $(By.xpath("//li[@data-product-id=\"8142\"]//span[@class='btn__text']"));
    private SelenideElement iconWishList = $(By.xpath("//div[@id='shop-list']/a[@href='/shopping_list/']"));
    private SelenideElement prodInWishList = $(By.xpath("//div[@class='catalog__pic']/a"));


    ///Добавление с плитки товаров
    public SelenideElement addToBasketFromPlt() {
        catalogAddButton.click();
        iconSmallBsket.click();
        return indikator;
    }


    public SelenideElement addToBasketFromCart() {
        Selenide.executeJavaScript("window.scrollBy(0,300)");
        cartTextProduct.click();
        conFirm.click();
        Selenide.actions().moveToElement(cartAddButton).click().perform();
        return indikator;
    }

    public SelenideElement addToBasketFromQuickLook() {
        Selenide.executeJavaScript("window.scrollBy(0,150)");
        btnQuickLook.click();
        quickLookAddButton.click();
        quickLookClose.click();
        iconSmallBsket.click();
        return emptyBusket;
    }
    public SelenideElement addToWishListFromPlt(){
      addToWishList.click();
      iconWishList.click();
      return prodInWishList;

    }
}
