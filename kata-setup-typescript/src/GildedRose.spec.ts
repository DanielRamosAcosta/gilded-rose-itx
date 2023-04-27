import { describe, expect, it } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"

describe("Gilded Rose", () => {
  it("a unknown item must decrement sellIn and quality by one", () => {
    const gildedRose = new GildedRose([new Item("apple", 5, 5)])
    const items = gildedRose.updateQuality()
    expect(items[0].sellIn).toBe(4)
    expect(items[0].quality).toBe(4)
  })
})
