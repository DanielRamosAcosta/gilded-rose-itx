package org.example;

import static org.example.mothers.ItemMother.createAgedBrie;
import static org.example.mothers.ItemMother.createBackstagePasses;
import static org.example.mothers.ItemMother.createSulfuras;
import static org.example.mothers.ItemMother.createWine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GildedRoseTest {

  private static Stream<Arguments> updateQualityTestData() {
    return Stream.of(
        Arguments.of(createWine(5, 10), 4, 9),
        Arguments.of(createWine(-1, 10), -2, 8),
        Arguments.of(createWine(-1, 0), -2, 0),

        Arguments.of(createAgedBrie(5, 10), 4, 11),
        Arguments.of(createAgedBrie(-1, 10), -2, 12),
        Arguments.of(createAgedBrie(-1, 50), -2, 50),

        Arguments.of(createSulfuras(5), 5, 80),
        Arguments.of(createSulfuras(-1), -1, 80),

        Arguments.of(createBackstagePasses(30, 10), 29, 11),
        Arguments.of(createBackstagePasses(10, 10), 9, 12),
        Arguments.of(createBackstagePasses(9, 10), 8, 12),
        Arguments.of(createBackstagePasses(5, 10), 4, 13),
        Arguments.of(createBackstagePasses(1, 10), 0, 13),
        Arguments.of(createBackstagePasses(0, 10), -1, 0)
    );
  }

  @ParameterizedTest
  @MethodSource("updateQualityTestData")
  void shouldDecreaseQualityAndSellIn(Item item, int expectedSellIn, int expectedQuality) {
    GildedRose app = new GildedRose(new Item[]{item});

    app.updateQuality();

    assertTrue(item.hasQualityValue(expectedQuality));
    assertEquals(expectedSellIn, item.sellIn);
  }

}
