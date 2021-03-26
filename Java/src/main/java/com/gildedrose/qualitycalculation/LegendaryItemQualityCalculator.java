package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class LegendaryItemQualityCalculator implements QualityCalculatorStrategy {

    @Override
    public void updateQuality(Item item) {
        // Quality doesn't change over time
    }
}
