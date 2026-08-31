import java.util.*;
public class Shape {
    void calculateArea() {
        System.out.println("Calculating area of shape");
    }

}
class Circle extends Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle: " + area);
    }
}
class Rectangle extends Shape {
    double length;
    double width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    void calculateArea() {
        double area = length * width;
        System.out.println("Area of rectangle: " + area);
    }
}
class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(10, 20);

        shape.calculateArea();
        circle.calculateArea();
        rectangle.calculateArea();
    }
}
