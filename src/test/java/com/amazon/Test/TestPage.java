package com.amazon.Test;

import com.amazon.Pages.*;
import com.amazon.Utilities.BrowserUtils;
import com.amazon.Utilities.ConfigurationReader;
import com.amazon.Utilities.Driver;
import com.amazon.Utilities.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestPage extends TestBase {


    @Test
    public void virgosolTest() {
        LoginPage login = new LoginPage();
        MainPage main = new MainPage();
        ItemPage item = new ItemPage();
        ListPage list = new ListPage();
        SignOutPage signout = new SignOutPage();

        //1 - https://www.amazon.com.tr/ sitesi açılır.
        //2-  Ana sayfanın açıldığı kontrol edilir.
        //3-  Çerez tercihlerinden Çerezleri kabul et seçilir.

        Log4j.startLog("Virgosol Task");

        String expectedPage = "https://www.amazon.com.tr/";
        String actualPage = Driver.get().getCurrentUrl();
        Assert.assertTrue(expectedPage.equals(actualPage));

        Log4j.info("Giriş yapıldı ve sayfa kontrol edildi, çerezler kabul edildi");
        report.createTest("Ana Sayfa Giriş").pass("Giriş yapıldı ve sayfa kontrol edildi, çerezler kabul edildi");

        //4 - Siteye login olunur.
        //5 - Login işlemi kontrol edilir.

        home.loginButtonLink.click();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        login.login(username, password);

        /**
         * Giriş yapıldıktan sonra kullanıcı siteden alınan kullanıcı isimi, beklenen kullanıcı ismi ile kontrol edilir
         * Giriş yapılamdığı takdirde bu isimler eşleşmeyecektir.
         */

        BrowserUtils.waitFor(1);
        String expectedUsername = "Virgosol";
        String actualUsername = Driver.get().findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        Assert.assertTrue(expectedUsername.equals(actualUsername));

        Log4j.info("Siteye login olundu ve kontrol edildi.");
        report.createTest("Login").pass("Siteye login olundu ve kontrol edildi.");

        //6 - Hesabım bölümünden “Virgosol Liste” isimli yeni bir liste oluşturulur.

        BrowserUtils.hover(main.accountAndList);
        main.createList.click();
        BrowserUtils.waitFor(1);
        main.inputListInformation.click();
        main.enterNameOfList.clear();
        BrowserUtils.waitFor(2);
        main.enterNameOfList.sendKeys("Virgosol Liste");
        BrowserUtils.waitFor(1);
        main.clickListCreateButton.click();
        BrowserUtils.waitFor(3);

        Log4j.info("Virgosol Liste adında yeni bir liste oluşturuldu.");
        report.createTest("Liste Oluşturma").pass("Virgosol Liste adında yeni bir liste oluşturuldu.");

        //7 - Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.

        Select catagory = new Select(main.dropDownMenu);
        catagory.selectByValue("search-alias=computers");
        String expectedOption = "Bilgisayarlar";
        String actualOption = catagory.getFirstSelectedOption().getText();
        Assert.assertTrue(expectedOption.equals(actualOption));

        Log4j.info("Katagoriler kısmından Bilgisayarlar seçeneği seçildi ve seçildiği kontrol edildi.");
        report.createTest("Katagori Seçilmesi").pass("Katagoriler kısmından Bilgisayarlar seçeneği seçildi ve seçildiği kontrol edildi.");

        //8 - Arama alanına msi yazılır.
        //9 - Arama yapıldığı kontrol edilir.

        main.searchBox.sendKeys("msi");
        main.searchButtonClick.click();
        BrowserUtils.waitFor(2);

        String expectedItem = "\"msi\"";
        String actualItem = Driver.get().findElement(By.xpath("(//span[@class='a-color-state a-text-bold'])[1]")).getText();
        Assert.assertTrue(expectedItem.equals(actualItem));
        BrowserUtils.waitFor(1);

        Log4j.info("Arama kısmına msi yazıldı ve arama yapıldığı kontrol edildi.");
        report.createTest("Arama Kısmının Test Edilmesi").pass("Arama kısmına msi yazıldı ve arama yapıldığı kontrol edildi.");

        //10 - Arama sonuçları sayfasından 2. sayfa açılır.
        //11 - 2. Sayfanın açıldığı kontrol edilir.


        BrowserUtils.waitFor(1);
        main.secondPage.click();

        String expectedPageNumber = "2";
        String actualPageNumber = main.currentPage.getText();
        Assert.assertTrue(expectedPageNumber.equals(actualPageNumber));

        Log4j.info("Arama sonuçlarından 2'inci sayfa seçildi ve kontrol edildi.");
        report.createTest("2'inci Sayfanın Seçilmesi").pass("Arama sonuçlarından 2'inci sayfa seçildi ve kontrol edildi.");

        //12 - Sayfadaki 2'inci ürün oluşturulan "Virgosol Liste" listesine eklenir.

        BrowserUtils.waitFor(2);
        main.secondItem.click();
        BrowserUtils.waitFor(1);
        item.addToWishListButton.click();
        BrowserUtils.waitFor(1);
        item.addToVirgosolListOptions.click();
        BrowserUtils.waitFor(2);

        String actualResult = Driver.get().findElement(By.xpath("(//span[@class='a-size-medium-plus huc-atwl-header-main'])[1]")).getText();
        String actualResult2 = Driver.get().findElement(By.xpath("(//span[@class='a-size-medium-plus huc-atwl-header-main'])[2]")).getText();
        String finalActualResult = actualResult + " " + actualResult2;
        String expectedResult = "1 ürün şuraya eklendi: Virgosol Liste";
        Assert.assertTrue(expectedResult.equals(finalActualResult));
        BrowserUtils.waitFor(1);

        item.closePopUp.click();
        BrowserUtils.waitFor(1);

        Log4j.info("2'inci ürün Virgosol Liste'ye eklendi ve eklendiği kontrol edildi.");
        report.createTest("Listeye Ürün Ekleme").pass("2'inci ürün Virgosol Liste'ye eklendi ve eklendiği kontrol edildi.");

        //13 - Hesabım > Alışveriş Listesi sayfasına gidilir.
        //14 - Alışveriş Listesi sayfası açıldığı kontrol edilir.
        BrowserUtils.scrollToElement(home.loginButtonLink);
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(home.loginButtonLink);
        BrowserUtils.waitFor(1);
        item.virgosolListLink.click();
        BrowserUtils.waitFor(1);

        String expectedPageInfo = "Listelerim";
        String actualPageInfo = list.pageInfo.getText();
        Assert.assertTrue(expectedPageInfo.equals(actualPageInfo));

        Log4j.info("Virgosol Liste sayfası açıldı ve kontrol edildi.");
        report.createTest("Virgosol Liste'sinin Kontrol Edilmesi.").pass("Virgosol Liste sayfası açıldı ve kontrol edildi.");

        //15 - Eklenen ürün 'Virgosol Liste'sinden silinir.
        //16 - Silme işlemi kontrol edilir.

        list.deleteItem.click();
        String expectedWarningAlert = "Silindi";
        String actualWarningAlert = list.warningAlert.getText();
        Assert.assertTrue(expectedWarningAlert.equals(actualWarningAlert));

        Log4j.info("Eklenen ürün Virgosol Liste'den silindi ve silindiği kontrol edildi.");
        report.createTest("Listeden Ürün Silinmesi").pass("Eklenen ürün Virgosol Liste'den silindi ve silindiği kontrol edildi.");

        //17 - Oluşturulan Liste Silinir

        list.moreThanButton.click();
        BrowserUtils.waitFor(1);
        list.editYourList.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(list.deleteList);
        BrowserUtils.waitFor(1);
        list.yesButton.click();
        ;
        BrowserUtils.waitFor(1);

        Log4j.info("Oluşturulan liste silindi.");
        report.createTest("Listenin Silinmesi").pass("Oluşturulan liste silindi.");

        //18 - Çıkış işlemi yapılır
        //19 - Çıkış İşlemi Kontrol edilir

        BrowserUtils.hover(home.loginButtonLink);
        BrowserUtils.waitFor(1);
        list.signOutButton.click();
        BrowserUtils.waitFor(1);

        String actualInformation = signout.signOutInformation.getText();
        String expectedInformation = "Giriş yap";
        Assert.assertTrue(expectedInformation.equals(actualInformation));


        Log4j.info("Çıkış işlemi başarı ile yapıldı ve kontrol edildi.");
        report.createTest("Çıkış İşlemi Yapılması").pass("Çıkış işlemi başarı ile yapıldı ve kontrol edildi.");
        Log4j.endLog("Virgosol Task");

    }
}


