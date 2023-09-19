package org.example;
import java.util.Arrays;
import java.util.Comparator;
class SportEquipment {
    private String name;
    private int quantity;
    private double price;
    private String manufacturer;
    private boolean isAvailable;
    public SportEquipment(String name, int quantity, double price, String manufacturer, boolean isAvailable) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.manufacturer = manufacturer;
        this.isAvailable = isAvailable;
    }
    // Геттери для полів класу (необов'язково).
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
public class Main {
    public static void main(String[] args) {
        int value = 1107;
        int C11 = value%11;
        System.out.println(C11);
        SportEquipment[] equipmentArray = {
                new SportEquipment("Футбольний м'яч", 10, 25.99, "Adidas", true),
                new SportEquipment("Тенісна ракетка", 5, 49.95, "Wilson", true),
                new SportEquipment("Баскетбольний обруч", 3, 99.99, "Spalding", false),
                new SportEquipment("Велосипед", 2, 199.99, "Trek", true),
                new SportEquipment("Бігова стрічка", 8, 799.00, "NordicTrack", true)
        };

        Arrays.sort(equipmentArray, Comparator.comparingDouble(SportEquipment::getPrice));
        System.out.println("Сортування за зростанням за ціною:");
        for (SportEquipment equipment : equipmentArray) {
            System.out.println(equipment.getName() + " - Ціна: $" + equipment.getPrice());
        }

        Arrays.sort(equipmentArray, Comparator.comparingInt(SportEquipment::getQuantity).reversed());
        System.out.println("\nСортування за спаданням за кількістю:");
        for (SportEquipment equipment : equipmentArray) {
            System.out.println(equipment.getName() + " - Кількість: " + equipment.getQuantity());
        }

    }
}
