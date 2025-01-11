package com.dailycodework.dream_shops.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance(100, 5);

        // Adding parking spots with different rates and gate numbers
        for (int i = 0; i < 50; i++) {
            parkingLot.addParkingSpot(new ParkingSpot(i, VehicleType.CAR, 20.0, i % 5));
        }
        for (int i = 50; i < 80; i++) {
            parkingLot.addParkingSpot(new ParkingSpot(i, VehicleType.BIKE, 10.0, i % 5));
        }
        for (int i = 80; i < 100; i++) {
            parkingLot.addParkingSpot(new ParkingSpot(i, VehicleType.TRUCK, 30.0, i % 5));
        }

        Vehicle car1 = VehicleFactory.createVehicle("ABC123", VehicleType.CAR);
        Vehicle bike1 = VehicleFactory.createVehicle("XYZ789", VehicleType.BIKE);
        Vehicle truck1 = VehicleFactory.createVehicle("LMN456", VehicleType.TRUCK);

        Payment cashPayment = new CashPayment();
        Payment cardPayment = new CardPayment();

        try {
            parkingLot.parkVehicle(car1,cardPayment);
            parkingLot.parkVehicle(bike1,cardPayment);
            parkingLot.parkVehicle(truck1,cardPayment);
        } catch (ParkingFullException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Available car spots: " + parkingLot.getAvailableSpots(VehicleType.CAR));
        System.out.println("Available bike spots: " + parkingLot.getAvailableSpots(VehicleType.BIKE));
        System.out.println("Available truck spots: " + parkingLot.getAvailableSpots(VehicleType.TRUCK));

        parkingLot.removeVehicle(car1);

        System.out.println("Available car spots after removing car1: " + parkingLot.getAvailableSpots(VehicleType.CAR));
    }
}

