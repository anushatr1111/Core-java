"""
Curated Data for Modules 6 through 10:
- Module 6: 1D Array Algorithms: Searching, Extremes & Manipulations
- Module 7: 2D Arrays & Matrix Mathematics
- Module 8: String Processing & Text Parsing Algorithms
- Module 9: Recursion & Divide-and-Conquer
- Module 10: Advanced Algorithmic Paradigms (Two Pointers & Sliding Window)
"""

from .svg_helpers import (
    draw_decision_flowchart, draw_loop_flowchart, draw_sequential_flowchart,
    draw_state_machine_flowchart, draw_two_pointer_flowchart, draw_recursion_flowchart
)

MODULE_6_10_METADATA = [
    {
        "id": "mod6",
        "num": 6,
        "title": "1D Array Algorithms: Searching, Extremes & Manipulations",
        "desc": "Contiguous memory structures, index arithmetic, linear searching, single-pass extreme tracking, two-pointer swapping, in-place element partition, and cyclic rotations."
    },
    {
        "id": "mod7",
        "num": 7,
        "title": "2D Arrays & Matrix Mathematics",
        "desc": "Row-major multidimensional grids, nested coordinate iterations, matrix algebra (addition, dot product multiplication, transposition), diagonal traversal, and cell search."
    },
    {
        "id": "mod8",
        "num": 8,
        "title": "String Processing & Text Parsing Algorithms",
        "desc": "Immutability of Java Strings, String pool internals, character tokenization, palindrome verification, anagram hashing, prefix overlap, and frequency maps."
    },
    {
        "id": "mod9",
        "num": 9,
        "title": "Recursion & Divide-and-Conquer",
        "desc": "Call stack frames, base case termination, recurrence relations, linked list recursive inversion, and combinatorial power set branch exploration."
    },
    {
        "id": "mod10",
        "num": 10,
        "title": "Advanced Algorithmic Paradigms (Two Pointers & Sliding Window)",
        "desc": "Optimizing brute force $O(N^2)$ to linear $O(N)$ using two-pointer convergence, target difference hunting, and fixed/dynamic sliding window accumulators."
    }
]

PROBLEMS_MOD6_MOD10 = [
    # ----------------- MODULE 6 -----------------
    {
        "id": "p-array-extremes-second-largest",
        "module_id": "mod6",
        "title": "Single-Pass Min, Max & Second Largest",
        "category": "Order Statistics / Arrays",
        "files": ["FindMinAndMax.java", "FindtheLargestandSmallestNumber.java", "FindtheSecondLargestNumber.java", "SecondLargest.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1)",
        "definition": """
        Finding the second largest element in an unsorted array without sorting ($O(N \\log N)$).
        <br><br>
        Using two tracker variables (<code>first</code> and <code>second</code>), we inspect each element $x$ in a single pass:
        1. If $x > \\text{first}$, the former <code>first</code> cascades down to become <code>second</code>, and <code>first</code> takes $x$.
        2. Else if $x > \\text{second}$ and $x \\neq \\text{first}$, update <code>second = x</code>.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start: arr[] of size N",
            input_txt="Initialize first=MIN, second=MIN",
            condition_txt="arr[i] > first ?",
            yes_txt="second = first ; first = arr[i]",
            no_txt="Check arr[i] > second && != first",
            output_txt="Return second largest",
            end_txt="End"
        ),
        "code": """public class FindtheSecondLargestNumber {
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) return -1;
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println("Second Largest: " + findSecondLargest(arr));
    }
}""",
        "steps": [
            "Initialize <code>first = Integer.MIN_VALUE</code> and <code>second = Integer.MIN_VALUE</code>.",
            "Iterate through each element <code>num</code> in the array.",
            "If <code>num > first</code>, update <code>second = first</code>, then <code>first = num</code>.",
            "Else if <code>num > second</code> and <code>num != first</code> (skip duplicate firsts), update <code>second = num</code>.",
            "If <code>second</code> remained untouched, return -1 (no distinct second largest)."
        ],
        "sample_input": "Array: [12, 35, 1, 10, 34, 1]",
        "sample_output": "Second Largest: 34",
        "edge_cases": "<strong>All Equal Elements:</strong> e.g., <code>[7, 7, 7]</code> correctly returns <code>-1</code> because duplicate checks prevent <code>second</code> from being set to 7."
    },
    {
        "id": "p-array-reversal-two-pointer",
        "module_id": "mod6",
        "title": "Two-Pointer In-Place Array Reversal",
        "category": "Two-Pointer / In-Place Swapping",
        "files": ["ReverseanArray.java", "ReverseArray.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1)",
        "definition": """
        Reversing an array in-place without allocating a secondary buffer ($O(1)$ auxiliary space).
        <br><br>
        Two pointers converge toward each other: <code>left</code> initialized at 0, and <code>right</code> at $N - 1$. In each step, the values at <code>left</code> and <code>right</code> are swapped, then <code>left++</code> and <code>right--</code> until they meet or cross in the middle ($\lfloor N / 2 \rfloor$ swaps).
        """,
        "flowchart": draw_two_pointer_flowchart(
            title="Array Reversal Algorithm",
            left_init="left = 0",
            right_init="right = arr.length - 1",
            condition="left < right ?",
            update_left="left++",
            update_right="right--",
            action="swap(arr[left], arr[right])"
        ),
        "code": """import java.util.Arrays;

public class ReverseanArray {
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // In-place swap using temporary variable
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverse(arr);
        System.out.println("Reversed: " + Arrays.toString(arr));
    }
}""",
        "steps": [
            "Set <code>left = 0</code> and <code>right = length - 1</code>.",
            "Verify <code>left < right</code>.",
            "Swap elements at indices <code>left</code> and <code>right</code>.",
            "Increment <code>left</code>, decrement <code>right</code>.",
            "Terminate when pointers cross."
        ],
        "sample_input": "Array: [1, 2, 3, 4, 5, 6]",
        "sample_output": "Reversed: [6, 5, 4, 3, 2, 1]",
        "edge_cases": "<strong>Odd vs Even Lengths:</strong> Even lengths swap all pairs. Odd lengths leave the central median element untouched without out-of-bounds errors."
    },
    {
        "id": "p-move-zeroes-to-end",
        "module_id": "mod6",
        "title": "Move Zeroes to End (Order Preserving)",
        "category": "Two-Pointer / In-Place Partition",
        "files": ["MovesZeroesToEnd.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1)",
        "definition": """
        Given an array of integers, move all 0s to the end of the array while maintaining the relative order of all non-zero elements.
        <br><br>
        Maintains an insertion index pointer <code>nonZeroIndex = 0</code>. As we iterate through the array, whenever a non-zero value is encountered, it is placed at <code>arr[nonZeroIndex++]</code>. After exhausting the array, the remainder of the array from <code>nonZeroIndex</code> to $N - 1$ is filled with 0s.
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="nonZeroIdx = 0, i = 0",
            condition_txt="i < arr.length ?",
            body_txt="if (arr[i] != 0) arr[nonZeroIdx++] = arr[i]",
            update_txt="i++",
            exit_txt="Fill tail (nonZeroIdx to N) with 0"
        ),
        "code": """import java.util.Arrays;

public class MovesZeroesToEnd {
    public static void moveZeroes(int[] arr) {
        int nonZeroIdx = 0;
        
        // Pass 1: Compact non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIdx++] = arr[i];
            }
        }
        
        // Pass 2: Fill trailing slots with zero
        while (nonZeroIdx < arr.length) {
            arr[nonZeroIdx++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println("Modified: " + Arrays.toString(arr));
    }
}""",
        "steps": [
            "Initialize write pointer <code>nonZeroIdx = 0</code>.",
            "Traverse array: when <code>arr[i] != 0</code>, write to <code>arr[nonZeroIdx]</code> and increment <code>nonZeroIdx</code>.",
            "After all non-zeros are placed, fill indices from <code>nonZeroIdx</code> to end with zeroes."
        ],
        "sample_input": "Array: [0, 1, 0, 3, 12]",
        "sample_output": "Modified: [1, 3, 12, 0, 0]",
        "edge_cases": "<strong>No Zeroes Present:</strong> The algorithm runs linearly without rewriting unnecessary values.<br><strong>All Zeroes:</strong> Handled gracefully, remaining all zeroes."
    },
    {
        "id": "p-rotate-array-k",
        "module_id": "mod6",
        "title": "Array Cyclic Rotation by K Offsets",
        "category": "Array Transformations",
        "files": ["RotateByArray.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1)",
        "definition": """
        Rotating an array to the right by $k$ positions moves the last $k$ elements to the front.
        <br><br>
        <strong>The 3-Step Inversion Algorithm (Optimal $O(N)$ time, $O(1)$ space):</strong>
        1. Normalize $k = k \\% N$.
        2. Reverse the entire array from index $0$ to $N - 1$.
        3. Reverse the first $k$ elements from index $0$ to $k - 1$.
        4. Reverse the remaining $N - k$ elements from index $k$ to $N - 1$.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Normalize: k = k % N",
            step2="Step 1: Reverse entire array [0, N-1]",
            step3="Step 2: Reverse first k elements [0, k-1]",
            step4="Step 3: Reverse remaining [k, N-1]"
        ),
        "code": """import java.util.Arrays;

public class RotateByArray {
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n <= 1) return;
        k = k % n;
        
        reverse(arr, 0, n - 1); // Reverse whole array
        reverse(arr, 0, k - 1); // Reverse first k
        reverse(arr, k, n - 1); // Reverse remaining
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println("Rotated by 3: " + Arrays.toString(arr));
    }
}""",
        "steps": [
            "Compute <code>k = k % n</code> to handle rotations where $k \\ge n$.",
            "Perform 3 targeted reversals in place.",
            "Array elements arrive at exact shifted positions."
        ],
        "sample_input": "Array: [1, 2, 3, 4, 5, 6, 7], k = 3",
        "sample_output": "Rotated by 3: [5, 6, 7, 1, 2, 3, 4]",
        "edge_cases": "<strong>k = 0 or k = N:</strong> Modulo yields 0, leaving the original array intact without redundant swaps."
    },
    {
        "id": "p-merge-sorted-arrays",
        "module_id": "mod6",
        "title": "Merge Two Sorted Arrays",
        "category": "Two-Pointer / Merging",
        "files": ["mergeTwoSortedArrays.java"],
        "time_complexity": "O(N + M)",
        "space_complexity": "O(N + M)",
        "definition": """
        Combines two sorted arrays $A$ of size $N$ and $B$ of size $M$ into a single consolidated sorted array of size $N + M$.
        <br><br>
        Employs two pointers $i$ and $j$ indexing into $A$ and $B$ respectively. At each step, compare $A[i]$ with $B[j]$, append the smaller element to the result array, and advance the corresponding pointer. Once one array is exhausted, append the remaining elements of the other.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Pointers i=0, j=0, k=0",
            input_txt="Sorted arrays A and B",
            condition_txt="A[i] <= B[j] ?",
            yes_txt="res[k++] = A[i++]",
            no_txt="res[k++] = B[j++]",
            output_txt="Flush remaining tail",
            end_txt="Return merged array"
        ),
        "code": """import java.util.Arrays;

public class mergeTwoSortedArrays {
    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }
        
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8, 10};
        System.out.println("Merged: " + Arrays.toString(merge(a, b)));
    }
}""",
        "steps": [
            "Allocate target array of size <code>a.length + b.length</code>.",
            "Compare elements pairwise while both pointers are within bounds.",
            "Copy remaining elements from whichever array has leftover values.",
            "Return complete merged array."
        ],
        "sample_input": "a = [1, 3, 5, 7], b = [2, 4, 6, 8, 10]",
        "sample_output": "Merged: [1, 2, 3, 4, 5, 6, 7, 8, 10]",
        "edge_cases": "<strong>Empty Array:</strong> If one array has length 0, the second array is copied directly."
    },

    # ----------------- MODULE 7 -----------------
    {
        "id": "p-matrix-multiplication",
        "module_id": "mod7",
        "title": "Matrix Multiplication & Dimension Validation",
        "category": "2D Arrays / Linear Algebra",
        "files": ["MatrixMultiplication.java", "MatrixAddition.java"],
        "time_complexity": "O(R1 * C1 * C2)",
        "space_complexity": "O(R1 * C2)",
        "definition": """
        The matrix product $C = A \\times B$ is defined if and only if the number of columns in $A$ equals the number of rows in $B$ ($C_1 = R_2$).
        <br><br>
        Each entry $C[i][j]$ is the dot product of row $i$ of matrix $A$ with column $j$ of matrix $B$:
        $$C[i][j] = \\sum_{k=0}^{C_1 - 1} A[i][k] \\times B[k][j]$$
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Verify Dimensions: cols(A) == rows(B)",
            step2="Allocate Result Matrix C [rows(A)][cols(B)]",
            step3="Triple Nested Loop: i -> j -> k (Dot Product)",
            step4="Return and Display Matrix C"
        ),
        "code": """public class MatrixMultiplication {
    public static int[][] multiply(int[][] a, int[][] b) {
        int r1 = a.length, c1 = a[0].length;
        int r2 = b.length, c2 = b[0].length;
        
        if (c1 != r2) {
            System.out.println("Dimension mismatch! Cannot multiply.");
            return null;
        }
        
        int[][] res = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{2, 0}, {1, 2}};
        int[][] c = multiply(a, b);
        for (int[] row : c) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}""",
        "steps": [
            "Validate inner dimension equality: <code>c1 == r2</code>.",
            "Allocate result array of dimensions <code>[r1][c2]</code>.",
            "Outer loop <code>i</code> iterates rows of A, middle loop <code>j</code> iterates columns of B.",
            "Inner loop <code>k</code> computes cumulative dot product sum."
        ],
        "sample_input": "A = [[1,2],[3,4]], B = [[2,0],[1,2]]",
        "sample_output": "4 4\\n10 8",
        "edge_cases": "<strong>Incompatible Dimensions:</strong> e.g., $2 \\times 3$ multiplied with $2 \\times 2$ is caught by the guard, returning null safely."
    },
    {
        "id": "p-matrix-transpose",
        "module_id": "mod7",
        "title": "Matrix Transposition",
        "category": "2D Coordinate Mapping",
        "files": ["TransposeofaMatrix.java"],
        "time_complexity": "O(R * C)",
        "space_complexity": "O(C * R)",
        "definition": """
        The transpose of a matrix $A$ of dimensions $R \\times C$ is a new matrix $A^T$ of dimensions $C \\times R$ obtained by flipping the matrix over its main diagonal:
        $$A^T[j][i] = A[i][j]$$
        Rows of the original matrix become columns of the transposed matrix.
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="Allocate T[C][R], i = 0",
            condition_txt="i < R ?",
            body_txt="for (j = 0 to C-1) T[j][i] = A[i][j]",
            update_txt="i++",
            exit_txt="Return Transposed Matrix T"
        ),
        "code": """public class TransposeofaMatrix {
    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] transposed = new int[c][r];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        int[][] t = transpose(mat);
        for (int[] row : t) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}""",
        "steps": [
            "Determine row count <code>r</code> and column count <code>c</code>.",
            "Allocate new 2D array of size <code>[c][r]</code>.",
            "Map coordinate values: <code>transposed[j][i] = matrix[i][j]</code>.",
            "Display transposed grid."
        ],
        "sample_input": "Matrix (2x3): [[1, 2, 3], [4, 5, 6]]",
        "sample_output": "1 4\\n2 5\\n3 6",
        "edge_cases": "<strong>Non-Square (Rectangular) Matrices:</strong> Dimensions correctly swap from $2 \\times 3$ to $3 \\times 2$ without index bounds errors."
    },
    {
        "id": "p-matrix-diagonals",
        "module_id": "mod7",
        "title": "Main & Secondary Diagonal Sums",
        "category": "Square Matrix Analysis",
        "files": ["MainDiagonalSum.java", "SecondaryDiagonalSum.java", "FindtheSumofAllMatrixElements.java", "SumofEachRow.java"],
        "time_complexity": "O(N) single-loop traversal",
        "space_complexity": "O(1)",
        "definition": """
        In an $N \\times N$ square matrix:
        1. <strong>Main Diagonal:</strong> Elements where row index equals column index ($i = j$). Element: $A[i][i]$.
        2. <strong>Secondary (Anti) Diagonal:</strong> Elements where row index and column index sum to $N - 1$ ($i + j = N - 1$). Element: $A[i][N - 1 - i]$.
        <br><br>
        Both diagonals can be computed in a single $O(N)$ pass without a nested $O(N^2)$ scan.
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="mainSum = 0, secSum = 0, i = 0",
            condition_txt="i < N ?",
            body_txt="mainSum += A[i][i] ; secSum += A[i][N-1-i]",
            update_txt="i++",
            exit_txt="Display Diagonal Totals"
        ),
        "code": """public class MainDiagonalSum {
    public static void computeDiagonals(int[][] matrix) {
        int n = matrix.length;
        int mainSum = 0;
        int secondarySum = 0;
        
        for (int i = 0; i < n; i++) {
            mainSum += matrix[i][i];
            secondarySum += matrix[i][n - 1 - i];
        }
        
        System.out.println("Main Diagonal Sum: " + mainSum);
        System.out.println("Secondary Diagonal Sum: " + secondarySum);
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        computeDiagonals(mat);
    }
}""",
        "steps": [
            "Initialize accumulators <code>mainSum = 0</code> and <code>secondarySum = 0</code>.",
            "Run a single loop from <code>i = 0</code> to <code>N - 1</code>.",
            "Add <code>matrix[i][i]</code> to main sum.",
            "Add <code>matrix[i][n - 1 - i]</code> to secondary sum.",
            "Output both diagonal sums."
        ],
        "sample_input": "Matrix (3x3): [[1,2,3],[4,5,6],[7,8,9]]",
        "sample_output": "Main Diagonal Sum: 15\\nSecondary Diagonal Sum: 15",
        "edge_cases": "<strong>Center Element in Odd Dimensions:</strong> If calculating union of diagonals, the center element ($matrix[N/2][N/2]$) is shared and should only be counted once if deduplication is required."
    },

    # ----------------- MODULE 8 -----------------
    {
        "id": "p-string-palindrome",
        "module_id": "mod8",
        "title": "String Palindrome Verification",
        "category": "Two-Pointer / String Processing",
        "files": ["ReverseJava.java", "ReversePalindrome.java", "CheckPalindrome.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1)",
        "definition": """
        A string is a <strong>palindrome</strong> if it reads the exact same forward and backward (e.g., "radar", "madam").
        <br><br>
        Using two pointers <code>left = 0</code> and <code>right = s.length() - 1</code>, compare characters moving inward. If any mismatch occurs (<code>s.charAt(left) != s.charAt(right)</code>), immediately conclude false. Runs in $O(N)$ time with $O(1)$ auxiliary space.
        """,
        "flowchart": draw_two_pointer_flowchart(
            title="Palindrome Two-Pointer Algorithm",
            left_init="left = 0",
            right_init="right = str.length() - 1",
            condition="left < right ?",
            update_left="left++",
            update_right="right--",
            action="if (str[left] != str[right]) return false"
        ),
        "code": """public class CheckPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("'racecar' is palindrome? " + isPalindrome("racecar"));
        System.out.println("'hello' is palindrome? " + isPalindrome("hello"));
    }
}""",
        "steps": [
            "Initialize pointers at string endpoints.",
            "Compare characters at left and right positions.",
            "If characters differ, early-exit and return <code>false</code>.",
            "Increment left and decrement right.",
            "If pointers meet without mismatches, return <code>true</code>."
        ],
        "sample_input": "Inputs: 'racecar', 'hello'",
        "sample_output": "'racecar' is palindrome? true\\n'hello' is palindrome? false",
        "edge_cases": "<strong>Single-Character & Empty Strings:</strong> Length 0 and length 1 strings are trivially palindromes (loop terminates immediately, returning true)."
    },
    {
        "id": "p-valid-anagram",
        "module_id": "mod8",
        "title": "Valid Anagram Verification",
        "category": "Frequency Array / Hashing",
        "files": ["ValidAnagram.java", "GroupAnagrams.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1) (fixed 26-element array)",
        "definition": """
        Two strings are <strong>anagrams</strong> if they contain the exact same characters with identical frequencies, arranged in a different order (e.g., "silent" and "listen").
        <br><br>
        Optimized using a fixed-size frequency table of size 26 for ASCII lowercase characters:
        1. If lengths differ, they cannot be anagrams.
        2. Increment count for characters in string $A$.
        3. Decrement count for characters in string $B$.
        4. If all frequencies in the table equal zero, the strings are valid anagrams.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Start: str1, str2",
            input_txt="Check: str1.length() == str2.length()",
            condition_txt="Lengths Equal?",
            yes_txt="Tally chars in freq[26]",
            no_txt="Return false immediately",
            output_txt="Verify all freq entries are 0",
            end_txt="End"
        ),
        "code": """public class ValidAnagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("anagram('listen', 'silent') -> " + isAnagram("listen", "silent"));
        System.out.println("anagram('rat', 'car') -> " + isAnagram("rat", "car"));
    }
}""",
        "steps": [
            "Check length guard: if lengths differ, return <code>false</code>.",
            "Initialize frequency buffer <code>int[26]</code>.",
            "Increment tally for characters in <code>s1</code>, decrement for <code>s2</code> in one pass.",
            "Scan buffer: if any non-zero count remains, return <code>false</code>; otherwise <code>true</code>."
        ],
        "sample_input": "s1 = 'listen', s2 = 'silent'",
        "sample_output": "anagram('listen', 'silent') -> true\\nanagram('rat', 'car') -> false",
        "edge_cases": "<strong>Case Sensitivity:</strong> If uppercase letters are present, convert to uniform case with <code>toLowerCase()</code> or expand frequency table to 128/256 elements."
    },
    {
        "id": "p-longest-common-prefix",
        "module_id": "mod8",
        "title": "Longest Common Prefix (LCP)",
        "category": "Horizontal Scanning / Strings",
        "files": ["LongestCommonPrefix.java"],
        "time_complexity": "O(S) where S is sum of all characters",
        "space_complexity": "O(1)",
        "definition": """
        Finding the longest prefix substring shared across an array of strings (e.g., ["flower","flow","flight"] -> "fl").
        <br><br>
        <strong>Horizontal Scanning Algorithm:</strong>
        Initialize <code>prefix = strs[0]</code>. Iteratively trim the prefix against each subsequent string $s$ using <code>prefix = prefix.substring(0, prefix.length() - 1)</code> until <code>s.indexOf(prefix) == 0</code>. If <code>prefix</code> becomes empty, no common prefix exists.
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="prefix = strs[0], i = 1",
            condition_txt="i < strs.length ?",
            body_txt="while (!strs[i].startsWith(prefix)) prefix = prefix.substring(0, len-1)",
            update_txt="i++",
            exit_txt="Return prefix"
        ),
        "code": """public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        System.out.println("LCP: " + longestCommonPrefix(words));
    }
}""",
        "steps": [
            "Set candidate prefix to the first word.",
            "Iterate through subsequent words.",
            "While the current word does not start with candidate prefix, truncate prefix by 1 character.",
            "If prefix length reaches 0, return empty string.",
            "Return remaining prefix."
        ],
        "sample_input": "['flower', 'flow', 'flight']",
        "sample_output": "LCP: fl",
        "edge_cases": "<strong>No Common Prefix:</strong> e.g., <code>[\"dog\", \"racecar\", \"car\"]</code> truncates prefix down to empty string <code>\"\"</code>."
    },
    {
        "id": "p-first-non-repeating",
        "module_id": "mod8",
        "title": "First Non-Repeating Character",
        "category": "Frequency Map / String Search",
        "files": ["FirstNonRepeating.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(1) (fixed ASCII alphabet)",
        "definition": """
        Finding the first character in a string that appears exactly once.
        <br><br>
        Employs a two-pass algorithm:
        1. <strong>Pass 1:</strong> Count character frequencies into a frequency table.
        2. <strong>Pass 2:</strong> Scan string sequentially from left to right; return the first character whose tally in the frequency table equals 1.
        """,
        "flowchart": draw_sequential_flowchart(
            step1="Pass 1: Count occurrences of each char in freq[]",
            step2="Pass 2: Iterate string chars from left to right",
            step3="Check: freq[s.charAt(i)] == 1 ?",
            step4="Return first match or -1 if all repeat"
        ),
        "code": """public class FirstNonRepeating {
    public static char firstUnique(String s) {
        int[] count = new int[256]; // Extended ASCII
        for (char c : s.toCharArray()) count[c]++;
        
        for (char c : s.toCharArray()) {
            if (count[c] == 1) return c;
        }
        return '_'; // No unique char found
    }

    public static void main(String[] args) {
        System.out.println("First unique in 'swiss': " + firstUnique("swiss"));
        System.out.println("First unique in 'success': " + firstUnique("success"));
    }
}""",
        "steps": [
            "Build character frequency table using first pass.",
            "Traverse string in original order in second pass.",
            "First character with count 1 is the result.",
            "Return sentinel if no unique character exists."
        ],
        "sample_input": "'swiss'",
        "sample_output": "First unique in 'swiss': w",
        "edge_cases": "<strong>All Characters Repeating:</strong> e.g., <code>\"aabbcc\"</code> returns sentinel <code>'_'</code>."
    },

    # ----------------- MODULE 9 -----------------
    {
        "id": "p-recursive-factorial-fibonacci",
        "module_id": "mod9",
        "title": "Recursive Factorial & Fibonacci Sequence",
        "category": "Recursion / Divide-and-Conquer",
        "files": ["Factorial.java", "Fibonnaci.java", "SumofDigitsusingRecursion.java"],
        "time_complexity": "Factorial: O(N) ; Fib: O(2^N) naive, O(N) memoized",
        "space_complexity": "O(N) call stack depth",
        "definition": """
        A method that calls itself is <strong>recursive</strong>. Every recursive solution requires:
        1. <strong>Base Case:</strong> A condition that terminates recursion without further self-invocation (prevents <code>StackOverflowError</code>).
        2. <strong>Recursive Step:</strong> Reducing the problem instance toward the base case.
        <br><br>
        Recurrence relations:
        - Factorial: $F(n) = n \\times F(n - 1)$ with $F(0) = 1$.
        - Fibonacci: $Fib(n) = Fib(n - 1) + Fib(n - 2)$ with $Fib(0) = 0, Fib(1) = 1$.
        """,
        "flowchart": draw_recursion_flowchart(
            func_name="factorial(n)",
            base_cond="n <= 1 ?",
            base_ret="Return 1",
            rec_step="Return n * factorial(n - 1)"
        ),
        "code": """public class Factorial {
    public static long factorial(int n) {
        if (n <= 1) return 1; // Base case
        return n * factorial(n - 1); // Recursive step
    }

    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Factorial(5) = " + factorial(5));
        System.out.println("Fibonacci(7) = " + fibonacci(7));
    }
}""",
        "steps": [
            "Check base condition: if $n \\le 1$, return 1 immediately.",
            "Otherwise, invoke <code>factorial(n - 1)</code> pushing frame onto stack.",
            "Multiply return value by $n$ while unwinding stack frames."
        ],
        "sample_input": "n = 5",
        "sample_output": "Factorial(5) = 120\\nFibonacci(7) = 13",
        "edge_cases": "<strong>Deep Recursion:</strong> Recursive calls consume stack memory (~1MB default thread stack). For $n > 10,000$, recursion triggers <code>java.lang.StackOverflowError</code>."
    },
    {
        "id": "p-reverse-linked-list-recursion",
        "module_id": "mod9",
        "title": "Linked List Inversion via Recursive Call Stack",
        "category": "Recursion / Data Structures",
        "files": ["ReverseaLinkedListUsingRecursion.java"],
        "time_complexity": "O(N)",
        "space_complexity": "O(N) call stack",
        "definition": """
        Reversing a singly linked list recursively relies on the JVM call stack to traverse to the end, identifying the new head, and reversing the pointers while unwinding.
        <br><br>
        For a node $N$, the recursive call reverses the tail. Upon return:
        $$N.\\text{next}.\\text{next} = N$$
        $$N.\\text{next} = \\text{null}$$
        This makes the next node point backward to the current node, cleanly inverting the pointer direction.
        """,
        "flowchart": draw_recursion_flowchart(
            func_name="reverseList(node)",
            base_cond="node == null || node.next == null ?",
            base_ret="Return node (New Head)",
            rec_step="newHead = reverseList(node.next); node.next.next = node; node.next = null"
        ),
        "code": """public class ReverseaLinkedListUsingRecursion {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node reverseList(Node current) {
        // Base case: empty list or reached terminal node
        if (current == null || current.next == null) {
            return current;
        }

        // Recursive call down to the last node
        Node newHead = reverseList(current.next);

        // Reverse connection: make successor point back to current
        current.next.next = current;
        current.next = null; // Sever old forward link

        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        
        Node rev = reverseList(head);
        while (rev != null) {
            System.out.print(rev.data + " -> ");
            rev = rev.next;
        }
        System.out.println("null");
    }
}""",
        "steps": [
            "Recursively advance until reaching the final node (which becomes the new head).",
            "At each stack level during unwinding, set <code>current.next.next = current</code>.",
            "Sever existing forward link: <code>current.next = null</code>.",
            "Propagate <code>newHead</code> back to the initial caller."
        ],
        "sample_input": "1 -> 2 -> 3 -> null",
        "sample_output": "3 -> 2 -> 1 -> null",
        "edge_cases": "<strong>Severing Link:</strong> Forgetting <code>current.next = null</code> creates a cyclic reference loop (1 -> 2 -> 1) causing infinite traversal loops."
    },
    {
        "id": "p-power-set-subsets",
        "module_id": "mod9",
        "title": "Combinatorial Power Set Generation",
        "category": "Backtracking / Combinatorics",
        "files": ["PrintAllSubsetsofAnArray.java"],
        "time_complexity": "O(2^N)",
        "space_complexity": "O(N) recursion tree depth",
        "definition": """
        The power set of a set of size $N$ contains all $2^N$ possible subsets (including the empty set and the set itself).
        <br><br>
        Using the <strong>Include / Exclude Decision Tree</strong>:
        At each index $i$, we branch into two recursive decisions:
        1. <strong>Include:</strong> Add element $arr[i]$ to the current subset and recurse to $i + 1$.
        2. <strong>Exclude:</strong> Do not include $arr[i]$ and recurse to $i + 1$.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="generateSubsets(index, currentList)",
            input_txt="Check: index == arr.length ?",
            condition_txt="Base Case Reached?",
            yes_txt="Print Current Subset",
            no_txt="Branch: Include vs Exclude arr[index]",
            output_txt="Recurse to index + 1",
            end_txt="Return & Backtrack"
        ),
        "code": """import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsetsofAnArray {
    public static void findSubsets(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }
        
        // Choice 1: Include arr[index]
        current.add(arr[index]);
        findSubsets(arr, index + 1, current);
        
        // Backtrack
        current.remove(current.size() - 1);
        
        // Choice 2: Exclude arr[index]
        findSubsets(arr, index + 1, current);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findSubsets(arr, 0, new ArrayList<>());
    }
}""",
        "steps": [
            "Base case: when <code>index == arr.length</code>, output current subset.",
            "Add current element to list, recurse for next index (include branch).",
            "Remove last element (backtrack) to restore state.",
            "Recurse without adding current element (exclude branch)."
        ],
        "sample_input": "[1, 2, 3]",
        "sample_output": "[1, 2, 3]\\n[1, 2]\\n[1, 3]\\n[1]\\n[2, 3]\\n[2]\\n[3]\\n[]",
        "edge_cases": "<strong>Exponential Growth:</strong> A set of 20 elements generates $2^{20} = 1,048,576$ subsets. For $N > 25$, memory and CPU time grow rapidly."
    },

    # ----------------- MODULE 10 -----------------
    {
        "id": "p-two-sum-algorithms",
        "module_id": "mod10",
        "title": "The Two Sum Problem",
        "category": "Hashing / Two Pointers",
        "files": ["TwoSum.java", "PairWithGivenSumInASortedArray.java"],
        "time_complexity": "HashMap: O(N) time, O(N) space ; Sorted: O(N) time, O(1) space",
        "space_complexity": "HashMap: O(N) ; Two-Pointer: O(1)",
        "definition": """
        Finding two numbers in an array that sum to a given target value:
        $$arr[i] + arr[j] = \\text{target}$$
        <br><br>
        <strong>1. Hash Map Approach ($O(N)$):</strong> For each element $x$, check if the complement $(\\text{target} - x)$ already exists in the map.
        <br><br>
        <strong>2. Sorted Two-Pointer Approach ($O(N)$):</strong> Initialize <code>left = 0</code>, <code>right = N - 1</code>.
        - If $sum == target$: match found!
        - If $sum < target$: advance <code>left++</code> (increase sum).
        - If $sum > target$: decrement <code>right--</code> (decrease sum).
        """,
        "flowchart": draw_two_pointer_flowchart(
            title="Two-Pointer Sum Convergence",
            left_init="left = 0",
            right_init="right = N - 1",
            condition="left < right ?",
            update_left="if sum < target: left++",
            update_right="if sum > target: right--",
            action="if sum == target: return indices"
        ),
        "code": """import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // One-pass Hash Table Solution
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println("Indices: [" + res[0] + ", " + res[1] + "]");
    }
}""",
        "steps": [
            "Initialize hash map storing <code>(value -> index)</code>.",
            "Iterate through array calculating <code>complement = target - nums[i]</code>.",
            "If complement is in map, return indices immediately.",
            "Otherwise, record current element and index in map."
        ],
        "sample_input": "nums = [2, 7, 11, 15], target = 9",
        "sample_output": "Indices: [0, 1]",
        "edge_cases": "<strong>Duplicate Elements:</strong> e.g., <code>nums = [3, 3], target = 6</code>. Checking for complement before inserting current element correctly finds index 0 when reading index 1."
    },
    {
        "id": "p-sliding-window-max-k",
        "module_id": "mod10",
        "title": "Sliding Window: Maximum Sum Subarray of Size K",
        "category": "Sliding Window Optimization",
        "files": ["MaximumSumSubarrayK.java", "SubarrayWithGivenSum.java"],
        "time_complexity": "O(N) linear",
        "space_complexity": "O(1)",
        "definition": """
        Finding the maximum sum of any contiguous subarray of fixed size $k$.
        <br><br>
        Brute force recalculates each window from scratch in $O(N \\times k)$ time.
        <br><br>
        <strong>Sliding Window Optimization ($O(N)$):</strong>
        Compute the sum of the first window of size $k$. To slide the window one step to the right:
        $$\\text{newSum} = \\text{oldSum} + arr[i] - arr[i - k]$$
        Add the incoming element and subtract the outgoing element in $O(1)$ constant time per step!
        """,
        "flowchart": draw_loop_flowchart(
            init_txt="windowSum = sum of first k elements, maxSum = windowSum",
            condition_txt="i from k to N - 1 ?",
            body_txt="windowSum += arr[i] - arr[i - k] ; maxSum = max(maxSum, windowSum)",
            update_txt="i++",
            exit_txt="Return maxSum"
        ),
        "code": """public class MaximumSumSubarrayK {
    public static int maxSubarraySum(int[] arr, int k) {
        if (arr.length < k) return -1;
        
        // Sum of initial window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        // Slide the window across remainder of array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add incoming, drop outgoing
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max Sum Subarray of Size " + k + " = " + maxSubarraySum(arr, k));
    }
}""",
        "steps": [
            "Compute sum of initial $k$ elements.",
            "Initialize <code>maxSum = windowSum</code>.",
            "Slide window from index $k$ to $N - 1$, adjusting by $+arr[i] - arr[i - k]$.",
            "Update <code>maxSum</code> with the maximum value seen.",
            "Return <code>maxSum</code>."
        ],
        "sample_input": "arr = [2, 1, 5, 1, 3, 2], k = 3",
        "sample_output": "Max Sum Subarray of Size 3 = 9 (subarray [5, 1, 3])",
        "edge_cases": "<strong>k > N:</strong> If window size exceeds array length, return -1 or throw <code>IllegalArgumentException</code>."
    },
    {
        "id": "p-pairs-given-difference",
        "module_id": "mod10",
        "title": "Pairs with Given Difference",
        "category": "Two-Pointer / Hashing",
        "files": ["FindAllPairsWithAGivenDifference.java"],
        "time_complexity": "O(N) with HashSet or O(N log N) with Two-Pointer",
        "space_complexity": "O(N)",
        "definition": """
        Finding all distinct pairs $(x, y)$ in an array such that their absolute difference equals a target value:
        $$|x - y| = k$$
        <br><br>
        Using a <code>HashSet</code>: insert all elements into the set. For each unique element $x$, check if $(x + k)$ exists in the set. If so, $(x, x + k)$ is a valid pair with difference $k$.
        """,
        "flowchart": draw_decision_flowchart(
            start_txt="Set set = new HashSet(arr)",
            input_txt="Iterate each element x in arr",
            condition_txt="set.contains(x + k) ?",
            yes_txt="Record pair (x, x + k)",
            no_txt="Continue iteration",
            output_txt="Print all unique pairs",
            end_txt="End"
        ),
        "code": """import java.util.HashSet;
import java.util.Set;

public class FindAllPairsWithAGivenDifference {
    public static void findPairs(int[] arr, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        
        System.out.println("Pairs with difference " + diff + ":");
        for (int num : set) {
            if (set.contains(num + diff)) {
                System.out.println("(" + num + ", " + (num + diff) + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int diff = 2;
        findPairs(arr, diff);
    }
}""",
        "steps": [
            "Add array elements into a <code>HashSet</code> for $O(1)$ average-time lookups.",
            "Iterate through unique numbers in the set.",
            "Check if <code>num + diff</code> is present.",
            "Print matching pairs."
        ],
        "sample_input": "arr = [1, 5, 3, 4, 2], diff = 2",
        "sample_output": "Pairs with difference 2:\\n(1, 3)\\n(2, 4)\\n(3, 5)",
        "edge_cases": "<strong>Difference k = 0:</strong> Requires checking for duplicate elements in the original array rather than looking up <code>num + 0</code>."
    }
]
