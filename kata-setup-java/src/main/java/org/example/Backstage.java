package org.example;

public class Backstage extends Item {

  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  public Backstage(int sellIn, int quality) {
    super(BACKSTAGE_PASS, sellIn, quality);
  }

  @Override
  void update() {
    decreaseSellIn();
    if (!hasMaxQuality()) {
      increaseQuality();
      if (this.sellIn < 10) {
        increaseQuality();
      }

      if (this.sellIn < 5) {
        increaseQuality();
      }
    }

    if (this.hasExpired()) {
      this.quality = 0;
    }
  }

}
