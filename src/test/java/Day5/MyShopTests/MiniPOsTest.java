package Day5.MyShopTests;

import Day4.TestBase;
import Day5.MyStore.ArtPO;
import Day5.MyStore.ChartPO;
import Day5.MyStore.HomepagePO;
import Day5.MyStore.QuickViewPO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MiniPOsTest extends TestBase {
    @Test
    public void allPricesCanBeGetFromPOsTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        homepagePO.printAllPrices();
    }


    //kliknij w ktorys MiniaturePO-quickview na stronie glownej (sprawdz czy nazwa na stronie glownej
    // jest taka sama jak nazwa w quickView layer
    // * kliknij w randomowy element - za kazdym uruchomieniem testu w inny :)

    @Test
    public void nameInQuickViewShouldBeTheSameAsOnTheMiniatureTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        int n = getRandomNumber(homepagePO.miniaturesNumber() - 1);
        String name1 = homepagePO.getNameOfNthMiniature(n);
        homepagePO.openQuickViewOfNthMiniature(n);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        Assert.assertEquals(name1, quickViewPO.getTitle());

    }

    @Test
    public void itemsInTheCartShouldHaveCorrectSummaryPriceTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        int n = getRandomNumber(homepagePO.miniaturesNumber() - 1);
        homepagePO.openQuickViewOfNthMiniature(n);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        int randQuantity = getRandomNumber(10);
        double expectedPrice = quickViewPO.getSinglePrice() * randQuantity;
        quickViewPO.setQuantity(randQuantity);
        quickViewPO.clickChartButton();

        ChartPO chartPO = new ChartPO(driver);
        Assert.assertEquals(expectedPrice, chartPO.getTotalPrice());

    }

    @Test
    public void shouldCorrectlyAddMultipleItemsToChartTest() {
        int elementSum = 0;
        double expectedPrice = 0;
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        for (int i = 0; i < 3; i++) {
            int n = getRandomNumber(homepagePO.miniaturesNumber() - 1);
            homepagePO.openQuickViewOfNthMiniature(n);

            int randQuantity = getRandomNumber(10);
            elementSum += randQuantity;
            expectedPrice += quickViewPO.getSinglePrice() * randQuantity;
            quickViewPO.setQuantity(randQuantity);
            quickViewPO.clickChartButton();
            if (i < 2) quickViewPO.clickContinueButton();
            else quickViewPO.clickProceedButton();
            veryBadSleep();
        }

        ChartPO chartPO = new ChartPO(driver);

        Assert.assertEquals(expectedPrice, chartPO.getTotalPrice());
        Assert.assertEquals(elementSum, chartPO.getAllElements());
    }

    @Test
    public void clickThirdElementFromArtTab(){
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        homepagePO.openArtTable();
        ArtPO artPO = new ArtPO(driver);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        artPO
                .clickPriceFilter()
                .selectSortType();
        veryBadSleep();
        homepagePO.openQuickViewOfNthMiniature(2);
     //   veryBadSleep();
        Assert.assertEquals(quickViewPO.getTitle(),"BROWN BEAR GRAPHICS");
    }


}