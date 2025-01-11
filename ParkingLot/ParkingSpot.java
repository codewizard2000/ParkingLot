package com.dailycodework.dream_shops.ParkingLot;


class ParkingSpot {
    private int spotNumber;
    private VehicleType type;
    private boolean isOccupied;
    private Vehicle vehicle;
    private double rate;
    private int gateNumber;

    public ParkingSpot(int spotNumber, VehicleType type, double rate, int gateNumber) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.rate = rate;
        this.gateNumber = gateNumber;
        this.isOccupied = false;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied && vehicle.getType() == type) {
            this.vehicle = vehicle;
            isOccupied = true;
            return true;
        }
        return false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getRate() {
        return rate;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public VehicleType getType() {
        return type;
    }
}

