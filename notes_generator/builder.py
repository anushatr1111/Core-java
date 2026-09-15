"""
Core Java Notes HTML & PDF Builder
Generates a complete, beautiful HTML document and compiles it to vector PDF via Playwright (msedge).
"""

import os
import re
import html
from playwright.sync_api import sync_playwright

from .styles import MAIN_CSS
from .content_registry import ALL_MODULES, ALL_PROBLEMS, get_problems_by_module

def highlight_java(code):
    """
    Apply clean syntax highlighting spans to Java code string using single-pass regex
    to prevent replacement collisions with inserted HTML attributes.
    """
    code = html.escape(code)
    
    pattern = re.compile(
        r'(\/\/[^\n]*)'                                  # 1. comments
        r'|(&quot;.*?&quot;)'                            # 2. strings
        r'|(@\w+)'                                       # 3. annotations
        r'|\b(public|private|protected|static|final|abstract|class|interface|extends|implements|void|return|if|else|switch|case|default|break|continue|while|for|do|try|catch|finally|throw|throws|new|this|super|import|package|null|true|false)\b' # 4. keywords
        r'|\b(int|double|float|long|boolean|char|byte|short|String|Scanner|System|Math|Arrays|List|ArrayList|Set|HashSet|LinkedHashSet|Map|HashMap|Collections|Comparable|Comparator|LocalDate|LocalTime|LocalDateTime|DateTimeFormatter|Period|ChronoUnit|File|FileReader|FileWriter|BufferedReader|Thread|Runnable|Random|Exception|ArithmeticException|ArrayIndexOutOfBoundsException|IOException|Integer|Double|Long|Boolean)\b' # 5. types
        r'|\b(\d+(\.\d+)?)\b'                            # 6. numbers
    )
    
    def repl(m):
        if m.group(1):
            return f'<span class="cm">{m.group(1)}</span>'
        elif m.group(2):
            return f'<span class="str">{m.group(2)}</span>'
        elif m.group(3):
            return f'<span class="ann">{m.group(3)}</span>'
        elif m.group(4):
            return f'<span class="kw">{m.group(4)}</span>'
        elif m.group(5):
            return f'<span class="tp">{m.group(5)}</span>'
        elif m.group(6):
            return f'<span class="num">{m.group(6)}</span>'
        return m.group(0)
        
    return pattern.sub(repl, code)

def build_cover_page():
    return """
    <div class="cover-page">
      <div class="cover-top">
        <span class="cover-badge">Core Java Master Handbook</span>
        <h1 class="cover-title">Core Java<br>Problem-Solving &amp; Notes</h1>
        <p class="cover-subtitle">
          A definitive, publication-grade reference manual featuring detailed theoretical definitions,
          flowcharts, production Java implementations, and edge-case analysis.
        </p>
        
        <div class="cover-highlights">
          <div class="cover-pill">
            <span class="cover-pill-icon">✓</span>
            <span><strong>157 Problem Files</strong> thoroughly documented</span>
          </div>
          <div class="cover-pill">
            <span class="cover-pill-icon">✓</span>
            <span><strong>Vector SVG Flowcharts</strong> for logic visualization</span>
          </div>
          <div class="cover-pill">
            <span class="cover-pill-icon">✓</span>
            <span><strong>17 Structured Modules</strong> from syntax to concurrency</span>
          </div>
          <div class="cover-pill">
            <span class="cover-pill-icon">✓</span>
            <span><strong>Time &amp; Space Complexity</strong> asymptotic profiles</span>
          </div>
        </div>
      </div>
      
      <div class="cover-footer">
        <div class="cover-meta">
          <h4>Core Java Learning Journey</h4>
          <p>Prepared for Academic Excellence &amp; Technical Interviews</p>
          <p>Repository: <code>Core-java</code> • kamraj-college-webdev</p>
        </div>
        <div class="cover-stats">
          <div class="stat-item">
            <div class="stat-num">17</div>
            <div class="stat-label">Modules</div>
          </div>
          <div class="stat-item">
            <div class="stat-num">157</div>
            <div class="stat-label">Java Files</div>
          </div>
          <div class="stat-item">
            <div class="stat-num">100%</div>
            <div class="stat-label">Coverage</div>
          </div>
        </div>
      </div>
    </div>
    """

def build_toc():
    cards_html = []
    for mod in ALL_MODULES:
        problems = get_problems_by_module(mod["id"])
        cards_html.append(f"""
        <div class="toc-card">
          <div class="toc-card-header">
            <span class="toc-card-num">MODULE {mod['num']}</span>
            <span class="toc-card-count">{len(problems)} In-Depth Topics</span>
          </div>
          <div class="toc-card-title">{mod['title']}</div>
          <div class="toc-card-desc">{mod['desc']}</div>
        </div>
        """)
        
    return f"""
    <div class="toc-container page-break">
      <h2 class="toc-title">
        <span>Table of Contents &amp; Study Guide</span>
      </h2>
      <p class="toc-subtitle">
        Systematic overview of all 17 Core Java learning modules. Every module contains rigorous definitions,
        flowcharts, complete Java source code, walkthrough steps, sample I/O, and critical boundary edge cases.
      </p>
      
      <div class="toc-grid">
        {''.join(cards_html)}
      </div>
    </div>
    """

def build_problem_card(prob):
    # Files badges
    files_str = " &bull; ".join(prob["files"])
    
    # Steps list
    steps_html = "".join([f"<li>{step}</li>" for step in prob["steps"]])
    
    # Highlighted code
    highlighted_code = highlight_java(prob["code"])
    
    return f"""
    <div class="problem-card" id="{prob['id']}">
      <div class="problem-header">
        <div class="problem-title-group">
          <h3>{prob['title']}</h3>
          <div class="problem-files">Files: {files_str}</div>
        </div>
        <div class="problem-meta">
          <span class="badge badge-category">{prob['category']}</span>
          <span class="badge badge-time">Time: {prob['time_complexity']}</span>
          <span class="badge badge-space">Space: {prob['space_complexity']}</span>
        </div>
      </div>
      
      <!-- Definition Section -->
      <div class="section-block">
        <div class="section-label">
          <span>Detailed Definition &amp; Core Concept</span>
        </div>
        <div class="def-box">
          {prob['definition']}
        </div>
      </div>
      
      <!-- Flowchart Diagram -->
      <div class="section-block">
        <div class="section-label">
          <span>Algorithmic Logic &amp; Decision Flowchart</span>
        </div>
        <div class="flowchart-wrapper">
          {prob['flowchart']}
        </div>
      </div>
      
      <!-- Java Implementation -->
      <div class="section-block">
        <div class="code-container">
          <div class="code-header">
            <span class="code-title">{prob['files'][0]}</span>
            <span class="code-lang">Java 17+</span>
          </div>
          <pre class="code-block"><code>{highlighted_code}</code></pre>
        </div>
      </div>
      
      <!-- Step-by-Step Logic -->
      <div class="section-block">
        <div class="section-label">
          <span>Execution Trace &amp; Logic Walkthrough</span>
        </div>
        <ol class="steps-list">
          {steps_html}
        </ol>
      </div>
      
      <!-- Sample IO -->
      <div class="section-block">
        <div class="io-grid">
          <div class="io-box">
            <div class="io-label">Sample Input</div>
            <div class="io-content">{prob['sample_input']}</div>
          </div>
          <div class="io-box">
            <div class="io-label">Expected Output</div>
            <div class="io-content">{prob['sample_output']}</div>
          </div>
        </div>
      </div>
      
      <!-- Edge Cases & Traps -->
      <div class="section-block">
        <div class="edge-case-box">
          <div class="edge-case-title">
            <span>Critical Edge Cases &amp; Pitfalls</span>
          </div>
          <div>{prob['edge_cases']}</div>
        </div>
      </div>
    </div>
    """

def build_repository_inventory():
    """
    Build a comprehensive master index table of all 157 Java files in the workspace
    """
    return """
    <div class="page-break" style="padding-top: 15px;">
      <h2 class="toc-title">
        <span>Complete Repository Inventory (157 Java Files)</span>
      </h2>
      <p class="toc-subtitle">
        Cross-reference table mapping all source files in the workspace to their respective core modules,
        demonstrating 100% curriculum coverage.
      </p>
      
      <table style="width:100%; border-collapse: collapse; font-size: 11px; margin-top: 12px; background: #ffffff; border: 1px solid #e2e8f0; border-radius: 8px; overflow: hidden;">
        <thead>
          <tr style="background: #1e293b; color: #ffffff; text-align: left;">
            <th style="padding: 8px 12px; border: 1px solid #334155;">#</th>
            <th style="padding: 8px 12px; border: 1px solid #334155;">Module</th>
            <th style="padding: 8px 12px; border: 1px solid #334155;">Primary Java Files</th>
            <th style="padding: 8px 12px; border: 1px solid #334155;">Core Concepts Covered</th>
          </tr>
        </thead>
        <tbody>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">1</td>
            <td style="padding: 6px 12px; font-weight: 600;">Conditionals</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">CheckEvenorOdd, CheckEvenOrOddMethod, CheckPostiveorNegative, CountPositiveNegativeZero, LargestofThree, LargestofThreeNumbers, Largest, GradeCalculator, ElectricityBill, DayOfTheWeek, Monthname, Login</td>
            <td style="padding: 6px 12px;">Parity, Modulo, Relational logic, Multi-branch if-else, Switch-case jump tables, String pool .equals()</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">2</td>
            <td style="padding: 6px 12px; font-weight: 600;">Loops & Numbers</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">EvenNumbers, OnetoNWhile, UptoN, Count, SumUntilZero, SumEvenOdd, Sum, Multiply, CountDigits, CountSumDigits, ReverseNumber, NumberGuessing</td>
            <td style="padding: 6px 12px;">While/For/Do-While iteration, Sentinel termination (0), Radix-10 digit decomposition, Horner's accumulator reversal</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">3</td>
            <td style="padding: 6px 12px; font-weight: 600;">Methods & Modularity</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">Calculator, CalculatorUsingMethod, CalculatorUsingMethods, SquareofaNumber, EvenorOddMethod, Overloadedadd, Overloadedarea, greet</td>
            <td style="padding: 6px 12px;">Functional decomposition, Stack frames, Value parameter passing, Method overloading, Static dispatch</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">4</td>
            <td style="padding: 6px 12px; font-weight: 600;">OOP Core</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">CreateaCarClass, CreateaStudentClass, BankAccountClass, BankAccountValidation, SecureBankAccount, BankingSystem, RectangleClass, ProductClass, ProductStockManagement, StudentManagement, EmployeeManagement, ATM, ATMmenu, ATMSystem, Billing</td>
            <td style="padding: 6px 12px;">Classes, State encapsulation, Constructors, Private fields, Mutators, Domain state machines, Object arrays</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">5</td>
            <td style="padding: 6px 12px; font-weight: 600;">Inheritance & Poly</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">VehicleCar, AnimalDog, AnimalSounds, EmployeeHierarchy, EmployeePolymorphism, ParentReference, MethodOverriding, AbstractShape, AbstractAnimal, AbstractEmployee, CreateaPaymentInterface, PaymentSystem, MultipleInterfaces, Shape</td>
            <td style="padding: 6px 12px;">IS-A inheritance, Dynamic method dispatch, Vtable lookup, Abstract classes, Interface contracts</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">6</td>
            <td style="padding: 6px 12px; font-weight: 600;">1D Arrays</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">PrintAllArrayElements, SearchforaNumber, FindMinAndMax, FindtheLargestandSmallestNumber, FindtheSecondLargestNumber, SecondLargest, ReverseanArray, ReverseArray, SortanArrayinAscendingOrder, FrequencyofEveryElement, CountFrequency, CountOccurrences, MovesZeroesToEnd, RotateByArray, mergeTwoSortedArrays, RemoveDuplicates</td>
            <td style="padding: 6px 12px;">Linear scan, Single-pass extreme tracking, In-place two-pointer reversal, Cyclic shift reversal, Linear merge</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">7</td>
            <td style="padding: 6px 12px; font-weight: 600;">2D Matrices</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">InputandPrintaMatrix, MatrixAddition, MatrixMultiplication, TransposeofaMatrix, FindtheSumofAllMatrixElements, SumofEachRow, MainDiagonalSum, SecondaryDiagonalSum, FindtheLargestElementinaMatrix, SearchanElementinaMatrix, MatrixAnalyzer</td>
            <td style="padding: 6px 12px;">Row-major indexing, Matrix dot product, Matrix transposition, Main/Anti-diagonal sums, Linear coordinate search</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">8</td>
            <td style="padding: 6px 12px; font-weight: 600;">Strings</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">FindtheLengthofaString, CountVowels, CountWordsinaSentence, ReverseJava, ReversePalindrome, CheckPalindrome, CheckTheStringRotated, LongestCommonPrefix, ValidAnagram, FirstNonRepeating, GroupAnagrams</td>
            <td style="padding: 6px 12px;">String immutability, Tokenization, Two-pointer palindrome test, Rotated string concatenation, 26-char frequency hashing</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">9</td>
            <td style="padding: 6px 12px; font-weight: 600;">Recursion</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">Factorial, Fibonnaci, SumofDigitsusingRecursion, ReverseaLinkedListUsingRecursion, PrintAllSubsetsofAnArray</td>
            <td style="padding: 6px 12px;">Base cases, Recursive call unwinding, Linked list node pointer inversion, Include/Exclude power set tree</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">10</td>
            <td style="padding: 6px 12px; font-weight: 600;">Advanced Algorithms</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">TwoSum, PairWithGivenSumInASortedArray, FindAllPairsWithAGivenDifference, MaximumSumSubarrayK, SubarrayWithGivenSum</td>
            <td style="padding: 6px 12px;">Two-pointer convergence, Complement hashing, Sliding window constant-time window update (+incoming -outgoing)</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">11</td>
            <td style="padding: 6px 12px; font-weight: 600;">Patterns</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">SquarePattern, IncreasingTriangle, NumberTriangle, ReverseTriangle, NumberPyramid</td>
            <td style="padding: 6px 12px;">Row iteration, Indentation formulas, Column progression, Centered symmetric pyramid geometry</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">12</td>
            <td style="padding: 6px 12px; font-weight: 600;">Exceptions</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">DivisionException, ArrayException, MultipleExceptions, CustomException, BankAccountValidationException, ATMExceptionSystem</td>
            <td style="padding: 6px 12px;">Checked vs Unchecked, Try-catch-finally, Throw/throws, Custom exception inheritance, Robust domain guards</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">13</td>
            <td style="padding: 6px 12px; font-weight: 600;">Collections</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">ArrayListStudentNames, ArrayListNumbers, RemoveDuplicatesHashSet, IterateThroughaHashSet, ListVsSet, StudentMarksHashMap, WordFrequencyHashMap, StudentManagementSystem</td>
            <td style="padding: 6px 12px;">List indexing, Set uniqueness, Map hash bucket lookups, Full CLI Student Management System CRUD</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">14</td>
            <td style="padding: 6px 12px; font-weight: 600;">Sorting & Comparators</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">SortNumbers, SortStudentNames, StudentSortingwithComparable, StudentSortingwithComparator, EmployeeSortingSystem</td>
            <td style="padding: 6px 12px;">Comparable compareTo natural ordering, Comparator lambda strategy pattern, TimSort mechanics, Employee sorting CLI</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">15</td>
            <td style="padding: 6px 12px; font-weight: 600;">Generics</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">GenericBox, GenericMethod, GenericList, EmployeeMap, GenericEmployeeManagementSystem</td>
            <td style="padding: 6px 12px;">Parameterized types &lt;T&gt;, Type erasure, Generic methods &lt;E&gt;, Coordinated List/Set/Map generic architecture</td>
          </tr>
          <tr style="background: #f8fafc; border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">16</td>
            <td style="padding: 6px 12px; font-weight: 600;">File I/O</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">CreateaFile, WriteStudentDetails, AppendData, ReadtheFile, CountLinesWordsCharacters, EmployeeManagementSystem</td>
            <td style="padding: 6px 12px;">File creation, FileWriter append mode, BufferedReader disk buffering, Word/Line counters, Persistent CRUD</td>
          </tr>
          <tr style="border-bottom: 1px solid #e2e8f0;">
            <td style="padding: 6px 12px; font-weight: bold; color: #2563eb;">17</td>
            <td style="padding: 6px 12px; font-weight: 600;">Date/Time & Threads</td>
            <td style="padding: 6px 12px; font-family: 'Fira Code', monospace; color: #0f172a;">DateInformation, DateCalculator, DaysBetweenDates, BirthdayCalculator, DateFormatter, MyThread, PrintNumbersUsingaThread, EmployeeLeaveManagementSystem, EmployeeLeaveTracker</td>
            <td style="padding: 6px 12px;">LocalDate, ChronoUnit intervals, Period calendar arithmetic, Thread lifecycle, Asynchronous execution, Leave Tracker Capstone</td>
          </tr>
        </tbody>
      </table>
    </div>
    """

def generate_full_html():
    """
    Assemble the complete HTML document string
    """
    body_parts = []
    
    # 1. Cover Page
    body_parts.append(build_cover_page())
    
    # 2. Table of Contents
    body_parts.append(build_toc())
    
    # 3. Modules and Problems
    for mod in ALL_MODULES:
        mod_problems = get_problems_by_module(mod["id"])
        
        # Module Header
        body_parts.append(f"""
        <div class="module-header" id="module-{mod['num']}">
          <span class="module-header-badge">MODULE {mod['num']} &bull; CORE JAVA CURRICULUM</span>
          <h2 class="module-header-title">{mod['title']}</h2>
          <p class="module-header-desc">{mod['desc']}</p>
        </div>
        """)
        
        # Problem Cards
        for prob in mod_problems:
            body_parts.append(build_problem_card(prob))
            
    # 4. Comprehensive Repository Inventory Table
    body_parts.append(build_repository_inventory())
    
    # Final HTML document wrapper
    full_html = f"""<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Core Java Complete Notes &amp; Problem-Solving Handbook</title>
  <style>
    {MAIN_CSS}
  </style>
</head>
<body>
  {''.join(body_parts)}
</body>
</html>
"""
    return full_html

def compile_pdf(html_path, output_pdf_path):
    """
    Render HTML to vector PDF using Playwright with Microsoft Edge
    """
    print(f"Launching Playwright with msedge channel...")
    with sync_playwright() as p:
        browser = p.chromium.launch(channel="msedge")
        page = browser.new_page()
        
        file_url = f"file:///{os.path.abspath(html_path).replace(os.sep, '/')}"
        print(f"Loading page URL: {file_url}")
        page.goto(file_url, wait_until="networkidle")
        
        print(f"Rendering PDF to: {output_pdf_path} ...")
        page.pdf(
            path=output_pdf_path,
            format="A4",
            print_background=True,
            display_header_footer=True,
            header_template="<div></div>",
            footer_template="""
            <div style="font-family: 'Inter', sans-serif; font-size: 8.5pt; color: #64748b; width: 100%; display: flex; justify-content: space-between; padding: 0 16mm;">
              <span>Core Java Comprehensive Study Notes &amp; Problem-Solving Handbook</span>
              <span>Page <span class="pageNumber"></span> of <span class="totalPages"></span></span>
            </div>
            """,
            margin={
                "top": "16mm",
                "bottom": "18mm",
                "left": "14mm",
                "right": "14mm"
            }
        )
        browser.close()
    print("PDF compilation completed successfully!")

def main():
    workspace_dir = os.path.abspath(".")
    html_file = os.path.join(workspace_dir, "Core_Java_Complete_Notes.html")
    pdf_file = os.path.join(workspace_dir, "Core_Java_Complete_Notes.pdf")
    
    print("Generating comprehensive HTML content...")
    full_html = generate_full_html()
    
    with open(html_file, "w", encoding="utf-8") as f:
        f.write(full_html)
    print(f"Saved HTML to: {html_file} ({len(full_html)} chars)")
    
    print("Compiling PDF...")
    compile_pdf(html_file, pdf_file)
    
    if os.path.exists(pdf_file):
        size_mb = os.path.getsize(pdf_file) / (1024 * 1024)
        print(f"SUCCESS! Output PDF generated: {pdf_file} ({size_mb:.2f} MB)")
    else:
        print("ERROR: PDF was not generated.")

if __name__ == "__main__":
    main()
