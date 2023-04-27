export class Item {
  name: string
  sellIn: number
  quality: number

  constructor(name: string, sellIn: number, quality: number) {
    this.name = name
    this.sellIn = sellIn
    this.quality = quality
  }

  public increaseQuality() {
    this.quality++
  }

  public decreaseQuality() {
    this.quality--
  }

  public increaseSellIn() {
    this.sellIn++
  }

  public decreaseSellIn() {
    this.sellIn--
  }
}
