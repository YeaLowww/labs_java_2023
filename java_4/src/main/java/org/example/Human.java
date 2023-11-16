package org.example;

import java.util.ArrayList;
import java.util.List;

public class Human {}

class Firefighter extends Human{}
class PoliceOfficer extends Human{}
class Vehicle<T extends Human> {
    private int maxSeats;

    private int occupiedSeats;
    private List<T>  passengers = new ArrayList<>();
    public Vehicle(int maxSeats){
        this.maxSeats=maxSeats;
    }
    public void sembarkingP(T passenger) {
        if (occupiedSeats < maxSeats) {
            passengers.add(passenger);
            occupiedSeats++;
        } else {
            throw new IllegalStateException("All seats are occupied");
        }
    }
    public void disembarkP(T passenger) {
        if (passengers.contains(passenger)) {
            passengers.remove(passenger);
            occupiedSeats--;
        } else {
            throw new IllegalStateException("Passenger is not on board");
        }
    }
    public int getMaxSeats() {
        return maxSeats;
    }
    public int getOccupiedSeats() {
        return occupiedSeats;
    }
}
class Car<T extends Human> extends Vehicle<T> {
    public Car(int maxSeats){
        super(maxSeats);
    }
}
class Bus<T extends Human> extends Vehicle<T> {
    public Bus(int maxSeats) {
        super(maxSeats);
    }
}
class Taxi<T extends Human> extends Car<T>{
    public Taxi(int maxSeats){
        super(maxSeats);
    }
}
class FireTruck extends Car<Firefighter> {
    public FireTruck(int maxSeats) {
        super(maxSeats);
    }
}
class PoliceCar extends Car<PoliceOfficer> {
    public PoliceCar(int maxSeats) {
        super(maxSeats);
    }
}

