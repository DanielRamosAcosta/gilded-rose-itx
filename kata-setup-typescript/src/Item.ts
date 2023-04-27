export class Item {
  name: string
  sellIn: number
  quality: number

  public readonly MAX_QUALITY = 50

  constructor(name: string, sellIn: number, quality: number) {
    this.name = name
    this.sellIn = sellIn
    this.quality = quality
  }

  public hasLessThanMaxQuality() {
    return this.quality < this.MAX_QUALITY
  }

  public hasQuality() {
    return this.quality > 0
  }

  public increaseQuality() {
    this.quality++
  }

  public decreaseQuality() {
    this.quality--
  }

  public decreaseSellIn() {
    this.sellIn--
  }
}
