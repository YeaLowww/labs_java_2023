package org.example;

public class Main {
    public static void main(String[] args) {
        Road road = new Road();

        Car<Human> car1 = new Car<>(4);
        Bus<Firefighter> bus1 = new Bus<>(20);
        Taxi<PoliceOfficer> taxi1 = new Taxi<>(3);
        FireTruck fireTruck1 = new FireTruck(4);
        PoliceCar policeCar1 = new PoliceCar(2);

        try {
            car1.sembarkingP(new Human());
            car1.sembarkingP(new Human());
            car1.sembarkingP(new Human());
            car1.sembarkingP(new Human());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            PoliceOfficer a = new PoliceOfficer();
            taxi1.sembarkingP(a);
            taxi1.sembarkingP(new PoliceOfficer());
            taxi1.sembarkingP(new PoliceOfficer());
            taxi1.disembarkP(a);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            fireTruck1.sembarkingP(new Firefighter());
            fireTruck1.sembarkingP(new Firefighter());
            fireTruck1.sembarkingP(new Firefighter());
            fireTruck1.sembarkingP(new Firefighter());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }


        road.addCarToRoad(car1);
        road.addCarToRoad(bus1);
        road.addCarToRoad(taxi1);
        road.addCarToRoad(fireTruck1);
        road.addCarToRoad(policeCar1);

        System.out.println("Total humans on road: " + road.getCountOfHumans()); // Output: Total humans on road: 17

    }
}
