import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"

describe("Gilded Rose", () => {
  it("should foo", () => {
    const gildedRose = new GildedRose([new Item("fixme", 0, 0)])
    const items = gildedRose.updateQuality()
    expect(items[0].name).toBe("fixme")
  })
})
