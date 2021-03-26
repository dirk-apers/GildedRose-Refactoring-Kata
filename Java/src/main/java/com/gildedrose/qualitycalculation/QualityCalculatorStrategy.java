package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public abstract class QualityCalculatorStrategy {

    static final int MAX_QUALITY = 50;
    static final int MIN_QUALITY = 0;

    abstract void updateQuality(Item item);

    public void increaseQuality(Item item, int amount) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + amount;
        }
    }

    public void decreaseQuality(Item item, int amount) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - amount;
        }
    }

    public void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

}
