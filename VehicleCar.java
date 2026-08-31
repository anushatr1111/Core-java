import java.util.*;
public class VehicleCar {
    String brand;
    int speed;
    void start(){
        System.out.println(brand + " is starting.");
        System.out.println("Speed: " + speed + " km/h.");
    }
}
class Car extends VehicleCar {
    int numberOfDoors;
    void displayCar(){
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Number of doors: " + numberOfDoors);
    }
}
class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.brand = "Toyota";
        car.speed = 120;
        car.numberOfDoors = 4;
        car.start();
        car.displayCar();
    }
}
