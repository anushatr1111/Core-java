import java.util.Scanner;
public class Overloadedarea {
    int area(int side) {
        return side * side;
    }
    
    int area(int length, int width) {
        return length * width;
    }
    
    double area(double radius) {
        return Math.PI * radius * radius;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side, length, width;
        double radius;
        System.out.print("Enter side of square: ");
        side = sc.nextInt();
        System.out.print("Enter length of rectangle: ");
        length = sc.nextInt();
        System.out.print("Enter width of rectangle: ");
        width = sc.nextInt();
        System.out.print("Enter radius of circle: ");
        radius = sc.nextDouble();
        Overloadedarea obj = new Overloadedarea();
        System.out.println("Area of square: " + obj.area(side));
        System.out.println("Area of rectangle: " + obj.area(length, width));
        System.out.println("Area of circle: " + obj.area(radius));
    }
}
