package com.example;

import java.util.List;

public class Lion {
    private final Feline feline;

    private final boolean hasMane;

    public Lion(Feline feline, String gender) {
        this.feline = feline;

        if ("Самец".equals(gender)) {
            hasMane = true;
        } else if ("Самка".equals(gender)) {
            hasMane = false;
        } else {
            throw new IllegalStateException("Используйте допустимые значения пола животного - самец или самка");
        }
    }


    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}