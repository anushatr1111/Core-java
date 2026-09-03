public interface CreateaPaymentInterface {
    void pay(double amount);
}
class UPIPayment implements CreateaPaymentInterface {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
class CreditCardPayment implements CreateaPaymentInterface {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}
class CashPayment implements CreateaPaymentInterface {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " in Cash");
    }
    public static void main(String[] args) {
        CreateaPaymentInterface p1 = new UPIPayment();
        CreateaPaymentInterface p2 = new CreditCardPayment();
        CreateaPaymentInterface p3 = new CashPayment();
        
        p1.pay(500);
        p2.pay(500);
        p3.pay(500);
    }
}