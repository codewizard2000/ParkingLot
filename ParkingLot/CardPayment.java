package com.dailycodework.dream_shops.ParkingLot;

public class CardPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using card.");
    }
}
