import { describe, it, expect } from "vitest"
import { Item } from "./Item.js"

describe("Item", () => {
  it("should create correctly an Item", () => {
    const randomItem = new Item("random", 0, 0)

    expect(randomItem.name).toBe("random")
    expect(randomItem.quality).toBe(0)
    expect(randomItem.sellIn).toBe(0)
  })
})
