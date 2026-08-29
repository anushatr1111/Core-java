import java.util.*;
public class ProductClass{
    int productId;
    String productName;
    double price;
    int quantity;

    ProductClass(){
        this.productId = 0;
        this.productName = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    ProductClass(int id, String name, double price){
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.quantity = 0;
    }

    ProductClass(int id, String name, double price, int quantity){
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.quantity = quantity;
    }

    double calculateTotal(){
        return quantity * price;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Product ID: ");
        int id=sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("Enter Product Name: ");
        String name=sc.nextLine();
        System.out.println("Enter Product Price: ");
        double price=sc.nextDouble();
        System.out.println("Enter Product Quantity: ");
        int quantity=sc.nextInt();

        ProductClass product=new ProductClass(id,name,price,quantity);
        System.out.println("Product ID: "+product.productId);
        System.out.println("Product Name: "+product.productName);
        System.out.println("Product Price: "+product.price);
        System.out.println("Product Quantity: "+product.quantity);
        System.out.println("Total Price: "+product.calculateTotal());
    }
}