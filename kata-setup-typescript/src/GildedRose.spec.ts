import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item, ItemType } from "./Item.js"

const buildADataSet = () => [new Item("Aged Brie", 10, 0, ItemType.Aged),new Item("Sulfuras, Hand of Ragnaros", 0, 0, ItemType.Legendary), new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0, ItemType.Backstage) ];

describe("Gilded Rose", () => {
  it("should foo", () => {
    const gildedRose = new GildedRose(buildADataSet())
    const items = gildedRose.updateQuality()
    expect(items[0].name).toBe("Aged Brie")
  })
  it("should updated quality successfully", () => {
    const gildedRose = new GildedRose(buildADataSet())
    const items = gildedRose.updateQuality()
    console.log("items", items[0].quality)
    expect(items[0].quality).toBe(1)
  })
})
