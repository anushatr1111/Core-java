public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            System.out.println("Invalid salary");
        } else {
            this.salary = salary;
        }
    }

    public void increaseSalary(double percentage) {
        if (percentage > 0) {
            this.salary = this.salary + (this.salary * percentage / 100);
        }
    }
}
