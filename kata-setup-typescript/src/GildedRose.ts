import { Item } from "./Item.js"

export class GildedRose {
  items: Array<Item>

  constructor(items = [] as Array<Item>) {
    this.items = items
  }

  updateQuality() {
    this.items.forEach((item) => {
      if (!this.isAgedBrie(item) && !this.isBackstage(item)) {
        if (item.hasQuality()) {
          if (!this.isSulfuras(item)) {
            item.decreaseQuality()
          }
        }
      } else {
        if (item.hasLessThanMaxQuality()) {
          item.increaseQuality()
          if (this.isBackstage(item)) {
            if (this.isLessThanTenDaysToBackstage(item)) {
              if (item.hasLessThanMaxQuality()) {
                item.increaseQuality()
              }
            }
            if (this.isLessThanFiveDaysToBackstage(item)) {
              if (item.hasLessThanMaxQuality()) {
                item.increaseQuality()
              }
            }
          }
        }
      }
      if (!this.isSulfuras(item)) {
        item.decreaseSellIn()
      }
      if (item.isItemOverdated()) {
        if (!this.isAgedBrie(item)) {
          if (!this.isBackstage(item)) {
            if (item.hasQuality()) {
              if (!this.isSulfuras(item)) {
                item.decreaseQuality()
              }
            }
          } else {
            item.resetQualityToZero()
          }
        } else {
          if (item.hasLessThanMaxQuality()) {
            item.increaseQuality()
          }
        }
      }
    })

    return this.items
  }

  private isLessThanFiveDaysToBackstage(item: Item) {
    return item.sellIn < 6
  }

  private isLessThanTenDaysToBackstage(item: Item) {
    return item.sellIn < 11
  }

  private isSulfuras(item: Item) {
    return item.name == "Sulfuras, Hand of Ragnaros"
  }

  private isBackstage(item: Item) {
    return item.name == "Backstage passes to a TAFKAL80ETC concert"
  }

  private isAgedBrie(item: Item) {
    return item.name == "Aged Brie"
  }
}
