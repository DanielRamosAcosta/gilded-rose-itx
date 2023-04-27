import { describe, it, expect } from "vitest"
import { GildedRose } from "./GildedRose.js"
import { Item, ItemType } from "./Item.js"
import { beforeEach } from "node:test"

const aNormal = (sellIn: number, quality: number) => new Item("Normal item", sellIn, quality, ItemType.Normal)

const aLegendary = (sellIn: number, quality: number) =>
  new Item("Sulfuras, Hand of Ragnaros", sellIn, quality, ItemType.Legendary)

const anAged = (sellIn: number, quality: number) => new Item("Aged Brie", sellIn, quality, ItemType.Aged)

const aBackstage = (sellIn: number, quality: number) =>
  new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality, ItemType.Backstage)

describe("Gilded Rose", () => {
  describe("should update item quality successfully", () => {
    describe("when item is Normal", () => {
      describe("and the sell in date is future", () => {
        it("then quality is decreased in 1", () => {
          const gildedRose = new GildedRose([aNormal(5, 5)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(4)
        })
      })
      describe("and the sell in date is past", () => {
        it("then quality is decreased in 2", () => {
          const gildedRose = new GildedRose([aNormal(0, 5)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(3)
        })
      })
    })
    describe("when item is Aged", () => {
      describe("and the sell in date is past", () => {
        it("then quality is increased in 2", () => {
          const gildedRose = new GildedRose([anAged(0, 5)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(7)
        })
        describe("and the sell in date future", () => {
          it("then quality is increased in 1", () => {
            const gildedRose = new GildedRose([anAged(10, 5)])
            const items = gildedRose.updateQuality()
            expect(items[0].quality).toBe(6)
          })
        })
      })

      describe("and the sell in date if future", () => {
        describe("and the quality is 50", () => {
          it("then quality is 50", () => {
            const gildedRose = new GildedRose([anAged(10, 50)])
            const items = gildedRose.updateQuality()
            expect(items[0].quality).toBe(50)
          })
        })
      })
    })
    describe("when item is Legendary", () => {
      it("then quality is not increased", () => {
        const gildedRose = new GildedRose([aLegendary(10, 5)])
        const items = gildedRose.updateQuality()
        expect(items[0].quality).toBe(5)
      })
      describe("and the quality is more than 50", () => {
        it("then quality is 50", () => {
          const gildedRose = new GildedRose([anAged(10, 50)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(50)
        })
      })
    })
    describe("when item is Backstage", () => {
      describe("and the sell in date is 10 days", () => {
        it("then quality is increased in 2", () => {
          const gildedRose = new GildedRose([aBackstage(10, 6)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(8)
        })
      })
      describe("and the sell in date is less than 10 days", () => {
        it("then quality is increased in 2", () => {
          const gildedRose = new GildedRose([aBackstage(9, 6)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(8)
        })
      })
      describe("and the sell in date is less than 5 days", () => {
        it("then quality is increased in 3", () => {
          const gildedRose = new GildedRose([aBackstage(5, 6)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(9)
        })
      })
      describe("and the sell in date is less than 0 days", () => {
        it("then quality is increased in 3", () => {
          const gildedRose = new GildedRose([aBackstage(0, 6)])
          const items = gildedRose.updateQuality()
          expect(items[0].quality).toBe(0)
        })
      })
    })
  })
})
