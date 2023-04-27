import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"
import { log } from "util"

const DEFAULT_ITEM_NAME = "item-name"
const DEFAULT_ITEM_QUALITY = 5
const DEFAULT_ITEM_SELLIN = 5

const createGildedRoseBuilder = ({ name, quality, sellIn }: { name?: string; quality?: number; sellIn?: number }) => {
  return new Item(name ?? DEFAULT_ITEM_NAME, sellIn ?? DEFAULT_ITEM_SELLIN, quality ?? DEFAULT_ITEM_QUALITY)
}

describe("Gilded Rose", () => {
  it("should foo", () => {
    const gildedRose = new GildedRose([new Item("fixme", 0, 0)])
    const items = gildedRose.updateQuality()
    expect(items[0].name).toBe("fixme")
  })
})
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
})
