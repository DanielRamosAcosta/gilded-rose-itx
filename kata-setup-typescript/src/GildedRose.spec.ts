import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"

const DEFAULT_ITEM_NAME = "item-name"
const DEFAULT_ITEM_QUALITY = 5
const DEFAULT_ITEM_SELLIN = 5

const createGildedRoseBuilder = ({ name, quality, sellIn }: { name?: string; quality?: number; sellIn?: number }) => {
  return new Item(name ?? DEFAULT_ITEM_NAME, sellIn ?? DEFAULT_ITEM_SELLIN, quality ?? DEFAULT_ITEM_QUALITY)
}

describe("Basic items", () => {
  it("should decrease in 1 unit quality and sellIn", () => {
    const gildedRose = new GildedRose([createGildedRoseBuilder({})])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(DEFAULT_ITEM_QUALITY - 1)
    expect(updatedGildedRose[0].sellIn).toBe(DEFAULT_ITEM_SELLIN - 1)
  })

  it("should decrease quality faster if sellIn equals to 0", () => {
    const gildedRose = new GildedRose([createGildedRoseBuilder({ sellIn: 1 })])

    gildedRose.updateQuality()
    const updatedGildedRoseDay2 = gildedRose.updateQuality()

    expect(updatedGildedRoseDay2[0].quality).toBe(DEFAULT_ITEM_QUALITY - 3)
  })

  it("quality shouldn't be negative", () => {
    const gildedRose = new GildedRose([createGildedRoseBuilder({ quality: 0 })])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).not.toBeLessThan(0)
  })

  it("quality shouldn't be more than 50", () => {
    const gildedRose = new GildedRose([createGildedRoseBuilder({ quality: 49 })])

    gildedRose.updateQuality()
    gildedRose.updateQuality()
    gildedRose.updateQuality()
    gildedRose.updateQuality()
    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).not.toBeGreaterThan(50)
  })
})

describe("Aged Brie", () => {
  it("should increase in 1 unit quality", () => {
    const agedBrie = createGildedRoseBuilder({ name: "Aged Brie", sellIn: 1 })
    const gildedRose = new GildedRose([agedBrie])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(DEFAULT_ITEM_QUALITY + 1)
  })

  it("should increase double quality when sellIn is 0", () => {
    const agedBrie = createGildedRoseBuilder({ name: "Aged Brie", sellIn: 1 })
    const gildedRose = new GildedRose([agedBrie])

    gildedRose.updateQuality()
    const updatedGildedRoseDay2 = gildedRose.updateQuality()

    expect(updatedGildedRoseDay2[0].quality).toBe(DEFAULT_ITEM_QUALITY + 3)
  })
})
