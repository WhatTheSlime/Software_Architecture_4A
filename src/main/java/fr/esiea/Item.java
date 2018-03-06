package fr.esiea;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public boolean isConjured;

    public int price; 

    public Item(String name, int sellIn, int quality, boolean isConjured) {
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
      this.isConjured = isConjured;
    }
  
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality + ", isConjured = " + this.isConjured;
    }
}
