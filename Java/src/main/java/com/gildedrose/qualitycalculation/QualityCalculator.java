package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class QualityCalculator {

    private final QualityCalculatorStrategyFactory qualityCalculatorStrategyFactory = new QualityCalculatorStrategyFactory();

    public void updateQuality(Item item) {
        QualityCalculatorStrategy qualityCalculatorStrategy = qualityCalculatorStrategyFactory.getQualityCalculatorStrategy(item);

        qualityCalculatorStrategy.updateQuality(item);
    }
}
