import { Item, Itemer } from "./Item.js"

export class BackstagePasses extends Item implements Itemer {
  constructor(sellIn: number, quality: number) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)
  }

  updateQuality(newSellIn: number): void {
    if (this.isMaxQuality()) {
      return
    }
    if (newSellIn < 11) {
      this.quality = this.quality + 1
    }
    if (newSellIn < 6) {
      this.quality = this.quality + 1
    }
  }

  updateSellIn(): void {
    this.sellIn--
  }
}
