import { Item, Itemer } from "./Item.js"

export class BackstagePasses extends Item implements Itemer {
  constructor(sellIn: number, quality: number) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)
  }

  updateQuality(): void {
    if (this.hasMaxQuality()) {
      return
    }
    if (this.sellIn > 10) {
      this.quality = this.quality + 1
      return
    }
    if (this.sellIn > 0 && this.sellIn < 6) {
      this.quality = this.quality + 3
      return
    }
    if (this.sellIn > 0 && this.sellIn < 11) {
      this.quality = this.quality + 2
      return
    }
    if (this.sellIn <= 0) {
      this.quality = 0
    }
  }

  updateSellIn(): void {
    this.sellIn--
  }
}
