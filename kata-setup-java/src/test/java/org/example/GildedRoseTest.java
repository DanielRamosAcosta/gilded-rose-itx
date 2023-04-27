package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GildedRoseTest {

  private static Stream<Arguments> updateQualityTestData() {
    return Stream.of(
        Arguments.of("Wine", 5, 10, 4, 9),
        Arguments.of("Wine", -1, 10, -2, 8),
        Arguments.of("Wine", -1, 0, -2, 0),

        Arguments.of("Aged Brie", 5, 10, 4, 11),
        Arguments.of("Aged Brie", -1, 10, -2, 12),
        Arguments.of("Aged Brie", -1, 50, -2, 50),

        Arguments.of("Sulfuras, Hand of Ragnaros", 5, 80, 5, 80),
        Arguments.of("Sulfuras, Hand of Ragnaros", -1, 80, -1, 80),

        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 30, 10, 29, 11),
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 10,  9, 12),
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 9 , 10,  8, 12),
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 5 , 10,  4, 13),
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 1 , 10,  0, 13),
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 0 , 10, -1,  0)
    );
  }

  @ParameterizedTest
  @MethodSource("updateQualityTestData")
  void shouldDecreaseQualityAndSellIn(String itemName, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
    Item wine = new Item(itemName, sellIn, quality);

    GildedRose app = new GildedRose(new Item[]{wine});
    app.updateQuality();

    assertEquals(expectedQuality, wine.quality);
    assertEquals(expectedSellIn, wine.sellIn);
  }

}
