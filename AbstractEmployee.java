public abstract class AbstractEmployee {
    private int id;
    protected String name;
    protected double salary;

    public AbstractEmployee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}
class Developer extends AbstractEmployee {
    private String programmingLanguage;

    public Developer(int id, String name, double salary, String programmingLanguage) {
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    double calculateBonus() {
        return salary * 0.1;
    }
}
class Manager extends AbstractEmployee {
    private int teamSize;

    public Manager(int id, String name, double salary, int teamSize) {
        super(id, name, salary);
        this.teamSize = teamSize;
    }

    @Override
    double calculateBonus() {
        return salary * 0.2;
    }
    public static void main(String[] args) {
        AbstractEmployee e1 = new Developer(1, "Alice", 50000, "Java");
        AbstractEmployee e2 = new Manager(2, "Bob", 60000, 5);
        
        System.out.println("Bonus for " + e1.name + ": " + e1.calculateBonus());
        System.out.println("Bonus for " + e2.name + ": " + e2.calculateBonus());
    }
}