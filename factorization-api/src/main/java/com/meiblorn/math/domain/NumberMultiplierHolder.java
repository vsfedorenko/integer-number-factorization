package com.meiblorn.math.domain;

/**
 * @author Meiblorn on 11/09/14.
 */
public class NumberMultiplierHolder {

    private int number;

    private int multiplier;

    public NumberMultiplierHolder() {

    }

    public NumberMultiplierHolder(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
