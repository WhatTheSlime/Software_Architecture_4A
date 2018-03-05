package fr.esiea;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality(){
        for (int i = 0; i < items.length; ++i) {
            if(items[i].name.equals("Sulfuras, Hand of Ragnaros")) {items[i].quality = 80;}
            else {items[i].sellIn -= 1;
                if(items[i].name.equals("Aged Brie")) {updateAged(items[i]);}
                else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {updateBackstage(items[i]);}
                else {updateQuality(items[i]);}
                if (items[i].quality > 50) {items[i].quality = 50;}
                if (items[i].quality < 0) {items[i].quality = 0;}
            }
        }
    }

    private void updateAged(Item item){
        item.quality += 1;
        if (item.sellIn < 0) {item.quality += 1;}
    }

    private void updateBackstage(Item item){
        item.quality += 1;
        if (item.sellIn <= 10) {item.quality += 1;}
        if (item.sellIn <= 5) {item.quality += 1;}
        if (item.sellIn <= 0) {item.quality = 0;}
    }

    private void updateQuality(Item item){
        item.quality -= 1;
        if (item.isConjured) {item.quality -= 1;}
        if(item.sellIn < 0){
            item.quality -= 1;
            if(item.isConjured){item.quality -= 2;}
        }
    }

}