"""
SVG Flowchart and Diagram Generators for Core Java Notes
"""

def get_svg_defs():
    return """
    <defs>
      <marker id="arrow" viewBox="0 0 10 10" refX="6" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
        <path d="M 0 1.5 L 8 5 L 0 8.5 z" fill="#475569" />
      </marker>
      <marker id="arrow-blue" viewBox="0 0 10 10" refX="6" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
        <path d="M 0 1.5 L 8 5 L 0 8.5 z" fill="#2563eb" />
      </marker>
      <marker id="arrow-green" viewBox="0 0 10 10" refX="6" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
        <path d="M 0 1.5 L 8 5 L 0 8.5 z" fill="#059669" />
      </marker>
      <marker id="arrow-rose" viewBox="0 0 10 10" refX="6" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
        <path d="M 0 1.5 L 8 5 L 0 8.5 z" fill="#e11d48" />
      </marker>
      <filter id="shadow" x="-5%" y="-5%" width="110%" height="115%" filterUnits="userSpaceOnUse">
        <feDropShadow dx="0" dy="1.5" stdDeviation="1.5" flood-color="#0f172a" flood-opacity="0.08"/>
      </filter>
    </defs>
    """

def draw_decision_flowchart(start_txt="Start", input_txt="Input Number N", condition_txt="N % 2 == 0 ?", 
                            yes_txt="Even Number", no_txt="Odd Number", output_txt="Display Result", end_txt="End"):
    """
    Standard branching decision flowchart (width=520, height=270)
    """
    return f"""
    <svg class="flowchart-svg" width="520" height="270" viewBox="0 0 520 270" xmlns="http://www.w3.org/2000/svg">
      {get_svg_defs()}
      
      <!-- Start Pill -->
      <rect x="200" y="10" width="120" height="32" rx="16" fill="#10b981" filter="url(#shadow)"/>
      <text x="260" y="31" fill="#ffffff" font-family="'Inter', sans-serif" font-size="11" font-weight="600" text-anchor="middle">{start_txt}</text>
      
      <!-- Line to Input -->
      <line x1="260" y1="42" x2="260" y2="60" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Input Parallelogram -->
      <polygon points="190,62 330,62 310,94 170,94" fill="#ede9fe" stroke="#8b5cf6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="250" y="82" fill="#5b21b6" font-family="'Inter', sans-serif" font-size="10.5" font-weight="600" text-anchor="middle">{input_txt}</text>
      
      <!-- Line to Condition -->
      <line x1="250" y1="94" x2="250" y2="114" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Decision Diamond -->
      <polygon points="250,115 350,145 250,175 150,145" fill="#fef3c7" stroke="#d97706" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="250" y="149" fill="#92400e" font-family="'Inter', sans-serif" font-size="10" font-weight="700" text-anchor="middle">{condition_txt}</text>
      
      <!-- Yes Branch (Left) -->
      <line x1="150" y1="145" x2="85" y2="145" stroke="#059669" stroke-width="1.8"/>
      <line x1="85" y1="145" x2="85" y2="175" stroke="#059669" stroke-width="1.8" marker-end="url(#arrow-green)"/>
      <text x="115" y="138" fill="#059669" font-family="'Inter', sans-serif" font-size="9.5" font-weight="700" text-anchor="middle">YES (True)</text>
      
      <rect x="25" y="175" width="120" height="32" rx="6" fill="#ecfdf5" stroke="#10b981" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="85" y="195" fill="#065f46" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{yes_txt}</text>
      
      <!-- No Branch (Right) -->
      <line x1="350" y1="145" x2="435" y2="145" stroke="#e11d48" stroke-width="1.8"/>
      <line x1="435" y1="145" x2="435" y2="175" stroke="#e11d48" stroke-width="1.8" marker-end="url(#arrow-rose)"/>
      <text x="395" y="138" fill="#e11d48" font-family="'Inter', sans-serif" font-size="9.5" font-weight="700" text-anchor="middle">NO (False)</text>
      
      <rect x="375" y="175" width="120" height="32" rx="6" fill="#fff1f2" stroke="#f43f5e" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="435" y="195" fill="#9f1239" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{no_txt}</text>
      
      <!-- Merge lines to output -->
      <line x1="85" y1="207" x2="85" y2="225" stroke="#475569" stroke-width="1.8"/>
      <line x1="85" y1="225" x2="200" y2="225" stroke="#475569" stroke-width="1.8"/>
      
      <line x1="435" y1="207" x2="435" y2="225" stroke="#475569" stroke-width="1.8"/>
      <line x1="435" y1="225" x2="320" y2="225" stroke="#475569" stroke-width="1.8"/>
      
      <line x1="260" y1="225" x2="260" y2="238" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- End Pill -->
      <rect x="205" y="240" width="110" height="28" rx="14" fill="#64748b" filter="url(#shadow)"/>
      <text x="260" y="258" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10.5" font-weight="600" text-anchor="middle">{end_txt}</text>
    </svg>
    """

def draw_loop_flowchart(init_txt="Initialize: i = 1, sum = 0", condition_txt="i <= N ?",
                        body_txt="sum += i ; print(i)", update_txt="i++ (Step Increment)",
                        exit_txt="Output Result (sum)"):
    """
    Standard loop iteration flowchart (width=520, height=270)
    """
    return f"""
    <svg class="flowchart-svg" width="520" height="270" viewBox="0 0 520 270" xmlns="http://www.w3.org/2000/svg">
      {get_svg_defs()}
      
      <!-- Start Pill -->
      <rect x="200" y="8" width="120" height="30" rx="15" fill="#10b981" filter="url(#shadow)"/>
      <text x="260" y="28" fill="#ffffff" font-family="'Inter', sans-serif" font-size="11" font-weight="600" text-anchor="middle">Start</text>
      
      <!-- Line to Init -->
      <line x1="260" y1="38" x2="260" y2="52" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Init Process Box -->
      <rect x="150" y="52" width="220" height="30" rx="6" fill="#f0f9ff" stroke="#0284c7" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="71" fill="#0369a1" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{init_txt}</text>
      
      <!-- Line to Loop Condition -->
      <line x1="260" y1="82" x2="260" y2="100" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Loop Condition Diamond -->
      <polygon points="260,100 350,126 260,152 170,126" fill="#fef3c7" stroke="#d97706" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="130" fill="#92400e" font-family="'Inter', sans-serif" font-size="10" font-weight="700" text-anchor="middle">{condition_txt}</text>
      
      <!-- True Branch: Down to Body -->
      <line x1="260" y1="152" x2="260" y2="170" stroke="#059669" stroke-width="1.8" marker-end="url(#arrow-green)"/>
      <text x="275" y="165" fill="#059669" font-family="'Inter', sans-serif" font-size="9" font-weight="700">TRUE</text>
      
      <!-- Body Box -->
      <rect x="160" y="170" width="200" height="30" rx="6" fill="#ecfdf5" stroke="#10b981" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="189" fill="#065f46" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{body_txt}</text>
      
      <!-- Line to Update -->
      <line x1="260" y1="200" x2="260" y2="216" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Update Box -->
      <rect x="175" y="216" width="170" height="28" rx="6" fill="#eff6ff" stroke="#3b82f6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="234" fill="#1d4ed8" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">{update_txt}</text>
      
      <!-- Loop back line from Update to Condition -->
      <line x1="175" y1="230" x2="100" y2="230" stroke="#3b82f6" stroke-width="1.8"/>
      <line x1="100" y1="230" x2="100" y2="126" stroke="#3b82f6" stroke-width="1.8"/>
      <line x1="100" y1="126" x2="168" y2="126" stroke="#3b82f6" stroke-width="1.8" marker-end="url(#arrow-blue)"/>
      <text x="130" y="120" fill="#3b82f6" font-family="'Inter', sans-serif" font-size="8.5" font-weight="700">Repeat</text>
      
      <!-- False Branch: Right to Exit -->
      <line x1="350" y1="126" x2="410" y2="126" stroke="#e11d48" stroke-width="1.8"/>
      <line x1="410" y1="126" x2="410" y2="160" stroke="#e11d48" stroke-width="1.8" marker-end="url(#arrow-rose)"/>
      <text x="375" y="120" fill="#e11d48" font-family="'Inter', sans-serif" font-size="9" font-weight="700">FALSE</text>
      
      <!-- Output / Exit Box -->
      <polygon points="345,160 475,160 460,195 330,195" fill="#ede9fe" stroke="#8b5cf6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="402" y="181" fill="#5b21b6" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">{exit_txt}</text>
      
      <!-- End Pill -->
      <line x1="402" y1="195" x2="402" y2="215" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      <rect x="355" y="217" width="95" height="28" rx="14" fill="#64748b" filter="url(#shadow)"/>
      <text x="402" y="235" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">End</text>
    </svg>
    """

def draw_sequential_flowchart(step1="Step 1: Input / Parse Data", step2="Step 2: Processing & Algorithm",
                              step3="Step 3: Verification / Boundary Check", step4="Step 4: Output / Store Result"):
    """
    Sequential execution pipeline diagram (width=520, height=240)
    """
    return f"""
    <svg class="flowchart-svg" width="520" height="240" viewBox="0 0 520 240" xmlns="http://www.w3.org/2000/svg">
      {get_svg_defs()}
      
      <rect x="210" y="8" width="100" height="28" rx="14" fill="#10b981" filter="url(#shadow)"/>
      <text x="260" y="26" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10.5" font-weight="600" text-anchor="middle">Start</text>
      
      <line x1="260" y1="36" x2="260" y2="48" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <rect x="130" y="48" width="260" height="30" rx="6" fill="#f0f9ff" stroke="#0284c7" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="67" fill="#0369a1" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{step1}</text>
      
      <line x1="260" y1="78" x2="260" y2="92" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <rect x="130" y="92" width="260" height="30" rx="6" fill="#eff6ff" stroke="#3b82f6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="111" fill="#1d4ed8" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{step2}</text>
      
      <line x1="260" y1="122" x2="260" y2="136" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <rect x="130" y="136" width="260" height="30" rx="6" fill="#f5f3ff" stroke="#7c3aed" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="155" fill="#6d28d9" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{step3}</text>
      
      <line x1="260" y1="166" x2="260" y2="180" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <polygon points="145,180 375,180 355,210 125,210" fill="#ede9fe" stroke="#8b5cf6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="250" y="199" fill="#5b21b6" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{step4}</text>
      
      <line x1="250" y1="210" x2="250" y2="218" stroke="#475569" stroke-width="1.8"/>
      
      <rect x="205" y="218" width="90" height="20" rx="10" fill="#64748b" filter="url(#shadow)"/>
      <text x="250" y="232" fill="#ffffff" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">End</text>
    </svg>
    """

def draw_two_pointer_flowchart(title="Two-Pointer Convergence Algorithm", left_init="Left = 0", right_init="Right = N - 1",
                               condition="Left < Right ?", update_left="Left++", update_right="Right--",
                               action="Evaluate / Swap(arr[Left], arr[Right])"):
    """
    Two-pointer / sliding window logic diagram (width=520, height=270)
    """
    return f"""
    <svg class="flowchart-svg" width="520" height="270" viewBox="0 0 520 270" xmlns="http://www.w3.org/2000/svg">
      {get_svg_defs()}
      
      <rect x="205" y="8" width="110" height="28" rx="14" fill="#10b981" filter="url(#shadow)"/>
      <text x="260" y="26" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10.5" font-weight="600" text-anchor="middle">Start</text>
      
      <line x1="260" y1="36" x2="260" y2="50" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Pointers Init -->
      <rect x="120" y="50" width="280" height="30" rx="6" fill="#f0f9ff" stroke="#0284c7" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="69" fill="#0369a1" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">{left_init}  |  {right_init}</text>
      
      <line x1="260" y1="80" x2="260" y2="98" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Condition -->
      <polygon points="260,98 350,124 260,150 170,124" fill="#fef3c7" stroke="#d97706" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="128" fill="#92400e" font-family="'Inter', sans-serif" font-size="10" font-weight="700" text-anchor="middle">{condition}</text>
      
      <!-- True -> Action -->
      <line x1="260" y1="150" x2="260" y2="168" stroke="#059669" stroke-width="1.8" marker-end="url(#arrow-green)"/>
      <text x="275" y="162" fill="#059669" font-family="'Inter', sans-serif" font-size="9" font-weight="700">YES</text>
      
      <rect x="130" y="168" width="260" height="30" rx="6" fill="#ecfdf5" stroke="#10b981" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="187" fill="#065f46" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">{action}</text>
      
      <line x1="260" y1="198" x2="260" y2="214" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Update pointers -->
      <rect x="150" y="214" width="220" height="28" rx="6" fill="#eff6ff" stroke="#3b82f6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="232" fill="#1d4ed8" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">{update_left} , {update_right}</text>
      
      <!-- Loop back -->
      <line x1="150" y1="228" x2="90" y2="228" stroke="#3b82f6" stroke-width="1.8"/>
      <line x1="90" y1="228" x2="90" y2="124" stroke="#3b82f6" stroke-width="1.8"/>
      <line x1="90" y1="124" x2="168" y2="124" stroke="#3b82f6" stroke-width="1.8" marker-end="url(#arrow-blue)"/>
      
      <!-- False -> Finish -->
      <line x1="350" y1="124" x2="420" y2="124" stroke="#e11d48" stroke-width="1.8"/>
      <line x1="420" y1="124" x2="420" y2="168" stroke="#e11d48" stroke-width="1.8" marker-end="url(#arrow-rose)"/>
      <text x="385" y="118" fill="#e11d48" font-family="'Inter', sans-serif" font-size="9" font-weight="700">NO</text>
      
      <polygon points="360,168 480,168 465,198 345,198" fill="#ede9fe" stroke="#8b5cf6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="412" y="187" fill="#5b21b6" font-family="'Inter', sans-serif" font-size="9" font-weight="600" text-anchor="middle">Return Array / Result</text>
      
      <line x1="412" y1="198" x2="412" y2="216" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      <rect x="365" y="216" width="94" height="26" rx="13" fill="#64748b" filter="url(#shadow)"/>
      <text x="412" y="233" fill="#ffffff" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">End</text>
    </svg>
    """

def draw_recursion_flowchart(func_name="factorial(n)", base_cond="n <= 1 ?", base_ret="Return 1",
                             rec_step="Return n * factorial(n - 1)"):
    """
    Recursion call stack & base case flowchart (width=520, height=250)
    """
    return f"""
    <svg class="flowchart-svg" width="520" height="250" viewBox="0 0 520 250" xmlns="http://www.w3.org/2000/svg">
      {get_svg_defs()}
      
      <rect x="180" y="8" width="160" height="30" rx="15" fill="#3b82f6" filter="url(#shadow)"/>
      <text x="260" y="27" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10.5" font-weight="600" text-anchor="middle">Call: {func_name}</text>
      
      <line x1="260" y1="38" x2="260" y2="58" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Base Case Diamond -->
      <polygon points="260,58 350,86 260,114 170,86" fill="#fef3c7" stroke="#d97706" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="90" fill="#92400e" font-family="'Inter', sans-serif" font-size="10" font-weight="700" text-anchor="middle">{base_cond}</text>
      
      <!-- Base Case TRUE -> Return Base Value -->
      <line x1="170" y1="86" x2="90" y2="86" stroke="#059669" stroke-width="1.8"/>
      <line x1="90" y1="86" x2="90" y2="126" stroke="#059669" stroke-width="1.8" marker-end="url(#arrow-green)"/>
      <text x="125" y="80" fill="#059669" font-family="'Inter', sans-serif" font-size="9" font-weight="700">YES (Base Case)</text>
      
      <rect x="25" y="126" width="130" height="32" rx="6" fill="#ecfdf5" stroke="#10b981" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="90" y="146" fill="#065f46" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">{base_ret}</text>
      
      <!-- Base Case FALSE -> Recursive Step -->
      <line x1="350" y1="86" x2="420" y2="86" stroke="#e11d48" stroke-width="1.8"/>
      <line x1="420" y1="86" x2="420" y2="126" stroke="#e11d48" stroke-width="1.8" marker-end="url(#arrow-rose)"/>
      <text x="385" y="80" fill="#e11d48" font-family="'Inter', sans-serif" font-size="9" font-weight="700">NO (Recurse)</text>
      
      <rect x="305" y="126" width="230" height="32" rx="6" fill="#fff1f2" stroke="#f43f5e" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="420" y="146" fill="#9f1239" font-family="'Inter', sans-serif" font-size="9" font-weight="600" text-anchor="middle">{rec_step}</text>
      
      <!-- Unwind & Combine -->
      <line x1="90" y1="158" x2="90" y2="185" stroke="#475569" stroke-width="1.8"/>
      <line x1="90" y1="185" x2="220" y2="185" stroke="#475569" stroke-width="1.8"/>
      
      <line x1="420" y1="158" x2="420" y2="185" stroke="#475569" stroke-width="1.8"/>
      <line x1="420" y1="185" x2="300" y2="185" stroke="#475569" stroke-width="1.8"/>
      
      <line x1="260" y1="185" x2="260" y2="202" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <rect x="180" y="202" width="160" height="28" rx="14" fill="#64748b" filter="url(#shadow)"/>
      <text x="260" y="220" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10" font-weight="600" text-anchor="middle">Return to Caller</text>
    </svg>
    """

def draw_state_machine_flowchart(system_name="ATM System Flow", actions=None):
    """
    Interactive State machine / Menu dispatcher diagram
    """
    if actions is None:
        actions = ["1. Deposit", "2. Withdraw", "3. Balance Inquiry", "4. Exit"]
        
    return f"""
    <svg class="flowchart-svg" width="520" height="250" viewBox="0 0 520 250" xmlns="http://www.w3.org/2000/svg">
      {get_svg_defs()}
      
      <!-- Start Pill -->
      <rect x="200" y="8" width="120" height="28" rx="14" fill="#10b981" filter="url(#shadow)"/>
      <text x="260" y="26" fill="#ffffff" font-family="'Inter', sans-serif" font-size="10.5" font-weight="600" text-anchor="middle">Authenticate PIN</text>
      
      <line x1="260" y1="36" x2="260" y2="52" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      
      <!-- Menu Dispatcher -->
      <rect x="160" y="52" width="200" height="30" rx="6" fill="#eff6ff" stroke="#3b82f6" stroke-width="1.5" filter="url(#shadow)"/>
      <text x="260" y="71" fill="#1d4ed8" font-family="'Inter', sans-serif" font-size="10" font-weight="700" text-anchor="middle">Display Menu & Read Choice</text>
      
      <!-- Multi-branch lines -->
      <line x1="260" y1="82" x2="260" y2="105" stroke="#475569" stroke-width="1.8"/>
      <line x1="70" y1="105" x2="450" y2="105" stroke="#475569" stroke-width="1.8"/>
      
      <!-- Branch 1 -->
      <line x1="70" y1="105" x2="70" y2="130" stroke="#0284c7" stroke-width="1.5" marker-end="url(#arrow)"/>
      <rect x="20" y="130" width="100" height="32" rx="6" fill="#f0f9ff" stroke="#0284c7" stroke-width="1.2" filter="url(#shadow)"/>
      <text x="70" y="150" fill="#0369a1" font-family="'Inter', sans-serif" font-size="9" font-weight="600" text-anchor="middle">{actions[0]}</text>
      
      <!-- Branch 2 -->
      <line x1="195" y1="105" x2="195" y2="130" stroke="#d97706" stroke-width="1.5" marker-end="url(#arrow)"/>
      <rect x="145" y="130" width="100" height="32" rx="6" fill="#fffbeb" stroke="#d97706" stroke-width="1.2" filter="url(#shadow)"/>
      <text x="195" y="150" fill="#92400e" font-family="'Inter', sans-serif" font-size="9" font-weight="600" text-anchor="middle">{actions[1]}</text>
      
      <!-- Branch 3 -->
      <line x1="325" y1="105" x2="325" y2="130" stroke="#059669" stroke-width="1.5" marker-end="url(#arrow)"/>
      <rect x="275" y="130" width="100" height="32" rx="6" fill="#ecfdf5" stroke="#059669" stroke-width="1.2" filter="url(#shadow)"/>
      <text x="325" y="150" fill="#065f46" font-family="'Inter', sans-serif" font-size="9" font-weight="600" text-anchor="middle">{actions[2]}</text>
      
      <!-- Branch 4 (Exit) -->
      <line x1="450" y1="105" x2="450" y2="130" stroke="#e11d48" stroke-width="1.5" marker-end="url(#arrow-rose)"/>
      <rect x="400" y="130" width="100" height="32" rx="6" fill="#fff1f2" stroke="#f43f5e" stroke-width="1.2" filter="url(#shadow)"/>
      <text x="450" y="150" fill="#9f1239" font-family="'Inter', sans-serif" font-size="9" font-weight="600" text-anchor="middle">{actions[3]}</text>
      
      <!-- Loop back from operations to Menu -->
      <line x1="70" y1="162" x2="70" y2="190" stroke="#94a3b8" stroke-width="1.5"/>
      <line x1="195" y1="162" x2="195" y2="190" stroke="#94a3b8" stroke-width="1.5"/>
      <line x1="325" y1="162" x2="325" y2="190" stroke="#94a3b8" stroke-width="1.5"/>
      <line x1="70" y1="190" x2="325" y2="190" stroke="#94a3b8" stroke-width="1.5"/>
      
      <line x1="195" y1="190" x2="195" y2="205" stroke="#94a3b8" stroke-width="1.5"/>
      <line x1="195" y1="205" x2="12" y2="205" stroke="#94a3b8" stroke-width="1.5"/>
      <line x1="12" y1="205" x2="12" y2="67" stroke="#94a3b8" stroke-width="1.5"/>
      <line x1="12" y1="67" x2="158" y2="67" stroke="#94a3b8" stroke-width="1.5" marker-end="url(#arrow)"/>
      <text x="100" y="218" fill="#64748b" font-family="'Inter', sans-serif" font-size="8.5">Return to Menu Loop</text>
      
      <!-- Exit terminates -->
      <line x1="450" y1="162" x2="450" y2="200" stroke="#475569" stroke-width="1.8" marker-end="url(#arrow)"/>
      <rect x="405" y="200" width="90" height="26" rx="13" fill="#64748b" filter="url(#shadow)"/>
      <text x="450" y="217" fill="#ffffff" font-family="'Inter', sans-serif" font-size="9.5" font-weight="600" text-anchor="middle">Session End</text>
    </svg>
    """
