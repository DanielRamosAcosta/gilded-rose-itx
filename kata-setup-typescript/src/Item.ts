export enum ItemType {
  Aged,
  Legendary,
  Backstage,
  Normal,
}

const HIGH_QUALITY_THRESHOLD = 50

export class Item {
  name: string
  sellIn: number
  quality: number
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

  increaseQuality(amount = 1): void {
    this.quality = this.quality + amount
  }

  decreaseQuality(amount = 1): void {
    this.quality = this.quality - amount
  }

  isQualityAboveZero(): boolean {
    return this.quality > 0
  }
  isQualityAboveThreshold(): boolean {
    return this.quality < HIGH_QUALITY_THRESHOLD
  }
}
