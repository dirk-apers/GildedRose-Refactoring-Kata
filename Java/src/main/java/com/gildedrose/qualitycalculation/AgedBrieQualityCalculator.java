package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class AgedBrieQualityCalculator extends QualityCalculatorStrategy {

    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
