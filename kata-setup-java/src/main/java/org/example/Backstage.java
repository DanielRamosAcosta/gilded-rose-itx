package org.example;

public class Backstage extends Item {

  public Backstage(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  void update() {
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

  @Override
  void decreaseSellIn() {
  }

  @Override
  void decreaseQuality() {
  }

  @Override
  void increaseQuality() {
  }
}
