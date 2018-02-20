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
        Item item = new Item(itemName, 2018, itemQuality);
        Item[] items = {item};
        GildedRose gildedrose = new GildedRose(items);

        gildedrose.updateQuality();

        Assertions.assertThat(item.quality).as("quality after one day").isEqualTo(qualityExpected);
    }

    public static  Object[] parametersForQualityTest() {
        return new Object[] {
                new Object[]{"test", 10, 9},
                new Object[] {"Aged Brie", 10, 11}
        };
    }
}
