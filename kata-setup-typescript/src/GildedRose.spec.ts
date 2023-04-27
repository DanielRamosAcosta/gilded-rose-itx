import { describe, expect, it } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"
import { AGED_BRIE_NAME, BACKSTAGE_PASSES_NAME, SULFURAS_NAME } from "./constants/items-names.js"

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

  it("a backstage pass should increase quality by one if concert date is more than 10 days away", () => {
    const gildedRose = new GildedRose([new Item(BACKSTAGE_PASSES_NAME, 15, 5)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(6)
  })

  it("a backstage pass should increase quality by two if concert date is less than 10 days away, and more than 5", () => {
    const gildedRose = new GildedRose([new Item(BACKSTAGE_PASSES_NAME, 8, 5)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(7)
  })

  it("a backstage pass should increase quality by three if concert date is less than 5 days away", () => {
    const gildedRose = new GildedRose([new Item(BACKSTAGE_PASSES_NAME, 3, 5)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(8)
  })

  it("a backstage pass should lose all quality concert date is expired", () => {
    const gildedRose = new GildedRose([new Item(BACKSTAGE_PASSES_NAME, 0, 10)])

    const items = gildedRose.updateQuality()

    expect(items[0].quality).toBe(0)
  })
})
