import { Item, ItemType } from "./Item.js"

export class Legendary extends Item {
  constructor(name: string, sellIn: number, quality: number) {
    super(name, sellIn, quality, ItemType.Legendary)
  }

  updateSellIn(): void {
    // Legendary items don't change
  }
  updateQuality(): void {
    // Legendary items don't change
  }
}
