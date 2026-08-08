import java.util.Scanner;
public class Billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Burger       ₹150");
        System.out.println("2. Pizza        ₹250");
        System.out.println("3. Pasta        ₹200");
        System.out.println("4. Sandwich     ₹120");
        System.out.println("5.Coffee       ₹80");
        System.out.println("1 → Dine In\r\n" +
                        "2 → Take Away\r\n" + 
                        "3 → Home Delivery\r\n" + 
                        "4 → Drive Thru\r\n" );
        System.out.println("6. Exit");
        System.out.print("Choose an item: ");
        int choice = sc.nextInt();
        int quantity;
        double price = 0;
        switch (choice) {
            case 1:
                price = 150;
                break;
            case 2:
                price = 250;
                break;
            case 3:
                price = 200;
                break;
            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
                
        }
        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();
        double total = price * quantity;
        System.out.printf("Total cost: ₹%.2f%n", total);
        sc.close();
    }
}
