import java.util.*;
public class RectangleClass {
    double length;
    double width;

    void displayDetails() {
        System.out.println("Rectangle Length: " + length);
        System.out.println("Rectangle Width: " + width);
    }
    public static void main(String[] args) {
        RectangleClass rectangle = new RectangleClass();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rectangle Length: ");
        rectangle.length = sc.nextDouble();
        System.out.println("Enter Rectangle Width: ");
        rectangle.width = sc.nextDouble();
        rectangle.displayDetails();
        sc.close();
    }
}
