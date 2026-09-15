"""
Curated Data for Modules 11 through 17:
- Module 11: Geometric CLI Pattern Printing
- Module 12: Exception Handling & Robust System Architecture
- Module 13: Collections Framework (List, Set, Map)
- Module 14: Object Sorting, Comparable & Comparator
- Module 15: Java Generics Deep Dive
- Module 16: Java File Handling & Persistent I/O
- Module 17: Modern Date & Time API (java.time) & Multithreading
"""

from .svg_helpers import (
    draw_decision_flowchart, draw_loop_flowchart, draw_sequential_flowchart,
    draw_state_machine_flowchart, draw_two_pointer_flowchart, draw_recursion_flowchart
)

MODULE_11_17_METADATA = [
    {
        "id": "mod11",
        "num": 11,
        "title": "Geometric CLI Pattern Printing",
        "desc": "Nested loop coordinate geometry, row-column mapping, leading whitespace indentation formulas, and CLI shape rendering."
    },
    {
        "id": "mod12",
        "num": 12,
        "title": "Exception Handling & Robust System Architecture",
        "desc": "Throwable hierarchy, Checked vs Unchecked exceptions, try-catch-finally mechanics, resource cleanup, and domain-specific custom exception classes."
    },
    {
        "id": "mod13",
        "num": 13,
        "title": "Collections Framework (List, Set, Map)",
        "desc": "Dynamic resizable arrays (ArrayList), hashing-based sets with duplicate rejection (HashSet), associative key-value lookup tables (HashMap), and the Student Management System."
    },
    {
        "id": "mod14",
        "num": 14,
        "title": "Object Sorting, Comparable & Comparator",
        "desc": "Natural ordering with java.lang.Comparable (compareTo), flexible multi-attribute sorting strategies via java.util.Comparator, and the Employee Sorting System."
    },
    {
        "id": "mod15",
        "num": 15,
        "title": "Java Generics Deep Dive",
        "desc": "Parameterized types (<T>), compile-time type safety, erasure of casting boilerplate, generic methods, and coordinated multi-collection architecture."
    },
    {
        "id": "mod16",
        "num": 16,
        "title": "Java File Handling & Persistent I/O",
        "desc": "Disk I/O streams, File existence checks, character streams (FileWriter, FileReader), buffering with BufferedReader, append modes, and file-persisted databases."
    },
    {
        "id": "mod17",
        "num": 17,
        "title": "Modern Date & Time API (java.time) & Multithreading",
        "desc": "Immutable temporal classes (LocalDate, Period, ChronoUnit), custom formatting (DateTimeFormatter), thread lifecycle concurrency (Thread, Runnable), and the Employee Leave Management System."
    }
]

PROBLEMS_MOD11_MOD17 = [
    # ----------------- MODULE 11 -----------------
    {
        "id": "p-cli-patterns",
        "module_id": "mod11",
        "title": "Geometric CLI Pattern Printing",
        "category": "Nested Loops / Coordinate Geometry",
        "files": ["SquarePattern.java", "IncreasingTriangle.java", "NumberTriangle.java", "ReverseTriangle.java", "NumberPyramid.java"],
        "time_complexity": "O(N^2)",
        "space_complexity": "O(1)",
        "definition": """
        CLI geometric patterns build mental models for nested coordinate systems:
        - <strong>Outer Loop (i):</strong> Governs the vertical row axis ($1 \\le i \\le N$).
        - <strong>Inner Spaces Loop (s):</strong> Formulates horizontal indentation ($N - i$ leading spaces for centered pyramids).
        - <strong>Inner Content Loop (j):</strong> Prints symbols or numbers on the active row ($1 \\le j \\le 2i - 1$ for pyramids).
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="Outer Loop: row i = 1 to N",
            condition_txt="i <= N ?",
            body_txt="Print leading spaces (N-i) -> Print stars/numbers -> Newline",
            update_txt="i++",
            exit_txt="Pattern Complete"
        ),
        "code": """public class NumberPyramid {
    public static void printPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // Print leading spaces for alignment
            for (int s = 1; s <= n - i; s++) {
                System.out.print(" ");
            }
            // Print ascending numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPyramid(5);
    }
}""",
        "steps": [
            "Outer loop runs from row 1 up to $N$.",
            "Inner loop prints $(N - i)$ spaces to center the current row.",
            "Second inner loop prints numbers $1$ to $i$ separated by spaces.",
            "Print newline character at the end of each row."
        ],
        "sample_input": "n = 5",
        "sample_output": "    1 \\n   1 2 \\n  1 2 3 \\n 1 2 3 4 \\n1 2 3 4 5 ",
        "edge_cases": "<strong>n = 1:</strong> Outputs a single centered value without misplaced leading or trailing spaces."
    },

    # ----------------- MODULE 12 -----------------
    {
        "id": "p-exception-fundamentals",
        "module_id": "mod12",
        "title": "Exception Handling Mechanics (try-catch-finally)",
        "category": "Runtime Safety / Exceptions",
        "files": ["DivisionException.java", "ArrayException.java", "MultipleExceptions.java", "CustomException.java", "BankAccountValidationException.java"],
        "time_complexity": "O(1) regular flow",
        "space_complexity": "O(1)",
        "definition": """
        Java divides exceptions into two main branches under <code>java.lang.Throwable</code>:
        1. <strong>Checked Exceptions:</strong> Subclasses of <code>Exception</code> (excluding <code>RuntimeException</code>). Must be either caught in a <code>try-catch</code> or declared in a <code>throws</code> clause (e.g. <code>IOException</code>, <code>SQLException</code>).
        2. <strong>Unchecked Exceptions:</strong> Subclasses of <code>RuntimeException</code>. Indicate programming or algorithmic logic bugs (e.g. <code>ArithmeticException</code>, <code>ArrayIndexOutOfBoundsException</code>, <code>NullPointerException</code>).
        <br><br>
        The <code>finally</code> block is guaranteed to execute regardless of whether an exception is thrown or caught, making it the standard location for resource cleanup.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Enter try { ... } block",
            input_txt="Execute risky statement (e.g. a / b)",
            condition_txt="Exception thrown?",
            yes_txt="Match catch(Exception e) block",
            no_txt="Proceed to normal continuation",
            output_txt="Always execute finally { ... }",
            end_txt="End"
        ),
        "code": """public class DivisionException {
    public static void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Caught Exception: Division by zero is undefined! " + e.getMessage());
        } finally {
            System.out.println("Cleanup: Execution completed successfully.");
        }
    }

    public static void main(String[] args) {
        divide(10, 2);
        divide(10, 0); // Gracefully caught without process crash
    }
}""",
        "steps": [
            "Encapsulate risky operations inside a <code>try</code> block.",
            "If an arithmetic error occurs, runtime creates an <code>ArithmeticException</code> object.",
            "Execution jumps directly to the matching <code>catch</code> block, preventing JVM termination.",
            "The <code>finally</code> block executes in all scenarios."
        ],
        "sample_input": "divide(10, 0)",
        "sample_output": "Caught Exception: Division by zero is undefined! / by zero\\nCleanup: Execution completed successfully.",
        "edge_cases": "<strong>Catch Order:</strong> Subclass exceptions (e.g. <code>ArithmeticException</code>) must precede superclass exceptions (e.g. <code>Exception</code>); otherwise the code will fail to compile with an 'unreachable catch block' error."
    },
    {
        "id": "p-atm-exception-system",
        "module_id": "mod12",
        "title": "Boss Challenge: Enterprise ATM Exception System",
        "category": "Custom Exception Architecture",
        "files": ["ATMExceptionSystem.java"],
        "time_complexity": "O(1) per operation",
        "space_complexity": "O(1)",
        "definition": """
        Domain-driven exception design replaces generic error messages with meaningful, strongly-typed custom exceptions:
        - <code>InvalidPinException</code> (Unsuccessful authentication)
        - <code>InsufficientBalanceException</code> (Overdraft prevention)
        - <code>InvalidAmountException</code> (Zero or negative financial operations)
        <br><br>
        Each custom exception encapsulates error codes and contextual messages, allowing calling layers to handle specific failure modes individually.
        """,
        "flowchart": draw_state_machine_flowchart(
            system_name="ATM Exception Flow",
            actions=["Auth PIN (throws InvalidPin)", "Deposit (throws InvalidAmount)", "Withdraw (throws InsufficientFunds)", "Exit Cleanly"]
        ),
        "code": """// Custom Domain Exceptions
class InvalidPinException extends Exception {
    public InvalidPinException(String msg) { super(msg); }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) { super(msg); }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) { super(msg); }
}

public class ATMExceptionSystem {
    private static double balance = 2500.0;
    private static final String CORRECT_PIN = "4321";

    public static void authenticate(String pin) throws InvalidPinException {
        if (!CORRECT_PIN.equals(pin)) {
            throw new InvalidPinException("Security Alert: Invalid PIN entered!");
        }
    }

    public static void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be > $0");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient funds! Available: $" + balance);
        balance -= amount;
        System.out.println("Withdrew $" + amount + ". Remaining Balance: $" + balance);
    }

    public static void main(String[] args) {
        try {
            authenticate("4321");
            withdraw(3000.0); // Triggers custom exception
        } catch (InvalidPinException | InsufficientBalanceException | InvalidAmountException e) {
            System.err.println("Transaction Failed: " + e.getMessage());
        }
    }
}""",
        "steps": [
            "Declare custom checked exceptions extending <code>java.lang.Exception</code>.",
            "Methods declare potential exceptions using the <code>throws</code> keyword.",
            "Business logic triggers errors explicitly using <code>throw new ...</code>.",
            "Caller intercepts domain exceptions using multi-catch blocks."
        ],
        "sample_input": "PIN='4321', withdraw(3000.0)",
        "sample_output": "Transaction Failed: Insufficient funds! Available: $2500.0",
        "edge_cases": "<strong>State Invariance:</strong> Throwing the exception before mutating <code>balance</code> ensures the account is never left in an inconsistent state."
    },

    # ----------------- MODULE 13 -----------------
    {
        "id": "p-collections-framework",
        "module_id": "mod13",
        "title": "Collections Framework: List, Set, and Map",
        "category": "Collections Core",
        "files": ["ArrayListStudentNames.java", "ArrayListNumbers.java", "RemoveDuplicatesHashSet.java", "IterateThroughaHashSet.java", "ListVsSet.java", "StudentMarksHashMap.java", "WordFrequencyHashMap.java", "EmployeeMap.java"],
        "time_complexity": "ArrayList: O(1) get, O(N) insert ; HashSet/HashMap: O(1) average lookup",
        "space_complexity": "O(N)",
        "definition": """
        The Java Collections Framework provides three primary interfaces:
        <br><br>
        1. <strong>List (<code>ArrayList</code>):</strong> An ordered, index-accessible sequence that allows duplicate elements. Backed by a dynamically resizing array with $1.5\\times$ growth factor.
        <br>
        2. <strong>Set (<code>HashSet</code>):</strong> An unordered collection of unique elements that rejects duplicates. Backed internally by a <code>HashMap</code>; relies on <code>hashCode()</code> and <code>equals()</code>.
        <br>
        3. <strong>Map (<code>HashMap</code>):</strong> Associative key-value store ($O(1)$ average get/put). Uses hash buckets with balanced red-black trees for buckets with $\ge 8$ colliding elements.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Data Elements Ingested",
            input_txt="Evaluate: Duplicates or Key-Value needed?",
            condition_txt="Uniqueness vs Ordering?",
            yes_txt="Set (Unique) / Map (Key-Val)",
            no_txt="List (Ordered, Duplicates)",
            output_txt="Allocate HashSet/Map vs ArrayList",
            end_txt="End"
        ),
        "code": """import java.util.*;

public class ListVsSet {
    public static void main(String[] args) {
        Integer[] rawData = {10, 20, 10, 30, 20, 40};

        // List preserves insertion order and allows duplicates
        List<Integer> list = new ArrayList<>(Arrays.asList(rawData));
        System.out.println("List (allows duplicates): " + list);
        System.out.println("List Size: " + list.size());

        // Set enforces uniqueness, automatically discarding duplicates
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(rawData));
        System.out.println("Set (unique, preserved order): " + set);
        System.out.println("Set Size: " + set.size());

        // Map stores key-value pairs
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 95);
        map.put("Bob", 82);
        System.out.println("Map Lookup Alice: " + map.get("Alice"));
    }
}""",
        "steps": [
            "Initialize an <code>ArrayList</code> with duplicate elements and verify all are retained.",
            "Pass the same elements to a <code>Set</code>; duplicates are automatically filtered out via hash code evaluation.",
            "Store key-value associations in a <code>HashMap</code> and retrieve values in $O(1)$ time."
        ],
        "sample_input": "rawData = [10, 20, 10, 30, 20, 40]",
        "sample_output": "List: [10, 20, 10, 30, 20, 40] (Size: 6)\\nSet: [10, 20, 30, 40] (Size: 4)\\nMap Lookup Alice: 95",
        "edge_cases": "<strong>Custom Objects in Sets/Maps:</strong> Storing custom objects requires properly overriding both <code>equals()</code> and <code>hashCode()</code> to prevent duplicate entries."
    },
    {
        "id": "p-student-management-system",
        "module_id": "mod13",
        "title": "Boss Challenge: Student Management System",
        "category": "Integrated OOP / Collections",
        "files": ["StudentManagementSystem.java", "StudentManagement.java"],
        "time_complexity": "O(1) lookup via Map, O(N) list traversal",
        "space_complexity": "O(N)",
        "definition": """
        An integrated CRUD system demonstrating enterprise collections architecture:
        - <code>ArrayList&lt;Student&gt;</code> maintains ordered student records.
        - <code>HashMap&lt;Integer, Student&gt;</code> enables instantaneous $O(1)$ lookups by student ID.
        - Custom domain exceptions (<code>StudentNotFoundException</code>, <code>DuplicateStudentException</code>) enforce business rules.
        """,
        "flowchart": draw_state_machine_flowchart(
            system_name="Student Management CLI",
            actions=["1. Add Student", "2. Display All", "3. Search by ID", "4. Delete / Exit"]
        ),
        "code": """import java.util.*;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name=" + name + ", Marks=" + marks + "]";
    }
}

public class StudentManagementSystem {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student s) {
        if (studentMap.containsKey(s.getId())) {
            System.out.println("Error: Student ID " + s.getId() + " already exists!");
            return;
        }
        studentMap.put(s.getId(), s);
        System.out.println("Student added successfully: " + s.getName());
    }

    public void searchStudent(int id) {
        Student s = studentMap.get(id);
        if (s != null) {
            System.out.println("Found: " + s);
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent(new Student(101, "David", 88.5));
        sms.addStudent(new Student(102, "Emma", 94.0));
        sms.searchStudent(101);
        sms.searchStudent(999); // Not found test
    }
}""",
        "steps": [
            "Encapsulate student fields within a <code>Student</code> class.",
            "Coordinate primary storage using <code>HashMap<Integer, Student></code>.",
            "Check for duplicates with <code>containsKey()</code> before inserting.",
            "Retrieve records by ID in $O(1)$ time."
        ],
        "sample_input": "Add ID 101, Add ID 102, Search ID 101, Search ID 999",
        "sample_output": "Student added: David\\nStudent added: Emma\\nFound: Student[ID=101, Name=David, Marks=88.5]\\nStudent with ID 999 not found!",
        "edge_cases": "<strong>Duplicate IDs:</strong> Intercepted before inserting, preventing existing student records from being silently overwritten."
    },

    # ----------------- MODULE 14 -----------------
    {
        "id": "p-comparable-comparator",
        "module_id": "mod14",
        "title": "Natural vs Custom Sorting: Comparable vs Comparator",
        "category": "Sorting / Functional Interfaces",
        "files": ["SortNumbers.java", "SortStudentNames.java", "StudentSortingwithComparable.java", "StudentSortingwithComparator.java", "EmployeeSortingSystem.java"],
        "time_complexity": "O(N log N) via TimSort",
        "space_complexity": "O(N) auxiliary space",
        "definition": """
        Java provides two distinct interfaces for ordering objects:
        <br><br>
        1. <strong><code>Comparable&lt;T&gt;</code> (Natural Ordering):</strong>
        - Implemented directly by the domain class itself via <code>int compareTo(T o)</code>.
        - Located in package <code>java.lang</code>.
        - Defines a single default sort order (e.g. by Student ID or Marks).
        <br><br>
        2. <strong><code>Comparator&lt;T&gt;</code> (Custom Strategy Ordering):</strong>
        - Implemented in external classes or lambda expressions via <code>int compare(T o1, T o2)</code>.
        - Located in package <code>java.util</code>.
        - Allows multiple independent sorting strategies on the same class (e.g. by Name, by Salary, or by Age).
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Collections.sort(list)",
            input_txt="Check: Comparator passed?",
            condition_txt="Comparator argument present?",
            yes_txt="Invoke comparator.compare(a, b)",
            no_txt="Invoke ((Comparable) a).compareTo(b)",
            output_txt="TimSort sorts elements",
            end_txt="Sorted Collection"
        ),
        "code": """import java.util.*;

class Student implements Comparable<Student> {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id; this.name = name; this.marks = marks;
    }

    // Natural ordering: Ascending by marks
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.marks, other.marks);
    }

    @Override
    public String toString() { return name + " (" + marks + ")"; }
}

public class StudentSortingwithComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Charlie", 76.5));
        list.add(new Student(2, "Alice", 92.0));
        list.add(new Student(3, "Bob", 85.0));

        // 1. Natural Sort via Comparable (by marks ascending)
        Collections.sort(list);
        System.out.println("By Marks (Comparable): " + list);

        // 2. Custom Strategy via Comparator (by name alphabetically)
        list.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("By Name (Comparator): " + list);
    }
}""",
        "steps": [
            "Implement <code>Comparable<Student></code> inside class definition for default ordering.",
            "Invoke <code>Collections.sort(list)</code> using <code>compareTo()</code>.",
            "Supply a custom lambda <code>Comparator</code> to sort by name alphabetically.",
            "Observe how both sorting strategies order the list correctly."
        ],
        "sample_input": "[Charlie: 76.5, Alice: 92.0, Bob: 85.0]",
        "sample_output": "By Marks: [Charlie (76.5), Bob (85.0), Alice (92.0)]\\nBy Name: [Alice (92.0), Bob (85.0), Charlie (76.5)]",
        "edge_cases": "<strong>Floating-Point Subtraction in compare:</strong> Never use <code>(int)(this.marks - other.marks)</code> because fractional differences (e.g. 85.4 vs 85.8) truncate to 0. Always use <code>Double.compare(a, b)</code>."
    },
    {
        "id": "p-employee-sorting-system",
        "module_id": "mod14",
        "title": "Boss Challenge: Employee Multi-Criteria Sorting",
        "category": "Complex Sorting Systems",
        "files": ["EmployeeSortingSystem.java"],
        "time_complexity": "O(N log N)",
        "space_complexity": "O(N)",
        "definition": """
        An enterprise employee ranking system providing multiple sorting strategies on demand:
        1. Sort by Salary (Descending)
        2. Sort by Name (Alphabetical)
        3. Sort by Age (Ascending)
        4. Compound Sorting (e.g. by Department, then by Salary).
        <br><br>
        Implements clean separation of concerns using <code>Comparator.comparing()</code> and <code>thenComparing()</code> chains.
        """,
        "flowchart": draw_state_machine_flowchart(
            system_name="Employee Sorting Menu",
            actions=["1. Sort by Salary", "2. Sort by Name", "3. Sort by Age", "4. Display Highest"]
        ),
        "code": """import java.util.*;

class Employee {
    int id;
    String name;
    double salary;
    int age;

    public Employee(int id, String name, double salary, int age) {
        this.id = id; this.name = name; this.salary = salary; this.age = age;
    }
    public double getSalary() { return salary; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " | $" + salary + " | Age: " + age;
    }
}

public class EmployeeSortingSystem {
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>(List.of(
            new Employee(101, "Karen", 75000, 34),
            new Employee(102, "Bob", 92000, 41),
            new Employee(103, "Alex", 60000, 26)
        ));

        System.out.println("--- Sorted by Salary (Descending) ---");
        staff.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        staff.forEach(System.out.println);

        System.out.println("\\n--- Sorted by Name Alphabetically ---");
        staff.sort(Comparator.comparing(Employee::getName));
        staff.forEach(System.out.println);
    }
}""",
        "steps": [
            "Instantiate employee objects with multiple demographic fields.",
            "Apply method references: <code>Comparator.comparingDouble(Employee::getSalary).reversed()</code>.",
            "Re-sort list alphabetically using <code>Employee::getName</code>.",
            "Output formatted employee rosters."
        ],
        "sample_input": "Employees: Karen ($75k), Bob ($92k), Alex ($60k)",
        "sample_output": "Bob | $92000.0 | Age: 41\\nKaren | $75000.0 | Age: 34\\nAlex | $60000.0 | Age: 26",
        "edge_cases": "<strong>Tied Values:</strong> Chained comparators (<code>thenComparing</code>) handle ties cleanly by falling back to a secondary criterion like employee ID."
    },

    # ----------------- MODULE 15 -----------------
    {
        "id": "p-generics-deep-dive",
        "module_id": "mod15",
        "title": "Java Generics: Generic Classes & Methods",
        "category": "Generics / Type Safety",
        "files": ["GenericBox.java", "GenericMethod.java", "GenericList.java", "GenericEmployeeManagementSystem.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Java Generics introduce <strong>parameterized types</strong>, providing compile-time type checking and eliminating explicit type casting:
        - <strong>Generic Class:</strong> <code>class Box&lt;T&gt;</code> operates uniformly on any reference type (<code>Box&lt;Integer&gt;</code>, <code>Box&lt;String&gt;</code>).
        - <strong>Generic Method:</strong> <code>public static &lt;T&gt; void printArray(T[] arr)</code> can print arrays of any object type with a single implementation.
        <br><br>
        <strong>Type Erasure:</strong> To maintain backward compatibility with older Java versions, the compiler erases type parameters at compile time and inserts appropriate casts in the bytecode.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Define Generic Container Box<T>",
            step2="Compiler enforces type safety at compile time",
            step3="Type Erasure converts <T> to Object in bytecode",
            step4="Type casts automatically handled without ClassCastException"
        ),
        "code": """public class GenericBox {
    static class Box<T> {
        private T value;
        public void set(T value) { this.value = value; }
        public T get() { return value; }
        public void display() {
            System.out.println("Box contains: " + value + " [Type: " + value.getClass().getSimpleName() + "]");
        }
    }

    public static <E> void printArray(E[] elements) {
        for (E element : elements) System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        intBox.display();

        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        strBox.display();

        String[] words = {"Java", "Generics", "Type-Safe"};
        printArray(words);
    }
}""",
        "steps": [
            "Declare type parameter <code>&lt;T&gt;</code> in class header.",
            "Instantiate specific instances <code>Box&lt;Integer&gt;</code> and <code>Box&lt;String&gt;</code>.",
            "Invoke generic method with array of strings.",
            "Compiler catches any type mismatch errors at compile time."
        ],
        "sample_input": "Box<Integer>(100), Box<String>('Hello Generics')",
        "sample_output": "Box contains: 100 [Type: Integer]\\nBox contains: Hello Generics [Type: String]\\nJava Generics Type-Safe",
        "edge_cases": "<strong>Primitive Types:</strong> Type arguments must be reference types. <code>Box&lt;int&gt;</code> is invalid; the wrapper class <code>Box&lt;Integer&gt;</code> must be used."
    },

    # ----------------- MODULE 16 -----------------
    {
        "id": "p-file-handling-io",
        "module_id": "mod16",
        "title": "File I/O: Creation, Writing, Appending & Reading",
        "category": "Persistent Storage / File Streams",
        "files": ["CreateaFile.java", "WriteStudentDetails.java", "AppendData.java", "ReadtheFile.java", "CountLinesWordsCharacters.java", "EmployeeManagementSystem.java"],
        "time_complexity": "O(F) where F is file size in bytes",
        "space_complexity": "O(1) streaming buffer",
        "definition": """
        Java handles file persistence through the <code>java.io</code> package:
        - <code>File.createNewFile()</code>: Atomically creates a new file if it does not already exist.
        - <code>FileWriter(path, appendMode)</code>: Character stream writer. When <code>appendMode = true</code>, new data is appended to the end rather than overwriting the file.
        - <code>BufferedReader(new FileReader(path))</code>: Reads character data using an internal buffer, reducing expensive disk read calls.
        <br><br>
        <strong>Try-with-Resources:</strong> Automatically closes file handles when the block exits, preventing resource leaks.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="File file = new File('records.txt')",
            step2="try (FileWriter fw = new FileWriter(file, true))",
            step3="try (BufferedReader br = new BufferedReader(...))",
            step4="Automatic stream close via Try-with-Resources"
        ),
        "code": """import java.io.*;

public class CountLinesWordsCharacters {
    public static void analyzeFile(String filename) {
        int lines = 0, words = 0, chars = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                chars += line.length();
                String[] tokens = line.trim().split("\\\\s+");
                if (!line.trim().isEmpty()) {
                    words += tokens.length;
                }
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (IOException e) {
            System.err.println("File Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        analyzeFile("notes.txt");
    }
}""",
        "steps": [
            "Open file using <code>BufferedReader</code> wrapped in a <code>try-with-resources</code> statement.",
            "Read line-by-line using <code>readLine()</code> until reaching end of file (<code>null</code>).",
            "Count lines, tokenize words via whitespace regex <code>\\\\s+</code>, and accumulate character counts.",
            "Resources are closed automatically when the try block finishes."
        ],
        "sample_input": "File content: 'Core Java\\nNotes and Handbook'",
        "sample_output": "Lines: 2\\nWords: 4\\nCharacters: 26",
        "edge_cases": "<strong>File Not Found:</strong> <code>FileNotFoundException</code> is caught cleanly without crashing the application."
    },

    # ----------------- MODULE 17 -----------------
    {
        "id": "p-date-time-api",
        "module_id": "mod17",
        "title": "Modern Date & Time API (java.time)",
        "category": "Temporal API / ChronoUnit",
        "files": ["DateInformation.java", "DateCalculator.java", "DaysBetweenDates.java", "BirthdayCalculator.java", "DateFormatter.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Introduced in Java 8, the <code>java.time</code> package provides thread-safe, immutable calendar models that replace the legacy, error-prone <code>java.util.Date</code> and <code>Calendar</code>:
        - <code>LocalDate</code>: Represents a date (year, month, day) without a time zone.
        - <code>ChronoUnit.DAYS.between(d1, d2)</code>: Calculates the exact interval in days between two dates.
        - <code>Period.between(start, end)</code>: Measures elapsed calendar duration in years, months, and days.
        - <code>DateTimeFormatter</code>: Formats and parses dates using standard patterns (e.g. <code>dd-MM-yyyy</code>).
        """,
        "flowchart": draw_sequential_flowchart(
            step1="LocalDate today = LocalDate.now()",
            step2="Date Arithmetic: today.plusDays(30), minusMonths(2)",
            step3="Interval: ChronoUnit.DAYS.between(bday, today)",
            step4="Format: today.format(DateTimeFormatter.ofPattern(...))"
        ),
        "code": """import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthdayCalculator {
    public static void calculateNextBirthday(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        LocalDate nextBday = birthDate.withYear(today.getYear());

        // If birthday has already occurred this year, roll over to next year
        if (nextBday.isBefore(today) || nextBday.isEqual(today)) {
            nextBday = nextBday.plusYears(1);
        }

        long daysRemaining = ChronoUnit.DAYS.between(today, nextBday);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");

        System.out.println("Today: " + today.format(fmt));
        System.out.println("Next Birthday: " + nextBday.format(fmt));
        System.out.println("Days Remaining: " + daysRemaining + " days");
    }

    public static void main(String[] args) {
        calculateNextBirthday(LocalDate.of(2002, 10, 24));
    }
}""",
        "steps": [
            "Parse birth date using <code>LocalDate.of(year, month, day)</code>.",
            "Adjust target year to current year using <code>withYear()</code>.",
            "If that date has already passed, add one year via <code>plusYears(1)</code>.",
            "Calculate remaining days using <code>ChronoUnit.DAYS.between()</code>."
        ],
        "sample_input": "Birth Date: 2002-10-24",
        "sample_output": "Next Birthday: Thursday, 24 October 2026\\nDays Remaining: 39 days",
        "edge_cases": "<strong>Leap Year Birthdays (Feb 29):</strong> In non-leap years, <code>LocalDate</code> automatically handles Feb 29 by resolving it to Feb 28 without throwing exceptions."
    },
    {
        "id": "p-multithreading-basics",
        "module_id": "mod17",
        "title": "Java Multithreading & Thread Lifecycle",
        "category": "Concurrency / Multi-threading",
        "files": ["MyThread.java", "PrintNumbersUsingaThread.java"],
        "time_complexity": "O(N) asynchronous execution",
        "space_complexity": "O(1) per thread stack (~1MB)",
        "definition": """
        A <strong>thread</strong> is an independent path of execution within a process. Multithreading enables concurrent execution of multiple tasks, maximizing CPU utilization.
        <br><br>
        Threads can be created by:
        1. <strong>Extending <code>Thread</code>:</strong> Override <code>public void run()</code> and invoke <code>start()</code>.
        2. <strong>Implementing <code>Runnable</code>:</strong> Preferred approach as it decouples task logic from thread management and allows extending another class.
        <br><br>
        <strong>Crucial Concept:</strong> Always call <code>thread.start()</code>, which requests the OS to allocate a new call stack. Calling <code>thread.run()</code> directly simply runs the method synchronously on the caller's existing thread!
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="t1.start() & t2.start()",
            input_txt="OS schedules threads concurrently",
            condition_txt="Thread running state?",
            yes_txt="Execute run() body",
            no_txt="Wait in Ready / Blocked state",
            output_txt="Interleaved thread output",
            end_txt="Thread Terminates"
        ),
        "code": """class PrintNumbersTask extends Thread {
    public PrintNumbersTask(String name) { super(name); }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> Value: " + i);
            try {
                Thread.sleep(100); // Pause execution for 100ms
            } catch (InterruptedException e) {
                System.err.println(getName() + " interrupted.");
            }
        }
    }
}

public class PrintNumbersUsingaThread {
    public static void main(String[] args) {
        PrintNumbersTask t1 = new PrintNumbersTask("Worker-Alpha");
        PrintNumbersTask t2 = new PrintNumbersTask("Worker-Beta");

        t1.start(); // Spawns independent call stack
        t2.start(); // Spawns independent call stack
    }
}""",
        "steps": [
            "Create a thread subclass overriding the <code>run()</code> method.",
            "Instantiate two thread worker objects.",
            "Invoke <code>start()</code> on both threads.",
            "Observe interleaved output as the OS thread scheduler alternates execution between them."
        ],
        "sample_input": "Two concurrent worker threads counting 1 to 5",
        "sample_output": "Worker-Alpha -> Value: 1\\nWorker-Beta -> Value: 1\\nWorker-Alpha -> Value: 2\\nWorker-Beta -> Value: 2 ...",
        "edge_cases": "<strong>Checked InterruptedException:</strong> <code>Thread.sleep()</code> throws <code>InterruptedException</code> if another thread interrupts it while sleeping; this exception must be caught or declared."
    },
    {
        "id": "p-employee-leave-tracker",
        "module_id": "mod17",
        "title": "Capstone Boss Challenge: Employee Leave Tracker",
        "category": "Enterprise Systems / Capstone",
        "files": ["EmployeeLeaveManagementSystem.java", "EmployeeLeaveTracker.java"],
        "time_complexity": "O(1) transactions",
        "space_complexity": "O(N) persistence",
        "definition": """
        The capstone boss challenge integrates the entire Core Java learning journey into a production-style application:
        - <strong>OOP Design:</strong> Full encapsulation with domain models (<code>Employee</code>, <code>LeaveRequest</code>).
        - <strong>Modern Date API:</strong> Uses <code>LocalDate</code> and <code>ChronoUnit.DAYS</code> for leave duration and business day calculations.
        - <strong>Custom Exceptions:</strong> <code>InvalidLeaveException</code> and <code>EmployeeNotFoundException</code> enforce business rules.
        - <strong>Collections:</strong> Uses <code>HashMap</code> for $O(1)$ employee lookups and <code>ArrayList</code> for chronological audit logs.
        - <strong>File Persistence:</strong> Saves and loads records from <code>employee_leaves.txt</code>.
        """,
        "flowchart": draw_state_machine_flowchart(
            system_name="Employee Leave System",
            actions=["1. Request Leave", "2. View Leave Balance", "3. Calculate Duration", "4. Save & Exit"]
        ),
        "code": """import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class LeaveRequest {
    String employeeId;
    LocalDate startDate;
    LocalDate endDate;

    public LeaveRequest(String empId, LocalDate start, LocalDate end) {
        this.employeeId = empId;
        this.startDate = start;
        this.endDate = end;
    }

    public long getDuration() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1; // Inclusive
    }
}

public class EmployeeLeaveTracker {
    private static Map<String, Integer> leaveBalance = new HashMap<>();

    public static void submitLeave(LeaveRequest req) throws Exception {
        if (req.startDate.isAfter(req.endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date!");
        }

        long days = req.getDuration();
        int available = leaveBalance.getOrDefault(req.employeeId, 15);

        if (days > available) {
            throw new Exception("Leave balance exceeded! Requested: " + days + ", Available: " + available);
        }

        leaveBalance.put(req.employeeId, available - (int) days);
        System.out.println("Leave approved for " + req.employeeId + " for " + days + " days. Remaining: " + (available - days));
    }

    public static void main(String[] args) {
        leaveBalance.put("EMP-001", 12);
        try {
            LeaveRequest req = new LeaveRequest("EMP-001", LocalDate.of(2026, 9, 20), LocalDate.of(2026, 9, 25));
            submitLeave(req);
        } catch (Exception e) {
            System.err.println("Leave Error: " + e.getMessage());
        }
    }
}""",
        "steps": [
            "Model leave request with employee ID and temporal boundary dates.",
            "Verify date ordering invariant: <code>startDate <= endDate</code>.",
            "Calculate duration using <code>ChronoUnit.DAYS.between()</code>.",
            "Check available leave balance in <code>HashMap</code>, update balance, and log transaction."
        ],
        "sample_input": "EMP-001: Leave from 2026-09-20 to 2026-09-25",
        "sample_output": "Leave approved for EMP-001 for 6 days. Remaining: 6",
        "edge_cases": "<strong>Inverted Date Ranges:</strong> Guard clause <code>startDate.isAfter(endDate)</code> catches invalid date ranges before deducting leave balance."
    }
]
