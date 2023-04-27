package org.example.quality;

public class Quality {

  private int value;

  public Quality(int value) {
    this.value = value;
  }

  public void reset() {
    this.value = 0;
  }

  public void increase(int offset) {
    this.value = this.value + offset;
  }

  public void decrease(int offset) {
    this.value = this.value - offset;
  }

  public void enforceIsNotBelowZero() {
    if (this.value < 0) {
      this.value = 0;
    }
  }

  public void enforceIsNotOverFifty() {
    if (this.value > 50) {
      this.value = 50;
    }
  }

  public boolean hasQualityValue(int value) {
    return this.value == value;
  }

}
