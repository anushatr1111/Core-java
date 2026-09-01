abstract class Payment {
    abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class UPIPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CashPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Cash");
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new UPIPayment();
        Payment p3 = new CashPayment();
        
        p1.pay(500);
        p2.pay(500);
        p3.pay(500);
    }
}