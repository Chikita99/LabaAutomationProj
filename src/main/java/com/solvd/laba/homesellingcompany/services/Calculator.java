package myproject.services;

import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {

    public final void calculateMortgage(
            int principal,
            float annualRate,
            byte period) {

        float numberOfPayments = period * Data.getMonthsInYear();
        float monthlyInterest = (annualRate / Data.getPercentage()) / Data.getMonthsInYear();

        double mortgage = principal
                * (monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments)))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        System.out.println("\nMORTGAGE\n--------\nMonthly Payments: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(mortgage));
    }

    public static double remainingBalance(
            int principal,
            float annualRate,
            byte period,
            int numberOfPaymentsMade) {

        float numberOfPayments = period * Data.getMonthsInYear();
        float monthlyInterest = (annualRate/Data.getPercentage()) / Data.getMonthsInYear();

        double balance = principal
                * ((Math.pow(1 + monthlyInterest,numberOfPayments)) - (Math.pow(1 + monthlyInterest,numberOfPaymentsMade)))
                / (Math.pow(1 + monthlyInterest,numberOfPayments) - 1);

        return balance;
    };
}
