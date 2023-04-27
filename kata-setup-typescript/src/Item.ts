export enum ItemType {
  Aged,
  Legendary,
  Backstage,
  Normal,
}

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

  increaseQuality(amount = 1) : void {
    this.quality = this.quality + amount;
  }

  decreaseQuality(amount = 1) : void {
    this.quality = this.quality - amount;
  }

}
