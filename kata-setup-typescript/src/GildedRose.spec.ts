import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item, ItemType } from "./Item.js"
import { beforeEach } from "node:test"

const buildADataSet = () => [
  new Item("Aged Brie", 10, 0, ItemType.Aged),
  new Item("Sulfuras, Hand of Ragnaros", 0, 0, ItemType.Legendary),
  new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0, ItemType.Backstage),
]

describe("Gilded Rose", () => {
  describe("should updated quality successfully", () => {
    describe("when item is Aged", () => {
      describe("and the sell in date is past", () => {
        it("then quality is increased in 2", () => {
          const gildedRose = new GildedRose([new Item("Aged Brie", 0, 5, ItemType.Aged)])
          const items = gildedRose.updateQuality()
          console.log("items", items[0].quality)
          expect(items[0].quality).toBe(7)
        })
        describe("and the sell in date future", () => {
          it("then quality is increased in 1", () => {
            const gildedRose = new GildedRose([new Item("Aged Brie", 10, 5, ItemType.Aged)])
            const items = gildedRose.updateQuality()
            console.log("items", items[0].quality)
            expect(items[0].quality).toBe(6)
          })
        })
      })
    })
    it("when item is Legendary", () => {
      const gildedRose = new GildedRose([new Item("Sulfuras, Hand of Ragnaros", 10, 5, ItemType.Legendary)])
      const items = gildedRose.updateQuality()
      console.log("items", items[0].quality)
      expect(items[0].quality).toBe(5)
    })
    describe("when item is Backstage", () => {
      describe("and the sell in date is 10 days", () => {
        it("then quality is increased in 2", () => {
          const gildedRose = new GildedRose([
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 6, ItemType.Backstage),
          ])
          const items = gildedRose.updateQuality()
          console.log("items", items[0].quality)
          expect(items[0].quality).toBe(8)
        })
      })
      describe("and the sell in date is less than 10 days", () => {
        it("then quality is increased in 2", () => {
          const gildedRose = new GildedRose([
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 6, ItemType.Backstage),
          ])
          const items = gildedRose.updateQuality()
          console.log("items", items[0].quality)
          expect(items[0].quality).toBe(8)
        })
      })
      describe("and the sell in date is less than 5 days", () => {
        it("then quality is increased in 3", () => {
          const gildedRose = new GildedRose([
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 6, ItemType.Backstage),
          ])
          const items = gildedRose.updateQuality()
          console.log("items", items[0].quality)
          expect(items[0].quality).toBe(9)
        })
      })
      describe("and the sell in date is less than 0 days", () => {
        it("then quality is increased in 3", () => {
          const gildedRose = new GildedRose([
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 6, ItemType.Backstage),
          ])
          const items = gildedRose.updateQuality()
          console.log("items", items[0].quality)
          expect(items[0].quality).toBe(0)
        })
      })
    })
  })
})
