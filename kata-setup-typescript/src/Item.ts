import { MAX_QUALITY } from "./constants/max-quality.js"

export interface Itemer {
  updateQuality(newSellIn: number): void
  updateSellIn(): void
}

export class Item implements Itemer {
  name: string
  sellIn: number
  quality: number

  constructor(name: string, sellIn: number, quality: number) {
    this.name = name
    this.sellIn = sellIn
    this.quality = quality
  }

  isMaxQuality(): boolean {
    return this.quality < MAX_QUALITY
  }

  updateQuality(newSellIn: number): void {
    if (this.sellIn < newSellIn) {
      if (this.quality === 0) {
        return
      }
      this.quality--
    }
  }

  updateSellIn(): void {
    this.decreaseSellIn()
  }

  decreaseSellIn(): void {
    this.sellIn--
  }
}
