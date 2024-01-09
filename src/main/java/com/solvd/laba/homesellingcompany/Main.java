package com.solvd.laba.homesellingcompany;
import com.solvd.laba.homesellingcompany.entities.Apartments;
import com.solvd.laba.homesellingcompany.entities.Homes;
import com.solvd.laba.homesellingcompany.entities.Person;
import com.solvd.laba.homesellingcompany.entities.UsersProperty;
import com.solvd.laba.homesellingcompany.services.Calculator;
import com.solvd.laba.homesellingcompany.services.ConsolePrinter;
import com.solvd.laba.homesellingcompany.services.ContactInfo;
import com.solvd.laba.homesellingcompany.services.Payment;
import myproject.entities.*;
import com.solvd.laba.homesellingcompany.entities.base.Building;
import myproject.services.*;
import com.solvd.laba.homesellingcompany.services.exceptions.MissingBuildingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int principal = 0;
        float annualRate = 0;
        byte period = 0;
        ConsolePrinter consolePrinter = new ConsolePrinter();
        UsersProperty details = new UsersProperty("House", 300000.0, "123 Main St", 2, 3, true, 0);
        new Homes(500000, 120.5, "Central Park 15, New York", true);
        new Homes(90000, 80.4, "Road avn. 13, San Francisco", false);
        new Homes(190000, 62.4, "New Road 12, San Francisco", false);

        new Apartments(90000, 75.2, "Some Road 12, New York", 10, false);
        new Apartments(70000, 65.5, "Bets Road 15, Detroit", 4, false);

        logger.info("Start of the Program");
        consolePrinter.message("Hello!");

        try {
            if (Homes.getAvailableHomes() < 1) {
                throw new MissingBuildingException("Homes", 1);
            }
            if (Apartments.getAvailableHomes() < 1) {
                throw new MissingBuildingException("Apartments", 1);
            }
            
        consolePrinter.message ("We have " + Homes.getAvailableHomes() + " available homes at the moment and " + Apartments.getAvailableHomes() + " Apartments");
        consolePrinter.message("");
        consolePrinter.message("For now we have next variants for you");

        Homes.printAllHomes();
        Apartments.printAllApartments();

        Homes.printAllHomes();
        Apartments.printAllApartments();


        } catch (MissingBuildingException e) {
            System.err.println("Error: " + e.getMessage());
        }

        Homes bestPricedHome = Building.bestBuilding(Homes.getAllHomes());
        if (bestPricedHome != null) {
            System.out.println("Best priced home is located at: " + bestPricedHome.location + " with price " + bestPricedHome.price + "$");
        }

        Apartments bestPricedApartment = Building.bestBuilding(Apartments.getAllApartments());
        if (bestPricedApartment != null) {
            System.out.println("Best priced apartment is located at: " + bestPricedApartment.location + " with price " + bestPricedApartment.price + "$");
        }

        consolePrinter.message("Please provide us information about yourself so we can found a good home for you!");
        logger.info("User info checking");
        Person person = ConsolePrinter.addPersonData("Nick", "Sadomtsev", 29, "+1602394204");

        consolePrinter.message("Thank you for your info, here is what we get.");
        System.out.println(Person.toString(person));

        consolePrinter.message("We can give you a mortgage, please fill next data.");


        principal = (int) consolePrinter.readNumber( 10000,"Principal (1k - 1m):" , 1000, 1_000_000);
        annualRate = (float) consolePrinter.readNumber(3.2, "Annual Interest Rate:", 0, 30);
        period = (byte) consolePrinter.readNumber(10, "Period (Years):", 1, 30);


        Calculator calculator = new Calculator();
        calculator.calculateMortgage(principal, annualRate, period);
        Payment payment = new Payment();
        payment.paymentSchedule(principal, annualRate, period);

        System.out.println("For any questions, contact us.");
        ContactInfo contact = new ContactInfo();
        System.out.println("Our address " + ContactInfo.getAddress());
        System.out.println("Phone number: " + ContactInfo.getPhoneNumber());
        System.out.println();

        consolePrinter.message("In addition you can write information about your home, if you want to sell it.");
        consolePrinter.askPropertyQuestions(details);

        int hashCode = person.hashCode();

        logger.info("End of program run");

    }

}