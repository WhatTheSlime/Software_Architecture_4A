package fr.esiea;


import org.junit.Test;

import org.assertj.core.api.Assertions;

public class ItemTest {

    @Test
    public void itemTest1(){
        Item item = new Item("TestName", 0, 0, true);
        Assertions.assertThat(item.isConjured).as("Item is conjured").isEqualTo(true);
    }

    @Test
    public void toStringTest(){
        Item item = new Item("TestName", 0, 0, false);

        Assertions.assertThat(item.toString()).as("Item toString methode").isEqualTo(item.name + ", " + item.sellIn + ", " + item.quality + ", isConjured = " + item.isConjured);
    }

}