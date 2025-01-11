package com.dailycodework.dream_shops.ParkingLot;

public class Car implements Vehicle{


    private String licensePlate;
    private VehicleType type;

    public Car(String licensePlate) {
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
