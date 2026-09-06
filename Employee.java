public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    // Default constructor
    public Employee() {
    }

    // 3-parameter constructor (backward compatibility)
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = 0;
    }

    // 4-parameter constructor (Encapsulation & OOP modeling)
    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // Getters and Setters with validation (Encapsulation)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID. Must be positive.");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name. Name cannot be empty.");
        } else {
            this.name = name.trim();
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            System.out.println("Invalid salary. Must be greater than zero.");
        } else {
            this.salary = salary;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Invalid age. Must be greater than zero.");
        } else {
            this.age = age;
        }
    }

    public void increaseSalary(double percentage) {
        if (percentage > 0) {
            this.salary = this.salary + (this.salary * percentage / 100);
        }
    }

    @Override
    public String toString() {
        return String.format("Employee [ID=%d, Name=%-12s, Salary=₹%.0f, Age=%d]", id, name, salary, age);
    }
}
