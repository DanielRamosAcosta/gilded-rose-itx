package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemTest {

  @Test
  void shouldToString() {
    Item wine = new Item("Wine", 4, 10);

    String string = wine.toString();

    assertEquals("Wine, 4, 10", string);
  }
}