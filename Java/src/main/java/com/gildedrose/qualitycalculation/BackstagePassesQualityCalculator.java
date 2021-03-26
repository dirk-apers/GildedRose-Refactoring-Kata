package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class BackstagePassesQualityCalculator extends QualityCalculatorStrategy {

    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            item.quality = MIN_QUALITY;
        }
    }
}
