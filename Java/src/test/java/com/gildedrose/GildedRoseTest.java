package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final int INITIAL_SELLIN = 20;
    private final int MIN_SELLIN = -20;

    private final int MAX_QUALITY = 100;
    private final int MIN_QUALITY = 0;

    @Test
    void normalItem() {
        int sellIn = INITIAL_SELLIN;
        String itemName = "Elixir of the Mongoose";

        for (int q = MAX_QUALITY; q >= MIN_QUALITY; q--) {
            int quality = q;
            Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
            GildedRose app = new GildedRose(items);

            // Every day, decrease sellIn by 1, decrease quality by 1
            for (int s = sellIn - 1; s >= 0; s--) {
                app.updateQuality();
                quality = Math.max(quality - 1, 0);
                assertItem(app.items[0], itemName, s, quality, q);
            }

            // After sellIn date passed
            // Every day, decrease sellIn by 1, decrease quality by 1 (minimum quality 0)
            for (int s = -1; s >= MIN_SELLIN; s--) {
                app.updateQuality();
                quality = Math.max(quality - 2, 0);
                assertItem(app.items[0], itemName, s, quality, q);
            }
        }
    }

    @Test
    void legendaryItem() {
        int sellIn = INITIAL_SELLIN;
        String itemName = "Sulfuras, Hand of Ragnaros";

        for (int q = MAX_QUALITY; q >= MIN_QUALITY; q--) {
            int quality = q;
            Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
            GildedRose app = new GildedRose(items);

            // Every day, sellIn doesn't change, quality doesn't change
            for (int s = sellIn - 1; s >= MIN_SELLIN; s--) {
                app.updateQuality();
                assertItem(app.items[0], itemName, sellIn, quality, q);
            }
        }
    }

    @Test
    void conjuredItem() {
        int sellIn = INITIAL_SELLIN;
        String itemName = "Conjured Mana Cake";

        for (int q = MAX_QUALITY; q >= MIN_QUALITY; q--) {
            int quality = q;
            Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
            GildedRose app = new GildedRose(items);

            // Every day, decrease sellIn by 1, decrease quality by 2
            for (int s = sellIn - 1; s >= 0; s--) {
                app.updateQuality();
                quality = Math.max(quality - 2, 0);
                assertItem(app.items[0], itemName, s, quality, q);
            }

            // After sellIn date passed
            // Every day, decrease sellIn by 1, decrease quality by 4 (minimum quality 0)
            for (int s = -1; s >= MIN_SELLIN; s--) {
                app.updateQuality();
                quality = Math.max(quality - 4, 0);
                assertItem(app.items[0], itemName, s, quality, q);
            }
        }
    }

    @Test
    void agedBrieItem() {
        int sellIn = INITIAL_SELLIN;
        String itemName = "Aged Brie";

        for (int q = MAX_QUALITY; q >= MIN_QUALITY; q--) {
            int quality = q;
            Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
            GildedRose app = new GildedRose(items);

            // Every day, decrease sellIn by 1, increase quality by 1 (maximum quality 50, unless initial quality is higher)
            for (int s = sellIn - 1; s >= 0; s--) {
                app.updateQuality();
                quality = Math.max(Math.min(quality + 1, 50), q);
                assertItem(app.items[0], itemName, s, quality, q);
            }

            // After sellIn date passed
            // Every day, decrease sellIn by 1, increase quality by 2 (maximum quality 50, unless initial quality is higher)
            for (int s = -1; s >= MIN_SELLIN; s--) {
                app.updateQuality();
                quality = Math.max(Math.min(quality + 2, 50), q);
                assertItem(app.items[0], itemName, s, quality, q);
            }
        }
    }

    @Test
    void backstagePassItem() {
        int sellIn = INITIAL_SELLIN;
        String itemName = "Backstage passes to a TAFKAL80ETC concert";

        for (int q = MAX_QUALITY; q >= MIN_QUALITY; q--) {
            int quality = q;
            Item[] items = new Item[]{new Item(itemName, sellIn, quality)};
            GildedRose app = new GildedRose(items);

            // Every day, decrease sellIn by 1, increase quality by 1 (maximum quality 50, unless initial quality is higher)
            for (int s = sellIn - 1; s >= 10; s--) {
                app.updateQuality();
                quality = Math.max(Math.min(quality + 1, 50), q);
                assertItem(app.items[0], itemName, s, quality, q);
            }

            // Between 10 and 5 days before SellIn date
            // Every day, decrease sellIn by 1, increase quality by 2 (maximum quality 50, unless initial quality is higher)
            for (int s = 9; s >= 5; s--) {
                app.updateQuality();
                quality = Math.max(Math.min(quality + 2, 50), q);
                assertItem(app.items[0], itemName, s, quality, q);
            }

            // Less than 5 days before SellIn date
            // Every day, decrease sellIn by 1, increase quality by 3 (maximum quality 50, unless initial quality is higher)
            for (int s = 4; s >= 0; s--) {
                app.updateQuality();
                quality = Math.max(Math.min(quality + 3, 50), q);
                assertItem(app.items[0], itemName, s, quality, q);
            }

            // After sellIn date passed
            // Every day, decrease sellIn by 1, quality = 0
            for (int s = -1; s >= MIN_SELLIN; s--) {
                app.updateQuality();
                quality = 0;
                assertItem(app.items[0], itemName, s, quality, q);
            }
        }
    }

    private void assertItem(Item item, String expectedItemName, int expectedSellIn, int expectedQuality, int initialQuality) {
        assertEquals(expectedItemName, item.name, String.format("Item name wrong for item: %s and initial quality %s", item, initialQuality));
        assertEquals(expectedSellIn, item.sellIn, String.format("SellIn wrong for item: %s and initial quality %s", item, initialQuality));
        assertEquals(expectedQuality, item.quality, String.format("Quality wrong for item: %s and initial quality %s", item, initialQuality));
    }

}
