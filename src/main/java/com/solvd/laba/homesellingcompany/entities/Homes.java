package myproject.entities;

import myproject.entities.base.Building;
import myproject.entities.interfaces.PricedProperty;

import java.util.ArrayList;
import java.util.List;

public class Homes extends Building implements PricedProperty {
    private static List<Homes> allHomes = new ArrayList<>();

    private static int availableHome = 0;

    public static int getAvailableHomes() {
        return availableHome;
    }


    public Homes(int price, double squareMeters, String location, boolean isNew) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.location = location;
        this.isNew = isNew;
        availableHome++;
        allHomes.add(this);
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
                ", isNew=" + isNew;
    }

    public static void printAllHomes() {
        int homeNumber = 0;
        for (Homes home : allHomes) {
            homeNumber++;
            System.out.println("Home #" + homeNumber);
            System.out.println(home.toString());
        }
    }

    public static List<Homes> getAllHomes() {
        return allHomes;
    }
}
