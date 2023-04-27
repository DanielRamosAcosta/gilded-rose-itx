import { Item, Itemer } from "./Item.js"

export class Sulfuras extends Item implements Itemer {
  constructor(sellIn: number, quality: number) {
    super("Sulfuras, Hand of Ragnaros", sellIn, quality)
  }

  updateQuality(): void {
    return
  }

  updateSellIn(): void {
    return
  }
}
