import { Item } from "./Item.js"

const BACKSTAGE_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10
const BACKSTAGE_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5
const QUALITY_DROP_TO_ZERO_SELL_IN_THRESHOLD = 0

const HIGH_QUALITY_THRESHOLD = 50
const LOW_QUALITY_THRESHOLD = 0

export class GildedRose {
  products: Array<Item>

  constructor(products = [] as Array<Item>) {
    this.products = products
  }

  updateQuality() {
    for (let i = 0; i < this.products.length; i++) {
      if (!this.products[i].isAged() && !this.products[i].isBackstage()) {
        if (this.products[i].quality > LOW_QUALITY_THRESHOLD) {
          if (!this.products[i].isLegendary()) {
            this.products[i].quality = this.products[i].quality - 1
          }
        }
      } else {
        if (this.products[i].quality < HIGH_QUALITY_THRESHOLD) {
          this.products[i].quality = this.products[i].quality + 1
          if (this.products[i].isBackstage()) {
            if (this.products[i].sellIn <= BACKSTAGE_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
              if (this.products[i].quality < HIGH_QUALITY_THRESHOLD) {
                this.products[i].quality = this.products[i].quality + 1
              }
            }
            if (this.products[i].sellIn <= BACKSTAGE_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
              if (this.products[i].quality < HIGH_QUALITY_THRESHOLD) {
                this.products[i].quality = this.products[i].quality + 1
              }
            }
          }
        }
      }
      if (!this.products[i].isLegendary()) {
        this.products[i].sellIn = this.products[i].sellIn - 1
      }
      if (this.products[i].sellIn < QUALITY_DROP_TO_ZERO_SELL_IN_THRESHOLD) {
        if (!this.products[i].isAged()) {
          if (!this.products[i].isBackstage()) {
            if (this.products[i].quality > LOW_QUALITY_THRESHOLD) {
              if (!this.products[i].isLegendary()) {
                this.products[i].quality = this.products[i].quality - 1
              }
            }
          } else {
            this.products[i].quality = this.products[i].quality - this.products[i].quality
          }
        } else {
          if (this.products[i].quality < HIGH_QUALITY_THRESHOLD) {
            this.products[i].quality = this.products[i].quality + 1
          }
        }
      }
    }

    return this.products
  }
}
