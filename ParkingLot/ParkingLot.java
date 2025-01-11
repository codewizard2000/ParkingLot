package com.dailycodework.dream_shops.ParkingLot;

import java.util.*;

class ParkingLot {
    private static ParkingLot instance;
    private Map<VehicleType, List<ParkingSpot>> spots;
    private int capacity;
    private int gates;

    private ParkingLot(int capacity, int gates) {
        this.capacity = capacity;
        this.gates = gates;
        spots = new HashMap<>();
        spots.put(VehicleType.CAR, new ArrayList<>());
        spots.put(VehicleType.BIKE, new ArrayList<>());
        spots.put(VehicleType.TRUCK, new ArrayList<>());
    }

    public static synchronized ParkingLot getInstance(int capacity, int gates) {
        if (instance == null) {
            instance = new ParkingLot(capacity, gates);
        }
        return instance;
    }

    public void addParkingSpot(ParkingSpot spot) {
        spots.get(spot.getType()).add(spot);
    }

    public boolean parkVehicle(Vehicle vehicle,Payment payment) throws ParkingFullException {
        List<ParkingSpot> availableSpots = spots.get(vehicle.getType());
        availableSpots.sort(Comparator.comparingInt(ParkingSpot::getGateNumber)); // Sort by gate number
        for (ParkingSpot spot : availableSpots) {
            if (spot.parkVehicle(vehicle)) {
                payment.pay(spot.getRate());
                return true;
            }
        }
        throw new ParkingFullException("No available parking spots for " + vehicle.getType());
    }

    public void removeVehicle(Vehicle vehicle) {
        List<ParkingSpot> availableSpots = spots.get(vehicle.getType());
        for (ParkingSpot spot : availableSpots) {
            if (spot.getVehicle() != null && spot.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                spot.removeVehicle();
                break;
            }
        }
    }

    public int getAvailableSpots(VehicleType type) {
        int count = 0;
        for (ParkingSpot spot : spots.get(type)) {
            if (!spot.isOccupied()) {
                count++;
            }
        }
        return count;
    }
}
