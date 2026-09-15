"""
Curated Data for Modules 1 through 5:
- Module 1: Basic Syntax, Data Types & Conditionals
- Module 2: Iteration, Control Structures & Digit Extraction
- Module 3: Functions, Methods & Method Overloading
- Module 4: Object-Oriented Programming (OOP) Fundamentals
- Module 5: Inheritance, Polymorphism & Abstraction
"""

from .svg_helpers import (
    draw_decision_flowchart, draw_loop_flowchart, draw_sequential_flowchart,
    draw_state_machine_flowchart, draw_two_pointer_flowchart, draw_recursion_flowchart
)

MODULE_1_5_METADATA = [
    {
        "id": "mod1",
        "num": 1,
        "title": "Basic Syntax, Data Types & Conditionals",
        "desc": "Foundational Java constructs: primitive data types, relational operators, ternary logic, conditional branching (if-else, switch-case), and validation workflows."
    },
    {
        "id": "mod2",
        "num": 2,
        "title": "Iteration, Control Structures & Digit Extraction",
        "desc": "Loop constructs (while, for, do-while), accumulator patterns, sentinel-controlled loops, integer arithmetic decomposition, and iterative state tracking."
    },
    {
        "id": "mod3",
        "num": 3,
        "title": "Functions, Methods & Method Overloading",
        "desc": "Modular functional decomposition, parameter passing, return semantics, stack frames, and compile-time polymorphism via method overloading."
    },
    {
        "id": "mod4",
        "num": 4,
        "title": "Object-Oriented Programming (OOP) Fundamentals",
        "desc": "Class blueprints, object instantiation, constructor initialization, state encapsulation with private fields, domain state machines, and object arrays."
    },
    {
        "id": "mod5",
        "num": 5,
        "title": "Inheritance, Polymorphism & Abstraction",
        "desc": "IS-A relationships (`extends`), method overriding, runtime dynamic method dispatch (`super`), abstract classes vs pure interfaces, and multiple interface implementation."
    }
]

PROBLEMS_MOD1_MOD5 = [
    # ----------------- MODULE 1 -----------------
    {
        "id": "p-even-odd",
        "module_id": "mod1",
        "title": "Even or Odd Parity Determination",
        "category": "Parity / Arithmetic",
        "files": ["CheckEvenorOdd.java", "CheckEvenOrOddMethod.java", "EvenorOddMethod.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        In number theory, parity refers to the attribute of an integer being either even or odd. An integer <code>n</code> is <strong>even</strong> if it is an exact multiple of 2 (i.e., <code>n = 2k</code> for some integer <code>k</code>), and <strong>odd</strong> if it leaves a remainder of 1 or -1 when divided by 2.
        <br><br>
        In Java, parity is calculated using the remainder operator <code>%</code> (modulo). Alternatively, it can be tested at the bitwise level via <code>(n & 1) == 0</code>, checking the least significant bit (LSB), which is 0 for even numbers and 1 for odd numbers.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start",
            input_txt="Read integer 'num'",
            condition_txt="num % 2 == 0 ?",
            yes_txt="Print 'Even'",
            no_txt="Print 'Odd'",
            output_txt="Display Parity Result",
            end_txt="End"
        ),
        "code": """import java.util.Scanner;

public class CheckEvenorOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Ternary operator evaluation of parity
        String result = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println("The number is: " + result);
        sc.close();
    }
}""",
        "steps": [
            "Read an integer input from the user via <code>Scanner.nextInt()</code>.",
            "Evaluate condition <code>num % 2 == 0</code>: if true, value evaluates to 'Even'; otherwise 'Odd'.",
            "Print the computed string to the standard output console."
        ],
        "sample_input": "Enter a number: 14",
        "sample_output": "The number is: Even",
        "edge_cases": "<strong>Zero:</strong> <code>0 % 2 == 0</code>, properly identified as Even.<br><strong>Negative Numbers:</strong> In Java, <code>-3 % 2</code> evaluates to <code>-1</code>. Checking <code>num % 2 != 0</code> correctly flags all odd integers regardless of algebraic sign."
    },
    {
        "id": "p-pos-neg-zero",
        "module_id": "mod1",
        "title": "Sign Classification (Positive, Negative, Zero)",
        "category": "Conditionals / Multi-Branch",
        "files": ["CheckPostiveorNegative.java", "CountPositiveNegativeZero.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Classification of real numbers based on their position relative to the origin on the number line. A value strictly greater than 0 is <strong>positive</strong>, strictly less than 0 is <strong>negative</strong>, and equal to 0 is <strong>neutral (zero)</strong>.
        <br><br>
        Multi-branch conditional structures (<code>if-else if-else</code>) provide mutually exclusive evaluations ensuring exactly one branch executes in constant time $O(1)$.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start",
            input_txt="Read integer 'num'",
            condition_txt="num > 0 ?",
            yes_txt="Print 'Positive'",
            no_txt="Check num < 0 ?",
            output_txt="Display Classification",
            end_txt="End"
        ),
        "code": """import java.util.Scanner;

public class CheckPostiveorNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        if (num > 0) {
            System.out.println("The number is Positive.");
        } else if (num < 0) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }
        sc.close();
    }
}""",
        "steps": [
            "Input an integer <code>num</code>.",
            "First test if <code>num > 0</code>. If true, branch to Positive.",
            "Else test if <code>num < 0</code>. If true, branch to Negative.",
            "If neither condition holds, <code>num</code> is 0 by mathematical trichotomy."
        ],
        "sample_input": "Enter a number: -42",
        "sample_output": "The number is Negative.",
        "edge_cases": "<strong>Input Zero:</strong> Evaluates both guards as false and correctly lands in the catch-all <code>else</code> block.<br><strong>Boundary Extremes:</strong> Handled accurately for <code>Integer.MIN_VALUE</code> (-2147483648) and <code>Integer.MAX_VALUE</code> (2147483647)."
    },
    {
        "id": "p-largest-of-three",
        "module_id": "mod1",
        "title": "Largest Among Three Numbers",
        "category": "Relational Logic / Selection",
        "files": ["LargestofThree.java", "LargestofThreeNumbers.java", "Largest.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Finding the mathematical maximum element among three numerical inputs $a, b, c$. This problem tests compound relational logic with logical AND (<code>&&</code>) or nested comparative guards.
        <br><br>
        Using short-circuit evaluation in Java, <code>(a >= b && a >= c)</code> ensures that if the first sub-expression evaluates to false, the second is never evaluated, optimizing instruction cycles.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start",
            input_txt="Read a, b, c",
            condition_txt="a >= b && a >= c ?",
            yes_txt="'a' is Largest",
            no_txt="Check b >= c ?",
            output_txt="Print Maximum",
            end_txt="End"
        ),
        "code": """import java.util.Scanner;

public class LargestofThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (a >= b && a >= c) {
            System.out.println(a + " is the largest.");
        } else if (b >= c) {
            System.out.println(b + " is the largest.");
        } else {
            System.out.println(c + " is the largest.");
        }
        sc.close();
    }
}""",
        "steps": [
            "Accept three numerical inputs <code>a, b, c</code>.",
            "Compare <code>a</code> against both <code>b</code> and <code>c</code>.",
            "If <code>a</code> is not the maximum, compare <code>b</code> with <code>c</code>.",
            "Output the determined maximum value."
        ],
        "sample_input": "Enter three numbers: 45 89 12",
        "sample_output": "89 is the largest.",
        "edge_cases": "<strong>Identical Elements:</strong> Using <code>>=</code> instead of <code>></code> prevents errors when two or three numbers are equal (e.g., <code>10, 10, 5</code>)."
    },
    {
        "id": "p-grade-calculator",
        "module_id": "mod1",
        "title": "Academic Grade Categorization",
        "category": "Tiered Conditionals",
        "files": ["GradeCalculator.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Mapping continuous numerical percentages (0-100) into discrete ordinal grade tiers (A, B, C, D, Fail).
        <br><br>
        Structured as a sequential falling-edge comparison: because previous intervals are progressively filtered out, each check only needs a lower-bound comparison (e.g., <code>marks >= 90</code>, then <code>marks >= 80</code>).
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Read Score (0 - 100)",
            step2="Validate Range (score between 0 and 100)",
            step3="Evaluate Tier (>=90: A, >=80: B, >=70: C...)",
            step4="Print Assigned Letter Grade"
        ),
        "code": """import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student marks (0-100): ");
        int marks = sc.nextInt();
        
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid Marks! Must be 0-100.");
        } else if (marks >= 90) {
            System.out.println("Grade: A+");
        } else if (marks >= 80) {
            System.out.println("Grade: A");
        } else if (marks >= 70) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else if (marks >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: Fail");
        }
        sc.close();
    }
}""",
        "steps": [
            "Input score integer.",
            "Verify input validity <code>0 <= marks <= 100</code>.",
            "Sequentially descend through threshold brackets.",
            "Print assigned letter grade."
        ],
        "sample_input": "Enter student marks (0-100): 86",
        "sample_output": "Grade: A",
        "edge_cases": "<strong>Out of Bounds:</strong> Inputs like <code>105</code> or <code>-10</code> are intercepted by the primary validation guard."
    },
    {
        "id": "p-electricity-bill",
        "module_id": "mod1",
        "title": "Slab-Based Tariff Electricity Calculation",
        "category": "Progressive Tier Billing",
        "files": ["ElectricityBill.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Progressive tiered billing calculates cost by applying incremental rate tariffs to specific unit slabs rather than multiplying the entire consumption by a flat rate.
        <br><br>
        Standard slabs: First 100 units @ $1.5/unit, next 100 units (101-200) @ $2.5/unit, next 100 units (201-300) @ $4.0/unit, and units above 300 @ $5.0/unit.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Input Consumed Units (U)",
            step2="Compute Units in Tier 1 (1-100)",
            step3="Compute Units in Tier 2 (101-200) & Tier 3",
            step4="Sum Slabs & Display Total Cost"
        ),
        "code": """import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();
        double bill = 0;
        
        if (units <= 100) {
            bill = units * 1.5;
        } else if (units <= 200) {
            bill = (100 * 1.5) + (units - 100) * 2.5;
        } else if (units <= 300) {
            bill = (100 * 1.5) + (100 * 2.5) + (units - 200) * 4.0;
        } else {
            bill = (100 * 1.5) + (100 * 2.5) + (100 * 4.0) + (units - 300) * 5.0;
        }
        
        System.out.println("Total Electricity Bill: $" + bill);
        sc.close();
    }
}""",
        "steps": [
            "Read consumed electricity units.",
            "Determine the bracket range.",
            "Accumulate fixed slab charges for completed tiers and calculate the remainder rate for the top tier.",
            "Display calculated total."
        ],
        "sample_input": "Enter units consumed: 250",
        "sample_output": "Total Electricity Bill: $600.0",
        "edge_cases": "<strong>Zero consumption:</strong> <code>units = 0</code> correctly results in <code>$0.0</code>.<br><strong>Boundary Units:</strong> Exactly 100, 200, 300 transition seamlessly between tiers without double-counting."
    },
    {
        "id": "p-switch-calendar",
        "module_id": "mod1",
        "title": "Temporal Switch-Case Mapping (Days & Months)",
        "category": "Jump Table / Switch-Case",
        "files": ["DayOfTheWeek.java", "Monthname.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Multi-way selection mapping an integer key (1-7 or 1-12) to a string representation. The Java <code>switch</code> statement translates into a <code>tableswitch</code> or <code>lookupswitch</code> bytecode instruction, allowing fast constant-time branching.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start",
            input_txt="Input Month / Day Integer",
            condition_txt="Key in Range (1 - 7 / 12) ?",
            yes_txt="Jump to Matched Case Label",
            no_txt="Execute 'default' Branch",
            output_txt="Print Calendar Name",
            end_txt="End"
        ),
        "code": """import java.util.Scanner;

public class DayOfTheWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter day number (1-7): ");
        int day = sc.nextInt();
        
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Invalid day! Enter 1-7.");
        }
        sc.close();
    }
}""",
        "steps": [
            "Accept integer choice (1 to 7).",
            "Evaluate switch expression.",
            "Jump directly to corresponding case and print name.",
            "Default branch executes if input is out of valid range."
        ],
        "sample_input": "Enter day number (1-7): 5",
        "sample_output": "Friday",
        "edge_cases": "<strong>Fall-through Prevention:</strong> Using enhanced arrow switch (<code>-></code>) or explicit <code>break;</code> statements prevents accidental execution of successive case branches."
    },
    {
        "id": "p-login-validation",
        "module_id": "mod1",
        "title": "String Credential Authentication",
        "category": "String Comparison / Security",
        "files": ["Login.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Validating user authentication credentials against stored reference values.
        <br><br>
        <strong>Crucial Java Core Concept:</strong> In Java, Strings are reference types. Comparing Strings using <code>==</code> evaluates reference identity (memory addresses in the String pool), NOT character content. Value equality must always be performed using <code>str.equals()</code>.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start",
            input_txt="Input Username & Password",
            condition_txt="user.equals() && pass.equals() ?",
            yes_txt="Grant Access (200 OK)",
            no_txt="Deny Access (401 Error)",
            output_txt="Display Login Status",
            end_txt="End"
        ),
        "code": """import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        // Strict value comparison using .equals()
        if ("admin".equals(username) && "secure123".equals(password)) {
            System.out.println("Login Successful! Welcome.");
        } else {
            System.out.println("Access Denied: Invalid Credentials.");
        }
        sc.close();
    }
}""",
        "steps": [
            "Read username and password strings.",
            "Perform content equality comparison via <code>\"admin\".equals(username)</code> (Yoda condition to prevent <code>NullPointerException</code>).",
            "Print authentication confirmation or rejection message."
        ],
        "sample_input": "Username: admin\\nPassword: secure123",
        "sample_output": "Login Successful! Welcome.",
        "edge_cases": "<strong>Null Pointer Defense:</strong> Putting the string literal first (<code>\"admin\".equals(input)</code>) prevents crashes even if <code>input</code> is null."
    },

    # ----------------- MODULE 2 -----------------
    {
        "id": "p-sequence-iteration",
        "module_id": "mod2",
        "title": "Sequence Generation & Accumulation (1 to N)",
        "category": "Iteration / Loop Mechanics",
        "files": ["OnetoNWhile.java", "UptoN.java", "EvenNumbers.java", "Count.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1)",
        "definition": """
        Fundamental iterative progression generating sequential integers from 1 up to a positive threshold $N$.
        <br><br>
        Demonstrates the three pillars of all loops:
        1. <strong>Initialization</strong> (<code>int i = 1</code>)
        2. <strong>Termination Condition</strong> (<code>i <= N</code>)
        3. <strong>State Progression / Step</strong> (<code>i++</code> or <code>i += 2</code> for evens).
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="Initialize: i = 1, N = input",
            condition_txt="i <= N ?",
            body_txt="Print(i)",
            update_txt="i++ (Increment)",
            exit_txt="Completed Sequence"
        ),
        "code": """import java.util.Scanner;

public class OnetoNWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        int i = 1;
        while (i <= n) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        sc.close();
    }
}""",
        "steps": [
            "Input limit $N$.",
            "Initialize loop index <code>i = 1</code>.",
            "Verify guard condition <code>i <= n</code>. If true, print <code>i</code> and increment.",
            "When <code>i > n</code>, loop terminates."
        ],
        "sample_input": "Enter N: 5",
        "sample_output": "1 2 3 4 5",
        "edge_cases": "<strong>N <= 0:</strong> While loop condition is immediately false; loop body never executes (safe zero-iteration)."
    },
    {
        "id": "p-sentinel-sum",
        "module_id": "mod2",
        "title": "Sentinel-Controlled Accumulation",
        "category": "Sentinel Loops / Accumulator",
        "files": ["SumUntilZero.java", "SumEvenOdd.java", "Sum.java", "Multiply.java"],
        "time_complexity": "O(K) where K is number of entries",
        "space_complexity": "O(1)",
        "definition": """
        In many real-world input streams, the total number of inputs is unknown in advance. A <strong>sentinel value</strong> (such as 0) acts as an explicit termination signal.
        <br><br>
        The loop continuously ingests user inputs and updates an accumulator register (<code>sum += num</code>) until the sentinel value is encountered.
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="sum = 0, read first 'num'",
            condition_txt="num != 0 (Sentinel) ?",
            body_txt="sum += num",
            update_txt="Read next 'num'",
            exit_txt="Output 'sum'"
        ),
        "code": """import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num;
        
        System.out.println("Enter numbers to sum (enter 0 to stop):");
        while ((num = sc.nextInt()) != 0) {
            sum += num;
        }
        
        System.out.println("Final Accumulated Sum = " + sum);
        sc.close();
    }
}""",
        "steps": [
            "Initialize accumulator variable <code>sum = 0</code>.",
            "Read input into <code>num</code> in the while condition check.",
            "If <code>num != 0</code>, add to <code>sum</code> and repeat.",
            "Once 0 is entered, terminate loop and display final total."
        ],
        "sample_input": "10\\n25\\n-5\\n0",
        "sample_output": "Final Accumulated Sum = 30",
        "edge_cases": "<strong>Immediate Sentinel:</strong> Entering <code>0</code> on the very first prompt results in <code>sum = 0</code> without error."
    },
    {
        "id": "p-digit-extraction",
        "module_id": "mod2",
        "title": "Digit Extraction, Counting & Summation",
        "category": "Arithmetic Decomposition",
        "files": ["CountDigits.java", "CountSumDigits.java", "ReverseNumber.java"],
        "time_complexity": "O(log10 N)",
        "space_complexity": "O(1)",
        "definition": """
        Extracting the decimal digits of an integer relies on radix-10 arithmetic:
        1. <strong>Extract LSB (last digit):</strong> <code>digit = num % 10</code>
        2. <strong>Truncate LSB:</strong> <code>num = num / 10</code>
        <br><br>
        The number of iterations is proportional to the number of decimal digits: $\\lfloor \\log_{10}(N) \\rfloor + 1$.
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="count = 0, sum = 0, temp = abs(N)",
            condition_txt="temp > 0 ?",
            body_txt="digit = temp % 10; sum += digit; count++",
            update_txt="temp = temp / 10",
            exit_txt="Output count and sum"
        ),
        "code": """import java.util.Scanner;

public class CountSumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        
        int temp = Math.abs(n);
        int count = (temp == 0) ? 1 : 0;
        int sum = 0;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            count++;
            temp /= 10;
        }
        
        System.out.println("Total Digits: " + count);
        System.out.println("Sum of Digits: " + sum);
        sc.close();
    }
}""",
        "steps": [
            "Take absolute value of input <code>n</code> to handle negative values.",
            "Extract rightmost digit via <code>temp % 10</code>.",
            "Add extracted digit to <code>sum</code> and increment <code>count</code>.",
            "Integer-divide <code>temp</code> by 10 to shift digits right.",
            "Repeat until <code>temp == 0</code>."
        ],
        "sample_input": "Enter an integer: 54321",
        "sample_output": "Total Digits: 5\\nSum of Digits: 15",
        "edge_cases": "<strong>Input 0:</strong> Mathematically has 1 digit with sum 0. The ternary operator <code>(temp == 0) ? 1 : 0</code> gracefully prevents reporting 0 digits."
    },
    {
        "id": "p-number-reversal",
        "module_id": "mod2",
        "title": "Integer Reversal via Horner's Accumulator",
        "category": "Arithmetic Transformations",
        "files": ["ReverseNumber.java"],
        "time_complexity": "O(log10 N)",
        "space_complexity": "O(1)",
        "definition": """
        Reversing an integer mathematically without converting it to a string. Uses an accumulator initialized to 0. In each step, the existing reversed value is multiplied by 10 (shifting left) and the extracted digit is added:
        $$\\text{rev} = (\\text{rev} \\times 10) + (n \\% 10)$$
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="rev = 0, temp = num",
            condition_txt="temp != 0 ?",
            body_txt="rev = (rev * 10) + (temp % 10)",
            update_txt="temp = temp / 10",
            exit_txt="Return 'rev'"
        ),
        "code": """import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = (rev * 10) + digit;
            num /= 10;
        }
        
        System.out.println("Reversed Number = " + rev);
        sc.close();
    }
}""",
        "steps": [
            "Initialize <code>rev = 0</code>.",
            "Extract last digit: <code>digit = num % 10</code>.",
            "Shift previous reversed digits left by multiplying by 10 and add the current digit.",
            "Divide <code>num</code> by 10.",
            "Terminate when <code>num == 0</code>."
        ],
        "sample_input": "Enter number: 12345",
        "sample_output": "Reversed Number = 54321",
        "edge_cases": "<strong>Trailing Zeroes:</strong> An input like <code>1200</code> will output <code>21</code> (numerical value, since leading zeros are dropped in mathematical integers)."
    },
    {
        "id": "p-number-guessing",
        "module_id": "mod2",
        "title": "CLI Binary Search Number Guessing Game",
        "category": "Interactive Loops / Randomization",
        "files": ["NumberGuessing.java"],
        "time_complexity": "O(log N) optimal attempts",
        "space_complexity": "O(1)",
        "definition": """
        An interactive feedback game demonstrating loop control flow and conditional narrowing. The computer generates a pseudorandom integer $R \\in [1, 100]$. With each user guess, feedback guides the player:
        - Guess < Target: "Too Low!"
        - Guess > Target: "Too High!"
        - Guess == Target: "Correct! Game Won."
        <br><br>
        Using optimal binary search strategy, the secret number can always be discovered in $\\lceil \\log_2(100) \\rceil = 7$ attempts.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Generate Target R",
            input_txt="User enters guess 'G'",
            condition_txt="G == R ?",
            yes_txt="Win! Display attempts",
            no_txt="Give 'Too High' / 'Too Low' hint",
            output_txt="Prompt next guess",
            end_txt="Session Exit"
        ),
        "code": """import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int target = rand.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int guess;
        
        System.out.println("I have chosen a number between 1 and 100. Guess it!");
        do {
            System.out.print("Your guess: ");
            guess = sc.nextInt();
            attempts++;
            
            if (guess > target) {
                System.out.println("Too High! Try again.");
            } else if (guess < target) {
                System.out.println("Too Low! Try again.");
            } else {
                System.out.println("Bravo! You guessed it in " + attempts + " attempts.");
            }
        } while (guess != target);
        
        sc.close();
    }
}""",
        "steps": [
            "Generate random target integer in range [1, 100].",
            "Execute <code>do-while</code> loop, guaranteeing at least one prompt.",
            "Compare user guess against target.",
            "Display directional guidance until guess matches target."
        ],
        "sample_input": "Your guess: 50 -> Too Low!\\nYour guess: 75 -> Too High!\\nYour guess: 62 -> Bravo!",
        "sample_output": "Bravo! You guessed it in 3 attempts.",
        "edge_cases": "<strong>do-while vs while:</strong> A <code>do-while</code> loop ensures the guess prompt executes before evaluating the condition, guaranteeing the first guess is read."
    },

    # ----------------- MODULE 3 -----------------
    {
        "id": "p-methods-calculator",
        "module_id": "mod3",
        "title": "Modular Functional Calculator",
        "category": "Methods & Modular Decomposition",
        "files": ["CalculatorUsingMethod.java", "CalculatorUsingMethods.java", "Calculator.java", "SquareofaNumber.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Decomposition breaks a complex program into small, independent, reusable functions. Each method adheres to the <strong>Single Responsibility Principle (SRP)</strong>:
        - <code>add(a, b)</code>
        - <code>subtract(a, b)</code>
        - <code>multiply(a, b)</code>
        - <code>divide(a, b)</code>
        <br><br>
        Methods are executed inside isolated stack frames allocated upon invocation and deallocated upon return.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Input Operands (a, b) & Operator",
            step2="Invoke Target Method add/sub/mul/div",
            step3="Allocate Method Stack Frame & Compute",
            step4="Return Value & Print Result"
        ),
        "code": """public class CalculatorUsingMethod {
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        double x = 20, y = 4;
        System.out.println("Add: " + add(x, y));
        System.out.println("Sub: " + subtract(x, y));
        System.out.println("Mul: " + multiply(x, y));
        System.out.println("Div: " + divide(x, y));
    }
}""",
        "steps": [
            "Define modular methods with <code>public static</code> modifiers.",
            "Pass parameters by value onto the call stack.",
            "Perform arithmetic computation inside the method body.",
            "Return the computed result back to the caller frame."
        ],
        "sample_input": "Operands: 20, 4",
        "sample_output": "Add: 24.0\\nSub: 16.0\\nMul: 80.0\\nDiv: 5.0",
        "edge_cases": "<strong>Division by Zero:</strong> Guarded using <code>if (b == 0)</code> returning <code>Double.NaN</code> to prevent illegal arithmetic."
    },
    {
        "id": "p-method-overloading",
        "module_id": "mod3",
        "title": "Compile-Time Polymorphism (Method Overloading)",
        "category": "Polymorphism / Signatures",
        "files": ["Overloadedadd.java", "Overloadedarea.java", "greet.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        Method overloading allows a class to define multiple methods with the exact same name, provided their parameter lists differ in:
        1. <strong>Number of parameters</strong> (e.g., <code>add(int, int)</code> vs <code>add(int, int, int)</code>)
        2. <strong>Data types of parameters</strong> (e.g., <code>add(int, int)</code> vs <code>add(double, double)</code>)
        3. <strong>Sequence of parameter types</strong>.
        <br><br>
        <strong>Note:</strong> Overloading is resolved strictly at compile time based on parameter types. Varying the return type alone does NOT constitute a valid overload.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Compiler Inspects Call",
            input_txt="e.g. area(radius) vs area(l, b)",
            condition_txt="Single or Dual Parameter?",
            yes_txt="Bind to area(double radius)",
            no_txt="Bind to area(double l, double b)",
            output_txt="Static Dispatch Resolved",
            end_txt="Execute Target Bytecode"
        ),
        "code": """public class Overloadedarea {
    // Circle Area: single argument
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }
    
    // Rectangle Area: dual arguments
    public static double area(double length, double width) {
        return length * width;
    }
    
    // Triangle Area: three arguments (base, height, shape flag)
    public static double area(double base, double height, boolean isTriangle) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        System.out.printf("Circle Area (r=5): %.2f\\n", area(5.0));
        System.out.printf("Rectangle Area (4x6): %.2f\\n", area(4.0, 6.0));
        System.out.printf("Triangle Area (b=3, h=8): %.2f\\n", area(3.0, 8.0, true));
    }
}""",
        "steps": [
            "Define overloaded methods with different signatures.",
            "Compiler inspects argument types at the call site.",
            "Directly binds call to appropriate method signature in the generated bytecode."
        ],
        "sample_input": "Calls: area(5.0), area(4.0, 6.0)",
        "sample_output": "Circle Area (r=5): 78.54\\nRectangle Area (4x6): 24.00\\nTriangle Area (b=3, h=8): 12.00",
        "edge_cases": "<strong>Type Promotion:</strong> If an exact match is absent, Java automatically promotes primitives (e.g. <code>byte -> short -> int -> long -> float -> double</code>)."
    },

    # ----------------- MODULE 4 -----------------
    {
        "id": "p-oop-encapsulation",
        "module_id": "mod4",
        "title": "Class Blueprints & State Encapsulation",
        "category": "OOP Core / Encapsulation",
        "files": ["CreateaCarClass.java", "CreateaStudentClass.java", "RectangleClass.java", "ProductClass.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1) per object",
        "definition": """
        <strong>Encapsulation</strong> bundles state (instance variables) and behavior (methods) together into a single unit (class), while hiding internal representations using access modifiers.
        <br><br>
        Fields are marked <code>private</code> to prevent unauthorized external mutation. Controlled read/write access is mediated via public getters and setters with internal validation invariants.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Define Class with Private Attributes",
            step2="Parameterized Constructor Initializer",
            step3="Public Methods / Getters & Setters",
            step4="Instantiate Object with 'new' Keyword"
        ),
        "code": """public class CreateaStudentClass {
    static class Student {
        private int id;
        private String name;
        private double marks;

        public Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.setMarks(marks);
        }

        public void setMarks(double marks) {
            if (marks >= 0 && marks <= 100) {
                this.marks = marks;
            } else {
                System.out.println("Invalid marks!");
            }
        }

        public void display() {
            System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 92.5);
        Student s2 = new Student(102, "Bob", 78.0);
        s1.display();
        s2.display();
    }
}""",
        "steps": [
            "Declare private member variables <code>id, name, marks</code>.",
            "Constructor uses <code>this</code> keyword to disambiguate parameter names from field names.",
            "Setter validates marks are within valid range [0, 100].",
            "Instantiate objects in heap memory using <code>new Student(...)</code>."
        ],
        "sample_input": "Students: (101, Alice, 92.5), (102, Bob, 78.0)",
        "sample_output": "ID: 101 | Name: Alice | Marks: 92.5\\nID: 102 | Name: Bob | Marks: 78.0",
        "edge_cases": "<strong>Shadowing Protection:</strong> Forgetting <code>this.name = name</code> results in local parameter self-assignment, leaving instance fields at default values (null/0)."
    },
    {
        "id": "p-bank-account",
        "module_id": "mod4",
        "title": "Bank Account Transaction State Machine",
        "category": "OOP Domain Modeling",
        "files": ["BankAccountClass.java", "BankAccountValidation.java", "SecureBankAccount.java", "BankingSystem.java"],
        "time_complexity": "O(1) per transaction",
        "space_complexity": "O(1)",
        "definition": """
        A canonical OOP domain modeling problem demonstrating business logic integrity. The account encapsulates <code>accountNumber</code>, <code>accountHolder</code>, and <code>balance</code>.
        <br><br>
        <strong>Business Invariants:</strong>
        - Deposits must be strictly positive ($amount > 0$).
        - Withdrawals must be positive ($amount > 0$) AND cannot exceed available funds ($amount \\le balance$).
        """,
        "flowchart": draw_state_machine_flowchart(
            system_name="Bank Account Workflow",
            actions=["1. Deposit", "2. Withdraw", "3. Check Balance", "4. Exit"]
        ),
        "code": """public class BankAccountClass {
    static class BankAccount {
        private String accNumber;
        private String holderName;
        private double balance;

        public BankAccount(String accNumber, String holderName, double initialBalance) {
            this.accNumber = accNumber;
            this.holderName = holderName;
            this.balance = Math.max(0, initialBalance);
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient funds! Balance: $" + balance);
            } else {
                balance -= amount;
                System.out.println("Withdrew $" + amount + ". Remaining Balance: $" + balance);
            }
        }

        public double getBalance() { return balance; }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-9081", "John Doe", 500.0);
        acc.deposit(200.0);
        acc.withdraw(150.0);
        acc.withdraw(800.0); // Should be rejected
    }
}""",
        "steps": [
            "Initialize account with initial deposit.",
            "Execute deposit method, validating $amount > 0$.",
            "Execute withdrawal, verifying sufficient balance before deducting funds.",
            "Reject overdraft attempts and preserve state integrity."
        ],
        "sample_input": "Deposit 200 -> Withdraw 150 -> Withdraw 800",
        "sample_output": "Deposited $200.0. New Balance: $700.0\\nWithdrew $150.0. Remaining Balance: $550.0\\nInsufficient funds! Balance: $550.0",
        "edge_cases": "<strong>Overdraft Prevention:</strong> Attempting to withdraw $800 with only $550 balance correctly triggers rejection without modifying state."
    },
    {
        "id": "p-atm-system",
        "module_id": "mod4",
        "title": "Interactive ATM Console System",
        "category": "Interactive OOP Systems",
        "files": ["ATM.java", "ATMmenu.java", "ATMSystem.java"],
        "time_complexity": "O(1) per operation",
        "space_complexity": "O(1)",
        "definition": """
        An ATM terminal state machine coordinating user authentication, account balance inquiry, cash deposits, and withdrawals.
        <br><br>
        Separates view/menu logic from the underlying model (account business logic), providing an interactive menu loop that continues until the user explicitly logs out.
        """,
        "flowchart": draw_state_machine_flowchart(
            system_name="ATM System Controller",
            actions=["1. Check Balance", "2. Deposit Cash", "3. Withdraw Cash", "4. Exit"]
        ),
        "code": """import java.util.Scanner;

public class ATMmenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000.0;
        int choice;

        do {
            System.out.println("\\n=== ATM MENU ===");
            System.out.println("1. Check Balance\\n2. Deposit\\n3. Withdraw\\n4. Exit");
            System.out.print("Select choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Current Balance: $" + balance);
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    if (dep > 0) { balance += dep; System.out.println("Success! New Balance: $" + balance); }
                    else { System.out.println("Invalid amount."); }
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double wth = sc.nextDouble();
                    if (wth > 0 && wth <= balance) { balance -= wth; System.out.println("Cash Dispensed. Balance: $" + balance); }
                    else { System.out.println("Insufficient funds or invalid amount."); }
                }
                case 4 -> System.out.println("Thank you for banking with us. Goodbye!");
                default -> System.out.println("Invalid selection!");
            }
        } while (choice != 4);
        sc.close();
    }
}""",
        "steps": [
            "Initialize starting balance.",
            "Display 4-option CLI menu in a <code>do-while</code> loop.",
            "Execute selected financial operation.",
            "Loop until choice 4 (Exit) is entered."
        ],
        "sample_input": "1 -> 2 (Deposit 500) -> 3 (Withdraw 200) -> 4",
        "sample_output": "Current Balance: $1000.0\\nNew Balance: $1500.0\\nCash Dispensed. Balance: $1300.0\\nGoodbye!",
        "edge_cases": "<strong>Zero/Negative Inputs:</strong> Intercepted before state mutation occurs, maintaining account ledger integrity."
    },

    # ----------------- MODULE 5 -----------------
    {
        "id": "p-inheritance-overriding",
        "module_id": "mod5",
        "title": "Inheritance & Dynamic Method Overriding",
        "category": "Inheritance / Polymorphism",
        "files": ["VehicleCar.java", "AnimalDog.java", "AnimalSounds.java", "EmployeeHierarchy.java", "MethodOverriding.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        <strong>Inheritance</strong> establishes an IS-A relationship where a subclass inherits fields and methods from a superclass using <code>extends</code>.
        <br><br>
        <strong>Method Overriding</strong> occurs when a subclass provides a specific implementation of a method already declared in its superclass. At runtime, Java employs <strong>Dynamic Method Dispatch (Virtual Method Invocation)</strong>: the JVM determines which overridden version to invoke based on the actual object instance on the heap, NOT the variable reference type.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Animal ref = new Dog()",
            input_txt="Invoke ref.makeSound()",
            condition_txt="Heap Type is Dog or Animal?",
            yes_txt="Dispatch Dog.makeSound()",
            no_txt="Dispatch Animal.makeSound()",
            output_txt="Print 'Dog Barks'",
            end_txt="Virtual Dispatch Complete"
        ),
        "code": """class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound...");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow! Meow!");
    }
}

public class AnimalSounds {
    public static void main(String[] args) {
        // Polymorphic reference: Parent type pointing to Child objects
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        
        a1.makeSound(); // Dynamically dispatched to Dog's method
        a2.makeSound(); // Dynamically dispatched to Cat's method
    }
}""",
        "steps": [
            "Define base class <code>Animal</code> with virtual method <code>makeSound()</code>.",
            "Subclasses <code>Dog</code> and <code>Cat</code> override <code>makeSound()</code>.",
            "Declare polymorphic references of type <code>Animal</code> assigned to subclass instances.",
            "At runtime, JVM inspects the vtable and invokes the subclass implementation."
        ],
        "sample_input": "Polymorphic calls: a1.makeSound(), a2.makeSound()",
        "sample_output": "Dog barks: Woof! Woof!\\nCat meows: Meow! Meow!",
        "edge_cases": "<strong>The @Override Annotation:</strong> Prevents silent bugs where an intentional override accidentally becomes an overload due to a parameter typo."
    },
    {
        "id": "p-abstract-classes",
        "module_id": "mod5",
        "title": "Abstract Classes & Template Design",
        "category": "Abstraction / Polymorphism",
        "files": ["AbstractShape.java", "AbstractAnimal.java", "AbstractEmployee.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        An <strong>abstract class</strong> cannot be instantiated directly (using <code>new</code>) and serves as a common template for subclasses.
        <br><br>
        It can contain both:
        - <strong>Abstract methods</strong> (without a body), which subclasses <em>must</em> implement.
        - <strong>Concrete methods</strong> (with a full body) providing shared default behavior.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Declare abstract class Shape",
            step2="Declare abstract method calculateArea()",
            step3="Subclasses Circle / Rectangle provide implementation",
            step4="Instantiate via Subclass & Call Method"
        ),
        "code": """abstract class Shape {
    String color;
    public Shape(String color) { this.color = color; }
    
    // Abstract method: must be implemented by non-abstract children
    abstract double calculateArea();
    
    // Concrete method: shared common logic
    public void displayColor() {
        System.out.println("Shape Color: " + color);
    }
}

class Circle extends Shape {
    double radius;
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    double calculateArea() { return Math.PI * radius * radius; }
}

public class AbstractShape {
    public static void main(String[] args) {
        Shape c = new Circle("Crimson", 7.0);
        c.displayColor();
        System.out.printf("Area: %.2f\\n", c.calculateArea());
    }
}""",
        "steps": [
            "Define abstract base class <code>Shape</code> with constructor and abstract method.",
            "Subclass calls <code>super(color)</code> to initialize base fields.",
            "Subclass provides concrete mathematical formula for <code>calculateArea()</code>.",
            "Polymorphic execution via base class reference."
        ],
        "sample_input": "Circle with color='Crimson', radius=7.0",
        "sample_output": "Shape Color: Crimson\\nArea: 153.94",
        "edge_cases": "<strong>Direct Instantiation Prohibition:</strong> <code>new Shape()</code> fails at compile time, enforcing design contracts."
    },
    {
        "id": "p-interfaces-payment",
        "module_id": "mod5",
        "title": "Interfaces & Multiple Interface Implementation",
        "category": "Interfaces / Contracts",
        "files": ["CreateaPaymentInterface.java", "PaymentSystem.java", "MultipleInterfaces.java", "Shape.java"],
        "time_complexity": "O(1)",
        "space_complexity": "O(1)",
        "definition": """
        An <strong>interface</strong> is a formal contract specifying <em>what</em> an implementing class must do without dictating <em>how</em>.
        <br><br>
        Unlike classes, which only support single inheritance, a Java class can implement <strong>multiple interfaces</strong> (<code>class C implements A, B</code>), completely avoiding the C++ diamond problem because interfaces don't contain mutable instance state.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Define PaymentMethod interface",
            step2="Declare pay(double amount) contract",
            step3="CreditCard & PayPal implement contract",
            step4="Execute Payment Polymorphically"
        ),
        "code": """interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    public CreditCardPayment(String cardNumber) { this.cardNumber = cardNumber; }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount + " for card: " + cardNumber);
    }
}

class UPIPayment implements PaymentMethod {
    private String upiId;
    public UPIPayment(String upiId) { this.upiId = upiId; }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount + " to ID: " + upiId);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        PaymentMethod p1 = new CreditCardPayment("4111-XXXX-XXXX-1234");
        PaymentMethod p2 = new UPIPayment("user@okbank");
        
        p1.processPayment(150.0);
        p2.processPayment(75.50);
    }
}""",
        "steps": [
            "Declare interface <code>PaymentMethod</code> with method signature <code>processPayment</code>.",
            "Implement classes <code>CreditCardPayment</code> and <code>UPIPayment</code>.",
            "Each class encapsulates its own provider attributes and logic.",
            "Caller processes payments uniformly through the interface."
        ],
        "sample_input": "CreditCard: 150.0, UPI: 75.50",
        "sample_output": "Processing Credit Card payment of $150.0 for card: 4111-XXXX-XXXX-1234\\nProcessing UPI payment of $75.5 to ID: user@okbank",
        "edge_cases": "<strong>Loose Coupling:</strong> New payment methods (e.g., Crypto, ApplePay) can be added without modifying existing checkout code."
    }
]
