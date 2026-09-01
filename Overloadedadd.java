import java.util.*;
public class Overloadedadd {
    int add(int a, int b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        double d, e;
        System.out.print("Enter first integer: ");
        a = sc.nextInt();
        System.out.print("Enter second integer: ");
        b = sc.nextInt();
        System.out.print("Enter third integer: ");
        c = sc.nextInt();
        System.out.print("Enter first double: ");
        d = sc.nextDouble();
        System.out.print("Enter second double: ");
        e = sc.nextDouble();
        Overloadedadd obj = new Overloadedadd();
        System.out.println("Sum of 2 integers: " + obj.add(a, b));
        System.out.println("Sum of 3 integers: " + obj.add(a, b, c));
        System.out.println("Sum of 2 doubles: " + obj.add(d, e));
    }
}
