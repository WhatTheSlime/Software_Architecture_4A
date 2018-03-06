package fr.esiea;

class GildedRose {
    Item[] items;

    //Constructeur
    public GildedRose(Item[] items) {
        this.items = items;
    }

    //Fonction met a jour la qualité d'un item en fonction de son type.
    public void updateQuality(){
        for (Item item : items) {
            if(item.name.equals("Sulfuras, Hand of Ragnaros")) {item.quality = 80;}
            else {item.sellIn -= 1;
                if(item.name.equals("Aged Brie")) {updateAgedBrie(item);}
                else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {updateBackstage(item);}
                else {updateQuality(item);}
                if (item.quality > 50) {item.quality = 50;}
                if (item.quality < 0) {item.quality = 0;}
            }
        }
    }

    //Fonction augmentant la qualité d'un objet de type Aged Brie.
    //Si la date de vente de l'objet est inférieur à 0, la qualité augmente de 2
    private void updateAgedBrie(Item item){
        item.quality += 1;
        if (item.sellIn < 0) {item.quality += 1;}
    }

    //Fonction personnalisé pour l'item de type Backstage passe concert.
    //Si la date de vente est inférieur ou égale à 10, la qualité augmente de 2.
    //Si la date de vente est inférieur ou égale à 5, la qualité augmente de 3.
    //Si la date de vente est inférieur ou égale à 0, la qualité passe à 0.
    private void updateBackstage(Item item){
        item.quality += 1;
        if (item.sellIn <= 10) {item.quality += 1;}
        if (item.sellIn <= 5) {item.quality += 1;}
        if (item.sellIn <= 0) {item.quality = 0;}
    }

    //Fonction servant à actualiser la qualité d'un objet consomable.
    //Par default La qualité baisse de 1  chaque jour.
    //Si l'objet est conjured il baisse de 2 de qualité chaque jour.
    //Si l'objet et conjured et la date de vente est dépassé, l'objet perd de 3 de qualité chaque jour.
    private void updateQuality(Item item){
        item.quality -= 1;
        if (item.isConjured) {item.quality -= 1;}
        if(item.sellIn < 0){
            item.quality -= 1;
            if(item.isConjured){item.quality -= 2;}
        }
    }

}
