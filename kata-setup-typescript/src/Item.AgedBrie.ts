import { Item, Itemeble } from "./Item.js"

export class AgedBrie extends Item implements Itemeble {
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
