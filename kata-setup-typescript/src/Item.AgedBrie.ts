import { Item, Itemer } from "./Item.js"

export class AgedBrie extends Item implements Itemer {
  constructor(sellIn: number, quality: number) {
    super("Aged Brie", sellIn, quality)
  }

  updateQuality(): void {
    if (this.hasMaxQuality()) {
      return
    }

    if (this.sellIn < 0) {
      this.quality += 2
    } else {
      this.quality++
    }
  }

  updateSellIn(): void {
    this.decreaseSellIn()
  }
}
