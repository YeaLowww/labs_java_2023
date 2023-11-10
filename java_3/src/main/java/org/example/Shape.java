package org.example;

abstract class Shape implements Drawable {
    private String shapeColor;
    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }
    public abstract double calcArea();
    @Override
    public String toString(){
        return "Shape of color " + shapeColor +
                ", Area: " + calcArea();
    }
    @Override
    public void draw(){
        System.out.println(this);
    }
    public String getShapeColor(){
        return shapeColor;
    }
}
