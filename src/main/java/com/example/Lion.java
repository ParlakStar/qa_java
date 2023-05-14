package com.example;

import java.util.List;

public class Lion {
    private FelineMetod felineMetod;

    public Lion(FelineMetod felineMetod) {
        this.felineMetod = felineMetod;
    }

    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }


    public int getKittens() {
        return felineMetod.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return felineMetod.getFood("Хищник");
    }
}
