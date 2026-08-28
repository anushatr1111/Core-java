import java.util.*;
public class CreateaCarClass {
    String brand;
    String model;
    double price;
    void displayDetails(){
        System.out.println("Car Brand: " + brand);
        System.out.println("Car Model: " + model);
        System.out.println("Car Price: " + price);
    }
    public static void main(String[] args) {
        CreateaCarClass car = new CreateaCarClass();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Car Brand: ");
        car.brand = sc.nextLine();
        System.out.println("Enter Car Model: ");
        car.model = sc.nextLine();
        System.out.println("Enter Car Price: ");
        car.price = sc.nextDouble();
        car.displayDetails();
        sc.close();
    }
}
