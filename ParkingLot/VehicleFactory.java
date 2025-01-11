package com.dailycodework.dream_shops.ParkingLot;

class VehicleFactory {
    public static Vehicle createVehicle(String licensePlate, VehicleType type) {
        switch (type) {
            case CAR:
                return new Car(licensePlate);
            case BIKE:
                return new Bike(licensePlate);
            case TRUCK:
                return new Truck(licensePlate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type"); } } }