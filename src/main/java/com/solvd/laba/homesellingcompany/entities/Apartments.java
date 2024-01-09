package com.solvd.laba.homesellingcompany.entities;

import com.solvd.laba.homesellingcompany.entities.base.Building;
import com.solvd.laba.homesellingcompany.entities.interfaces.PricedProperty;

import java.util.ArrayList;
import java.util.List;

public class Apartments extends Building implements PricedProperty {
    private static List<Apartments> allApartments = new ArrayList<>();
    private int floor;
    private static int availableHome = 0;

    public static int getAvailableHomes() {
        return availableHome;
    }

    public Apartments(int price, double squareMeters, String location, int floor, boolean isNew) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.location = location;
        this.floor = floor;
        this.isNew = isNew;
        availableHome ++;
        allApartments.add(this);
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return  " price=" + price +
                ", squareMeters=" + squareMeters +
                ", location='" + location + '\'' +
                ", floor=" + floor +
                ", isNew=" + isNew;
    }

    public static void printAllApartments() {
        int apartmentNumber = 0;
        for (Apartments apartment : allApartments) {
            apartmentNumber++;
            System.out.println("Apartments #" + apartmentNumber);
            System.out.println(apartment.toString());
        }
    }

    public static List<Apartments> getAllApartments() {
        return allApartments;
    }
}

