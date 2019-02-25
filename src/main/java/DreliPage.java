import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class DreliPage {

    private SelenideElement cartTextProduct = $(xpath("//p[@class='catalog__name']/a[@data-product-id=\"8142\"]"));;
    private SelenideElement catalogAddButton = $(xpath("//li[@data-product-id='8142']//button[@class='catalog__buy btn btn_red btn_block']"));
    private SelenideElement cartAddButton = $(xpath("//div[@class='product__price-block']//button"));
    private SelenideElement btnQuickLook = $(xpath("//li[@data-product-id=\"8142\"]//button[@class='catalog__fast-view btn btn_sm btn_lc']"));
    private SelenideElement indikator = $(xpath("//*[@id=\"small-basket\"]/a/span/span"));
    private SelenideElement quickLookAddButton = $(xpath("//div[@class='product__row product__row--align-top']//button"));
    private SelenideElement iconSmallBsket = $(xpath("//div[@id='small-basket']/a[@href='/basket/']"));
    private SelenideElement quickLookClose = $(xpath("//a[@class='fancybox-item fancybox-close']"));
    private SelenideElement emptyBusket = $(xpath("//p[@class='cart-empty__title']"));
    private SelenideElement conFirm = $(xpath("//button[@class='btn btn_lc cookies-agree__btn cookies-agree__btn_confirm']"));
    private SelenideElement addToWishList = $(xpath("//li[@data-product-id=\"8142\"]//span[@class='btn__text']"));
    private SelenideElement iconWishList = $(xpath("//div[@id='shop-list']/a[@href='/shopping_list/']"));
    private SelenideElement prodInWishList = $(xpath("//div[@class='catalog__pic']/a"));
    private static SelenideElement sortDroplist = $(xpath("//*[@id=\"select2-sorting-order-top-container\"]"));
    private SelenideElement ascSorted = $(xpath("//select[@id='sorting-order-top']/option[@value='price_asc']"));
    private SelenideElement descSorted = $(xpath("//select[@id='sorting-order-top']/option[@value='price_desc']"));
    private static SelenideElement sortContainer = $(xpath("//div[@class='sorting__order sorting__order_catalog sorting__order_quantity']"));
    private static SelenideElement sortQuantity = $(xpath("//select[@id='sorting-quantity-top']/option[@value='50']"));
    private static SelenideElement sortByName = $(xpath("//select[@id='sorting-order-top']/option[@value='name']"));


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
        cartAddButton.click();
        iconSmallBsket.click();
        return indikator.waitUntil(Condition.visible,10000);

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
    public ArrayList<Double> ascendingOrder() {
        sortDroplist.click();
        ascSorted.click();
        sortContainer.click();
        sortQuantity.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Double> cost = new ArrayList<>();
        ElementsCollection elementsCollection = $$(By.xpath("//p[@class='catalog__price']/span[text()]"));
        for(SelenideElement e:elementsCollection){
            String str = e.text();
            String str1 = str.replaceAll("[^0-9,]", "");
            cost.add(Double.parseDouble(str1.replace(",",".")));
        }
        return  cost;
    }

    ///возвращает true если коллекция упорядочена по возрастанию
    public boolean isCollectionAscending(){
        boolean isOrder = Ordering.natural().isOrdered(ascendingOrder());
        return isOrder;
    }

    ///получение упорядоченой коллекции по убыванию
    public ArrayList<Double>descetingOrder(){
        sortDroplist.click();
        descSorted.click();
        sortContainer.click();
        sortQuantity.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Double> cost = new ArrayList<>();
        ElementsCollection elementsCollection = $$(By.xpath("//p[@class='catalog__price']/span[text()]"));
        for(SelenideElement e:elementsCollection){
            String str = e.text();
            String str1 = str.replaceAll("[^0-9,]", "");
            cost.add(Double.parseDouble(str1.replace(",",".")));
        }
        return cost;
    }
    ///возвращает true если коллекция упорядочена по убыванию
    public boolean isCollectionDesceting(){
        boolean isOrder = Ordering.natural().reverse().isOrdered(descetingOrder());
        return isOrder;
    }
    public ArrayList<String> collectionSortByName(){
        sortDroplist.click();
        sortByName.click();
        sortContainer.click();
        sortQuantity.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String>arr = new ArrayList<>();
        ElementsCollection elementsCollection = $$(By.xpath("//p[@class='catalog__name']/*"));
        for (SelenideElement e : elementsCollection) {
            String str = e.text();
            arr.add(str);
        }
        return arr;
    }

       public boolean isCollectionSortByName(){
        boolean isCorrect =  Ordering.usingToString().isOrdered(collectionSortByName());
           return isCorrect;
       }

}

