package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class NormalItemQualityCalculator extends QualityCalculatorStrategy {

    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item);

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}
