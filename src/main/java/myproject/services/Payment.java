package myproject.services;

import myproject.services.Calculator;
import myproject.services.Data;

import java.text.NumberFormat;
import java.util.Locale;

public final class Payment {

    public void paymentSchedule(int principal, float annualRate, byte period) {
        System.out.println("\nPAYMENTS SCHEDULE\n--------");

        for (short month = 1; month <= period * Data.getMonthsInYear(); month++) {
            double balance = Calculator.remainingBalance(principal, annualRate, period, month);
            System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(balance));
        }
    }

}