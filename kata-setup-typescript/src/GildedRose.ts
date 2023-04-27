import { Item } from "./Item.js"
export class GildedRose {
  items: Array<Item>

  constructor(items = [] as Array<Item>) {
    this.items = items
  }

  updateItems() {
    for (const item of this.items) {
      item.updateSellIn()
      item.updateQuality()
    }

    return this.items
  }
}
