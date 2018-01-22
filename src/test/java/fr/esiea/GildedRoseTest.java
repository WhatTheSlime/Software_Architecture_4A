package fr.esiea;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseTest {

    @Test
    @Parameters
    public void first_quality_test() {
        Item item = new Item("test", 2018, 10);
        Item[] items = {item};
        GildedRose gildedrose = new GildedRose(items);

        gildedrose.updateQuality();

        Assertions.assertThat(item.quality).as("quality after one day").isEqualTo(9);
    }
}
