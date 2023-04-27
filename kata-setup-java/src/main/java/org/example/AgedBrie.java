package org.example;

public class AgedBrie extends Item {

  public static final String AGED_BRIE = "Aged Brie";

  public AgedBrie(int sellIn, int quality) {
    super(AGED_BRIE, sellIn, quality);
  }

  @Override
  void update() {
    decreaseSellIn();
    increaseQuality();
    if (hasExpired()) {
      increaseQuality();
    }
  }

  @Override
  void decreaseSellIn() {
    super.decreaseSellIn();
  }

  @Override
  void decreaseQuality() {
    super.decreaseQuality();
  }

  @Override
  void increaseQuality() {
    super.increaseQuality();
  }
}
