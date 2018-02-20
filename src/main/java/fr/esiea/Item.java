package fr.esiea;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public boolean conjured;

    public Item(String name, int sellIn, int quality, boolean conjured) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.conjured = conjured;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality + ", isConjured = " + this.conjured;
    }
}
