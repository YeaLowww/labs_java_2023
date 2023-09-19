import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Базовий клас для електроприладів
class ElectricalAppliance {
    private String name;
    private double power;

    public ElectricalAppliance(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public String getName() {
        return name;
    }
}

// Класи-нащадки для конкретних типів електроприладів
class Refrigerator extends ElectricalAppliance {
    public Refrigerator(String name, double power) {
        super(name, power);
    }
}

class TV extends ElectricalAppliance {
    public TV(String name, double power) {
        super(name, power);
    }
}

class Laptop extends ElectricalAppliance {
    public Laptop(String name, double power) {
        super(name, power);
    }
}

    public class Main {
        public static void main(String[] args) {
            int value = 1107;
            int c13 = value % 13;
            System.out.println(c13);

            Refrigerator fridge = new Refrigerator("Холодильник", 200);
            TV tv = new TV("Телевізор", 100);
            Laptop laptop = new Laptop("Ноутбук", 50);

            // Додавання електроприладів до списку
            List<ElectricalAppliance> appliances = new ArrayList<>();
            appliances.add(fridge);
            appliances.add(tv);
            appliances.add(laptop);

            // Увімкнення електроприладів
            for (ElectricalAppliance appliance : appliances) {
                System.out.println("Увімкнено: " + appliance.getName());
            }

            // Обчислення споживаної потужності
            double totalPower = appliances.stream().mapToDouble(ElectricalAppliance::getPower).sum();
            System.out.println("Загальна споживана потужність: " + totalPower + " Вт");

            // Сортування приладів за потужністю
            Collections.sort(appliances, Comparator.comparingDouble(ElectricalAppliance::getPower));
            System.out.println("Прилади відсортовані за потужністю:");

            for (ElectricalAppliance appliance : appliances) {
                System.out.println(appliance.getName() + ": " + appliance.getPower() + " Вт");
            }

            // Пошук приладів за заданим діапазоном електромагнітного випромінювання
            double minEMF = 0.1; // Мінімальний діапазон
            double maxEMF = 0.5; // Максимальний діапазон

            System.out.println("Прилади з електромагнітним випромінюванням від " + minEMF + " до " + maxEMF + ":");
            for (ElectricalAppliance appliance : appliances) {
                if (appliance instanceof TV) {
                    double emf = Math.random(); // Генеруємо випадкове значення електромагнітного випромінювання
                    if (emf >= minEMF && emf <= maxEMF) {
                        System.out.println(appliance.getName() + ": " + emf);
                    }
                }
            }
        }
    }

