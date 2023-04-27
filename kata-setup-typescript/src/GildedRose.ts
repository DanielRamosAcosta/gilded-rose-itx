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

  increaseBackstageQuality(product: Item) {
    if (product.isQualityAboveThreshold()) {
      product.increaseQuality()
        if (product.sellIn <= BACKSTAGE_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
          product.increaseQuality()
        }
        if (product.sellIn <= BACKSTAGE_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
          product.increaseQuality()
        }
    }
  }

  updateQuality() {
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].isNormal()) {
        if (this.products[i].isQualityAboveZero()) {
          this.products[i].decreaseQuality()
        }
      }
      if (this.products[i].isAged() ) {
        if (this.products[i].isQualityAboveThreshold()) {
          this.products[i].increaseQuality()
        }
      }
      if (this.products[i].isBackstage()) {
        this.increaseBackstageQuality(this.products[i])
      }
      if (!this.products[i].isLegendary()) {
        this.products[i].sellIn = this.products[i].sellIn - 1
      }
      if (this.products[i].sellIn < QUALITY_DROP_TO_ZERO_SELL_IN_THRESHOLD) {
        if (!this.products[i].isAged()) {
          if (!this.products[i].isBackstage()) {
            if (this.products[i].isQualityAboveZero()) {
              if (!this.products[i].isLegendary()) {
                this.products[i].decreaseQuality()
              }
            }
          }
          if (this.products[i].isBackstage()) {
            this.products[i].quality = 0
          }
        }
        if (this.products[i].isAged()) {
          if (this.products[i].isQualityAboveThreshold()) {
            this.products[i].increaseQuality()
          }
        }
      }
    }

    return this.products
  }
}
