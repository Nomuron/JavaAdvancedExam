package com.example.jazs20158nbp.model;

import java.time.LocalDate;

public class Rate {

    private LocalDate data;
    private double cena;

    public Rate() {
    }

    public Rate(LocalDate data, double cena) {
        this.data = data;
        this.cena = cena;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
