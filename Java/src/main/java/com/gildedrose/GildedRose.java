package com.gildedrose;

import com.gildedrose.qualitycalculation.QualityCalculator;

class GildedRose {
    Item[] items;

    QualityCalculator qualityCalculator = new QualityCalculator();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            qualityCalculator.updateQuality(items[i]);
        }
    }
}