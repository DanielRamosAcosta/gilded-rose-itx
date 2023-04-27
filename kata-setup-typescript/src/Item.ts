export enum ItemType {
  Aged,
  Legendary,
  Backstage,
  Normal,
}

const HIGH_QUALITY_THRESHOLD = 50

export class Item {
  public name: string
  sellIn: number
  public quality: number
  type: ItemType

  constructor(name: string, sellIn: number, quality: number, type: ItemType) {
    this.name = name
    this.sellIn = sellIn
    this.quality = quality
    this.type = type
  }

  isType(type: ItemType): boolean {
    return this.type === type
  }

  isAged(): boolean {
    return this.isType(ItemType.Aged)
  }

  isLegendary(): boolean {
    return this.isType(ItemType.Legendary)
  }

  isBackstage(): boolean {
    return this.isType(ItemType.Backstage)
  }

  isNormal(): boolean {
    return this.isType(ItemType.Normal)
  }

  isQualityAboveZero(): boolean {
    return this.quality > 0
  }
  isQualityAboveThreshold(): boolean {
    return this.quality < HIGH_QUALITY_THRESHOLD
  }
  increaseQuality(amount: number): void {
    this.quality = Math.min(HIGH_QUALITY_THRESHOLD, this.quality + amount)
  }

  decreaseQuality(amount: number): void {
    this.quality = Math.max(0, this.quality - amount)
  }

  resetQuality(): void {
    this.quality = 0
  }

  updateQuality(): void {
    if (this.sellIn < 0) {
      this.decreaseQuality(2)
    } else {
      this.decreaseQuality(1)
    }
  }
  updateSellIn(): void {
    this.sellIn = this.sellIn - 1
  }
}
