package com.solvd.laba.homesellingcompany.services;

import com.solvd.laba.homesellingcompany.entities.Person;
import com.solvd.laba.homesellingcompany.entities.UsersProperty;
import com.solvd.laba.homesellingcompany.services.interfaces.Sell;

import java.util.Scanner;


public class ConsolePrinter implements Sell {

    @Override
    public void sellEntity(String name, String location, double price) {
        System.out.println(name + " sold in location: " + location + " at price: " + price);
    }

    @Override
    public void listEntityFeatures(int bedrooms, int bathrooms, boolean garage) {
        System.out.println("House features: " + bedrooms + " bedrooms, " + bathrooms + " bathrooms, garage: " + garage);
    }

    @Override
    public void listEntityFeatures(int bedrooms, int bathrooms, int floor) {
        System.out.println("Apartment features: " + bedrooms + " bedrooms, " + bathrooms + " bathrooms, on floor: " + floor);
    }
    private static Scanner scanner = new Scanner(System.in);

    public void message (String words) {
        System.out.println(words);
    };

    public double readNumber(double value, String prompt, double min, double max) {
        System.out.println(prompt + value);
        if (value < min || value > max) {
            System.out.println("Enter a value between " + (int)min + " and " + (int)max + ": ");
            System.exit(1);
        }
        return value;

    }

    public static Person addPersonData(String name, String lastName, int age, String phoneNumber) {
        System.out.println("Write your name: ");

        System.out.println("Write your last name: ");

        System.out.println("Write your age: ");

        System.out.println("Write your phone number: ");

        return new Person(name, lastName, age, phoneNumber);
    }

    public void askPropertyQuestions(UsersProperty details) {
        System.out.println("What type of property you have?: " + details.propertyType);
        System.out.println("Write the price of your property: " + details.price);
        System.out.println("Where is your property located? " + details.location);
        System.out.println("How many bathrooms are there? " + details.bathrooms);
        System.out.println("How many bedrooms are there? " + details.bedrooms);

        if ("House".equals(details.propertyType)) {
            System.out.println("Do you have a garage? (true/false) " + details.garage);
            sellEntity(details.propertyType, details.location, details.price);
            listEntityFeatures(details.bedrooms, details.bathrooms, details.garage);
        } else {
            System.out.println("What floor is this on? " + details.floor);
            sellEntity(details.propertyType, details.location, details.price);
            listEntityFeatures(details.bedrooms, details.bathrooms, details.floor);
        }
    }

    }


