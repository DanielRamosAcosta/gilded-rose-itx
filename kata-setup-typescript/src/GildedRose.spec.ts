import { describe, expect, it } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"

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

    expect(items[0].sellIn).toBe(-1)
    expect(items[0].quality).toBe(8)
  })
})
