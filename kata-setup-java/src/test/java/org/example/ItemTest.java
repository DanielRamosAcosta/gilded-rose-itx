package org.example;

import static org.example.mothers.ItemMother.createWine;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemTest {

  @Test
  void shouldToString() {
    Item wine = createWine(4, 10);

    String string = wine.toString();

    assertEquals("Wine, 4, 10", string);
  }
}