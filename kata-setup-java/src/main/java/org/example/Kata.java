package org.example;

public class Kata {
    private final Dependency dependency;

    public Kata(Dependency dependency) {
        this.dependency = dependency;
    }

    public int getValue() {
        return this.dependency.getValue();
    }
}
