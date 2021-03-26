package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class QualityCalculator {

    private final QualityCalculatorStrategy allItemQualityCalculatorStrategy = new AllItemQualityCalculator();

    public void updateQuality(Item item) {
        allItemQualityCalculatorStrategy.updateQuality(item);
    }
}
