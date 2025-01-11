package com.dailycodework.dream_shops.ParkingLot;

public class CashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in cash.");
    }

}
