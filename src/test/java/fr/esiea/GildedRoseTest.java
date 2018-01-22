package fr.esiea;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void first_quality_test() {
        Item item = new Item("test", 2018, 10);
        Item[] items = {item};
        GildedRose gildedrose = new GildedRose(items);

        gildedrose.updateQuality();

        Assertions.assertThat(item.quality).as("quality after one day").isEqualTo(9);
    }
}
