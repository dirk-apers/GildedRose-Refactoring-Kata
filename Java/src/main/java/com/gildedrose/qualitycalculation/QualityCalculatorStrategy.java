package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public abstract class QualityCalculatorStrategy {

    static final int MAX_QUALITY = 50;
    static final int MIN_QUALITY = 0;

    public abstract void updateQuality(Item item);

    void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    void decreaseSellIn(Item item) {
        item.sellIn--;
    }

}
