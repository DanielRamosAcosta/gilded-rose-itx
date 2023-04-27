import { describe, expect, it } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"
import { AGED_BRIE_NAME, SULFURAS_NAME } from "./constants/items-names.js"

describe("Gilded Rose", () => {
  it("an unknown item must decrement sellIn and quality by one each day", () => {
    const gildedRose = new GildedRose([new Item("apple", 5, 5)])

    const items = gildedRose.updateQuality()

    expect(items[0].sellIn).toBe(4)
    expect(items[0].quality).toBe(4)
  })

  it("an unknown item must decrement quality by two if sellIn is expired (0 or less)", () => {
    const gildedRose = new GildedRose([new Item("fresh apple", 0, 10)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(8)
  })

  it("an unknown item must never has a quality less than zero", () => {
    const gildedRose = new GildedRose([new Item("rotten apple", 0, 0)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(0)
  })

  it("aged items increase quality by one each day if they are on sellIn date", () => {
    const gildedRose = new GildedRose([new Item(AGED_BRIE_NAME, 5, 5)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(6)
  })

  it("aged items increase quality by two each day if they are over sellIn date", () => {
    const gildedRose = new GildedRose([new Item(AGED_BRIE_NAME, 0, 5)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(7)
  })

  it("an item quality should never be greater than 50", () => {
    const gildedRose = new GildedRose([new Item(AGED_BRIE_NAME, 0, 50)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(50)
  })

  it("a legendary item should never loss sellIn and quality", () => {
    const gildedRose = new GildedRose([new Item(SULFURAS_NAME, 40, 40)])

    const items = gildedRose.updateQuality()

    expect(items[0].sellIn).toBe(40)
    expect(items[0].quality).toBe(40)
  })
})
