import { Item } from "./Item.js"

export class GildedRose {
  products: Array<Item>

  constructor(products = [] as Array<Item>) {
    this.products = products
  }

  updateQuality() {
    for (let i = 0; i < this.products.length; i++) {
      if (!this.products[i].isAged() && !this.products[i].isBackstage()) {
        if (this.products[i].quality > 0) {
          if (!this.products[i].isLegendary()) {
            this.products[i].quality = this.products[i].quality - 1
          }
        }
      } else {
        if (this.products[i].quality < 50) {
          this.products[i].quality = this.products[i].quality + 1
          if (this.products[i].isBackstage()) {
            if (this.products[i].sellIn < 11) {
              if (this.products[i].quality < 50) {
                this.products[i].quality = this.products[i].quality + 1
              }
            }
            if (this.products[i].sellIn < 6) {
              if (this.products[i].quality < 50) {
                this.products[i].quality = this.products[i].quality + 1
              }
            }
          }
        }
      }
      if (!this.products[i].isLegendary()) {
        this.products[i].sellIn = this.products[i].sellIn - 1
      }
      if (this.products[i].sellIn < 0) {
        if (!this.products[i].isAged()) {
          if (!this.products[i].isBackstage()) {
            if (this.products[i].quality > 0) {
              if (!this.products[i].isLegendary()) {
                this.products[i].quality = this.products[i].quality - 1
              }
            }
          } else {
            this.products[i].quality = this.products[i].quality - this.products[i].quality
          }
        } else {
          if (this.products[i].quality < 50) {
            this.products[i].quality = this.products[i].quality + 1
          }
        }
      }
    }

    return this.products
  }
}
