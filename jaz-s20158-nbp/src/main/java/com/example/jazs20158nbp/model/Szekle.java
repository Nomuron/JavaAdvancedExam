package com.example.jazs20158nbp.model;

import java.util.List;

public class Szekle {

    private List<Rate> rates;

    public Szekle(List<Rate> rates) {
        this.rates = rates;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
