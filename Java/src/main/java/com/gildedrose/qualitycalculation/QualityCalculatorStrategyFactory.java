package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class QualityCalculatorStrategyFactory {

    private final QualityCalculatorStrategy agedBrieQualityCalculatorStrategy = new AgedBrieQualityCalculator();
    private final QualityCalculatorStrategy backstagePassesQualityCalculatorStrategy = new BackstagePassesQualityCalculator();
    private final QualityCalculatorStrategy conjuredItemsQualityCalculatorStrategy = new ConjuredItemsQualityCalculator();
    private final QualityCalculatorStrategy legendaryItemQualityCalculatorStrategy = new LegendaryItemQualityCalculator();
    private final QualityCalculatorStrategy normalItemQualityCalculatorStrategy = new NormalItemQualityCalculator();

    public QualityCalculatorStrategy getQualityCalculatorStrategy(Item item) {
        switch (item.name) {
            case "Aged Brie": return agedBrieQualityCalculatorStrategy;
            case "Backstage passes to a TAFKAL80ETC concert": return backstagePassesQualityCalculatorStrategy;
            case "Conjured Mana Cake": return conjuredItemsQualityCalculatorStrategy;
            case "Sulfuras, Hand of Ragnaros": return legendaryItemQualityCalculatorStrategy;
            default: return normalItemQualityCalculatorStrategy;
        }
    }
}
