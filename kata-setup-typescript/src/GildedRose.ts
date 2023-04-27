import { Item } from "./Item.js"

const BACKSTAGE_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10
const BACKSTAGE_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5
const QUALITY_DROP_TO_ZERO_SELL_IN_THRESHOLD = 0

export class GildedRose {
  products: Array<Item>

  constructor(products = [] as Array<Item>) {
    this.products = products
  }
  updateProductQuality(product: Item) {
    product.updateSellIn()
    product.updateQuality()
  }
  updateQuality() {
    this.products.forEach(this.updateProductQuality)
    return this.products
  }
}
