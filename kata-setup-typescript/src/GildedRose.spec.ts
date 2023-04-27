import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item } from "./Item.js"

const DEFAULT_ITEM_NAME = "item-name"
const DEFAULT_ITEM_QUALITY = 5
const DEFAULT_ITEM_SELLIN = 5

const ITEM_MOTHER = (name?: Item["name"], quality?: Item["quality"], sellIn?: Item["quality"]) => {
  return new Item(name ?? DEFAULT_ITEM_NAME, quality ?? DEFAULT_ITEM_QUALITY, sellIn ?? DEFAULT_ITEM_SELLIN)
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
    const basicItem = new GildedRose([new Item("basic-item", 1, 1)])
    const updatedBasicItem = basicItem.updateQuality()
    expect(updatedBasicItem[0].quality).toBe(0)
  })
})
