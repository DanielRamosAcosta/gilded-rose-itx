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

describe("Sulfuras", () => {
  it("shouldn't change anything", () => {
    const sulfuras = createGildedRoseBuilder({ name: "Sulfuras, Hand of Ragnaros" })
    const gildedRose = new GildedRose([sulfuras])

    gildedRose.updateQuality()
    gildedRose.updateQuality()
    gildedRose.updateQuality()
    gildedRose.updateQuality()
    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(DEFAULT_ITEM_QUALITY)
    expect(updatedGildedRose[0].sellIn).toBe(DEFAULT_ITEM_SELLIN)
  })
})

describe("Backstage", () => {
  it("should increase in 1 unit quality and decrease 1 unit sellIn", () => {
    const gildedRose = new GildedRose([
      createGildedRoseBuilder({ name: "Backstage passes to a TAFKAL80ETC concert", sellIn: 20 }),
    ])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(DEFAULT_ITEM_QUALITY + 1)
    expect(updatedGildedRose[0].sellIn).toBe(19)
  })

  it("should increase in 2 unit quality and decrease 1 unit sellIn when 10 days or less are missing", () => {
    const gildedRose = new GildedRose([
      createGildedRoseBuilder({ name: "Backstage passes to a TAFKAL80ETC concert", sellIn: 10 }),
    ])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(DEFAULT_ITEM_QUALITY + 2)
    expect(updatedGildedRose[0].sellIn).toBe(9)
  })

  it("should increase in 3 unit quality and decrease 1 unit sellIn when 5 days or less are missing", () => {
    const gildedRose = new GildedRose([
      createGildedRoseBuilder({ name: "Backstage passes to a TAFKAL80ETC concert", sellIn: 5 }),
    ])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(DEFAULT_ITEM_QUALITY + 3)
    expect(updatedGildedRose[0].sellIn).toBe(4)
  })

  it("should have 0 quality when sellIn is 0", () => {
    const gildedRose = new GildedRose([
      createGildedRoseBuilder({ name: "Backstage passes to a TAFKAL80ETC concert", sellIn: 0 }),
    ])

    const updatedGildedRose = gildedRose.updateQuality()

    expect(updatedGildedRose[0].quality).toBe(0)
    expect(updatedGildedRose[0].sellIn).toBe(-1)
  })
})
