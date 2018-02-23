package fr.esiea;

import junitparams.Parameters;
import org.junit.Test;

import org.assertj.core.api.Assertions;

import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Test
    @Parameters
    public void qualityTest(String itemName, int itemQuality, int qualityExpected) {
        Item item = new Item(itemName, 2018, itemQuality, false);
        Item[] items = {item};
        GildedRose gildedrose = new GildedRose(items);

        gildedrose.updateQuality();

        Assertions.assertThat(item.quality).as("quality after one day").isEqualTo(qualityExpected);
    }

    @Test
    @Parameters
    public void sellInTest(String itemName, int itemSellIn, int sellinExpected){
        Item item = new Item(itemName, itemSellIn, 10, false);
        Item[] items = {item};

        GildedRose gildedrose = new GildedRose(items);
        gildedrose.updateQuality();

        Assertions.assertThat(item.sellIn).as("sellIn after one day").isEqualTo(sellinExpected);
    }

    @Test
    @Parameters
    public void conjuredItemQualityTest(String itemName, int itemSellIn, int qualityExpected) {
        Item item = new Item(itemName, itemSellIn, 2, true);
        Item[] items = {item};
        GildedRose gildedrose = new GildedRose(items);

        gildedrose.updateQuality();

        Assertions.assertThat(item.quality).as("Conjured item quality decreased by 2").isEqualTo(qualityExpected);
    }

    @Test
    @Parameters
    public void qualityAccordingToSellinTest(String itemName, int itemSellIn, int itemQuality,  int qualityExpected){
        Item item = new Item(itemName, itemSellIn, itemQuality, false);
        Item[] items = {item};

        GildedRose gildedrose = new GildedRose(items);
        gildedrose.updateQuality();

        Assertions.assertThat(item.quality).as("quality after one day").isEqualTo(qualityExpected);
    }


    public static  Object[] parametersForQualityTest() {
        return new Object[] {
                /* First Test */
                new Object[]{"test", 10, 9},
                /* The Quality of an item is never negative */
                new Object[]{"NoNegativeQuality", 0, 0},
                /* "Aged Brie" actually increases in Quality the older it gets */
                new Object[] {"Aged Brie", 10, 11},
                /* The Quality of an item is never more than 50 */
                new Object[] {"Aged Brie", 50, 50},
                /* "Sulfuras", being a legendary item, never has to decreases in Quality */
                new Object[] {"Sulfuras, Hand of Ragnaros", 10, 10},

        };
    }

    public static  Object[] parametersForSellInTest() {
        return new Object[] {
                /* "Sulfuras", being a legendary item, never has to be sold */
                new Object[] {"Sulfuras, Hand of Ragnaros", 10, 10},
        };
    }

    public static  Object[] parametersForConjuredItemQualityTest() {
        return new Object[] {
                new Object[] {"Conjured Test", 2, 0},
                new Object[] {"Conjured Test", -1, 0},
        };
    }

    public static  Object[] parametersForQualityAccordingToSellinTest() {
        return new Object[] {
                /* Once the sell by date has passed, Quality degrades twice as fast */
                new Object[] {"RandomItem", 0, 10, 8},
                /* "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; */
                    /* Quality increases by 2 when there are 10 days or less */
                new Object[] {"Backstage passes to a TAFKAL80ETC concert", 9, 10, 12},
                    /* Quality increases by 3 when there are 5 days or less */
                new Object[] {"Backstage passes to a TAFKAL80ETC concert", 5, 10, 13},
                    /* Quality drops to 0 after the concert */
                new Object[] {"Backstage passes to a TAFKAL80ETC concert", -1, 10, 0},

                new Object[] {"Aged Brie", -1, 10, 12},
        };
    }


}
