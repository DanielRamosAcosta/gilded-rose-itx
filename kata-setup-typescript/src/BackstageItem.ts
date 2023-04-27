import { Item, ItemType } from "./Item.js"

export class Backstage extends Item {
  constructor(name: string, sellIn: number, quality: number) {
    super(name, sellIn, quality, ItemType.Backstage)
  }

  updateQuality(): void {
    // Legendary items don't change
    if (this.sellIn < 0) {
      this.resetQuality()
    } else if (this.sellIn <= 5) {
      this.increaseQuality(3)
    } else if (this.sellIn <= 10) {
      this.increaseQuality(2)
    } else {
      this.increaseQuality(1)
    }
  }
}
