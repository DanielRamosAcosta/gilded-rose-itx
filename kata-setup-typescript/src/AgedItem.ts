import { Item, ItemType } from "./Item.js"

export class Aged extends Item {
  constructor(name: string, sellIn: number, quality: number) {
    super(name, sellIn, quality, ItemType.Aged)
  }

  updateQuality(): void {
    if (this.sellIn < 0) {
      this.increaseQuality(2)
    } else {
      this.increaseQuality(1)
    }
  }
}
