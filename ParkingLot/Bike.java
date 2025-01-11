package com.dailycodework.dream_shops.ParkingLot;

public class Bike implements Vehicle{
    private String licensePlate;
    private VehicleType type;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
        this.type = VehicleType.CAR;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override public VehicleType getType() {
        return type;
    }
}
