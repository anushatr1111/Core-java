interface Printable {
    void print();
}
interface Scannable {
    void scan();
}
class Printer implements Printable, Scannable {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }
    
    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();
        printer.scan();
    }
}
