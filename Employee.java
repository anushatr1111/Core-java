import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;
    private LocalDate joiningDate;

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

    // 3-parameter constructor with joiningDate (Day 36 Boss Challenge)
    public Employee(int id, String name, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
    }

    // 4-parameter constructor (Encapsulation & OOP modeling)
    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // 4-parameter constructor (id, name, age, salary order)
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // 5-parameter full constructor
    public Employee(int id, String name, double salary, int age, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.joiningDate = joiningDate;
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

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getFormattedJoiningDate() {
        if (joiningDate == null) {
            return "N/A";
        }
        return joiningDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void increaseSalary(double percentage) {
        if (percentage > 0) {
            this.salary = this.salary + (this.salary * percentage / 100);
        }
    }

    @Override
    public String toString() {
        if (joiningDate != null && salary == 0 && age == 0) {
            return String.format("%d - %s - Joined: %s", id, name, getFormattedJoiningDate());
        }
        return String.format("Employee [ID=%d, Name=%-12s, Salary=₹%.0f, Age=%d]", id, name, salary, age);
    }
}
