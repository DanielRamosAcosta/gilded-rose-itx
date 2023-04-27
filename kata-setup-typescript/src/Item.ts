export enum ItemType {
  Aged,
  Legendary,
  Backstage,
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
}
