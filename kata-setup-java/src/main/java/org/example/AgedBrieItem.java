package org.example;

public class AgedBrieItem extends Item{

  public AgedBrieItem(int sellIn, int quality) {
    super("Aged Brie", sellIn, quality);
  }

  @Override
  protected void ensureQualityNotExcededMaxLimit() {
    if (sellIn == 0 && quality > 50){
      quality = quality - 2;
    }
    if (sellIn > 0 && quality > 50){
      quality = quality - 1;
    }
  }

  @Override
  public void updateQuality() {
    if (sellIn == 0) {
      quality = quality + 2;

    } else {
      quality = quality + 1;
    }
    ensureQualityNotExcededMaxLimit();
  }
}
