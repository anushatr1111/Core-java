import java.util.*;
public class ProductStockManagement {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public ProductStockManagement(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Invalid price");
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Invalid quantity");
        } else {
            this.quantity = quantity;
        }
    }
    public void addStock(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        } else {
            System.out.println("Invalid stock amount");
        }
    }

    public void removeStock(int amount) {
        if (amount > 0 && amount <= this.quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("Invalid stock amount");
        }
    }
}
