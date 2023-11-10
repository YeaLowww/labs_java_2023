package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String color = getRandomColor();
            int shapeType = random.nextInt(3);
            switch (shapeType) {
                case 0:
                    shapes.add(new Rectangle(color, random.nextInt(30) + 1, random.nextInt(30) + 1));
                    break;
                case 1:
                    shapes.add(new Triangle(color, random.nextInt(30) + 1, random.nextInt(30) + 1));
                    break;
                case 2:
                    shapes.add(new Circle(color, random.nextInt(30) + 1));
                    break;
                default:
                    break;
            }
        }
        //////////////////
        System.out.println("All shapes:");
        for (Shape shape : shapes) {
            shape.draw();
        }

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        System.out.println("Total Area: " + totalArea);

        double Area_1 = 0;
        for (Shape shape : shapes) {
            if (shape.getShapeColor().equals("Black")) {
                Area_1 += shape.calcArea();
            }
        }
        System.out.println("Area of Black Color: " + Area_1);

        shapes.sort(Comparator.comparing(Shape::calcArea));
        System.out.println("Sorted shapes by area:");
        for (Shape shape : shapes) {
            shape.draw();
        }
        shapes.sort(Comparator.comparing(Shape::getShapeColor));
        System.out.println("Sorted shapes by color:");
        for (Shape shape : shapes) {
            shape.draw();
        }


    }

    private static String getRandomColor() {
        String[] colors = {"Red", "Blue", "Yellow", "Black", "Pink"};
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }
}
