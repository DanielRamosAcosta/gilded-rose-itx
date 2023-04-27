import { Item } from "./Item.js"
import { SULFURAS_NAME } from "./constants/items-names.js"
export class GildedRose {
  items: Array<Item>

  constructor(items = [] as Array<Item>) {
    this.items = items
  }

  updateItemSellIn = (item: Item) => {
    if (item.name != SULFURAS_NAME) {
      item.decreaseSellIn()
    }
  }

  updateQuality() {
    for (const item of this.items) {
      item.updateSellIn()
      item.updateQuality()
    }

    return this.items
  }
}
