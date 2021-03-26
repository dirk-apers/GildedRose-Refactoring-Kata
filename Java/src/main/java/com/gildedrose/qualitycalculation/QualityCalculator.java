package com.gildedrose.qualitycalculation;

import com.gildedrose.Item;

public class QualityCalculator {

    private final QualityCalculatorStrategy agedBrieQualityCalculatorStrategy = new AgedBrieQualityCalculator();
    private final QualityCalculatorStrategy backstagePassesQualityCalculatorStrategy = new BackstagePassesQualityCalculator();
    private final QualityCalculatorStrategy conjuredItemsQualityCalculatorStrategy = new ConjuredItemsQualityCalculator();
    private final QualityCalculatorStrategy legendaryItemQualityCalculatorStrategy = new LegendaryItemQualityCalculator();
    private final QualityCalculatorStrategy normalItemQualityCalculatorStrategy = new NormalItemQualityCalculator();

    public void updateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                agedBrieQualityCalculatorStrategy.updateQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                backstagePassesQualityCalculatorStrategy.updateQuality(item);
                break;
            case "Conjured Mana Cake":
                conjuredItemsQualityCalculatorStrategy.updateQuality(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                legendaryItemQualityCalculatorStrategy.updateQuality(item);
                break;
            default:
                normalItemQualityCalculatorStrategy.updateQuality(item);
        }
    }
}
