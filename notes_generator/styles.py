"""
CSS and Layout Styles for Core Java Complete Notes PDF & HTML
"""

MAIN_CSS = """
@import url('https://fonts.googleapis.com/css2?family=Fira+Code:wght@400;500;600&family=Inter:wght@300;400;500;600;700;800&display=swap');

:root {
  --primary: #2563eb;
  --primary-dark: #1d4ed8;
  --primary-light: #eff6ff;
  --secondary: #4f46e5;
  --text-main: #0f172a;
  --text-muted: #475569;
  --text-light: #94a3b8;
  --bg-page: #f8fafc;
  --bg-card: #ffffff;
  --border-color: #e2e8f0;
  --border-dark: #cbd5e1;
  --accent-green: #059669;
  --accent-green-bg: #ecfdf5;
  --accent-amber: #d97706;
  --accent-amber-bg: #fffbeb;
  --accent-purple: #7c3aed;
  --accent-purple-bg: #f5f3ff;
  --accent-rose: #e11d48;
  --accent-rose-bg: #fff1f2;
  --code-bg: #0f172a;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
  color: var(--text-main);
  background-color: var(--bg-page);
  line-height: 1.55;
  font-size: 13.5px;
  -webkit-print-color-adjust: exact;
  print-color-adjust: exact;
}

@page {
  size: A4;
  margin: 15mm 14mm 16mm 14mm;
  @bottom-right {
    content: "Page " counter(page);
    font-family: 'Inter', sans-serif;
    font-size: 8.5pt;
    font-weight: 500;
    color: #64748b;
  }
  @bottom-left {
    content: "Core Java Comprehensive Study Notes & Problem-Solving Handbook";
    font-family: 'Inter', sans-serif;
    font-size: 8.5pt;
    color: #94a3b8;
  }
}

@page :first {
  margin: 0;
  @bottom-right { content: normal; }
  @bottom-left { content: normal; }
}

.page-break {
  page-break-after: always;
  break-after: page;
}

/* ================== COVER PAGE ================== */
.cover-page {
  width: 100%;
  min-height: 297mm;
  height: 297mm;
  background: linear-gradient(135deg, #0f172a 0%, #1e1b4b 50%, #0f172a 100%);
  color: #ffffff;
  padding: 50mm 24mm 24mm 24mm;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  position: relative;
  overflow: hidden;
  page-break-after: always;
  break-after: page;
}

.cover-page::before {
  content: "";
  position: absolute;
  top: -100px;
  right: -100px;
  width: 400px;
  height: 400px;
  background: radial-gradient(circle, rgba(59, 130, 246, 0.25) 0%, rgba(0,0,0,0) 70%);
  border-radius: 50%;
}

.cover-page::after {
  content: "";
  position: absolute;
  bottom: -80px;
  left: -80px;
  width: 350px;
  height: 350px;
  background: radial-gradient(circle, rgba(124, 58, 237, 0.25) 0%, rgba(0,0,0,0) 70%);
  border-radius: 50%;
}

.cover-top {
  position: relative;
  z-index: 2;
}

.cover-badge {
  display: inline-block;
  padding: 6px 14px;
  background: rgba(59, 130, 246, 0.2);
  border: 1px solid rgba(96, 165, 250, 0.4);
  border-radius: 9999px;
  color: #93c5fd;
  font-size: 11px;
  font-weight: 700;
  letter-spacing: 1.5px;
  text-transform: uppercase;
  margin-bottom: 22px;
}

.cover-title {
  font-size: 34pt;
  font-weight: 800;
  line-height: 1.15;
  letter-spacing: -0.5px;
  background: linear-gradient(to right, #ffffff, #93c5fd, #c084fc);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  margin-bottom: 16px;
}

.cover-subtitle {
  font-size: 14pt;
  font-weight: 400;
  color: #cbd5e1;
  line-height: 1.5;
  max-width: 650px;
  margin-bottom: 28px;
}

.cover-highlights {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 12px;
  margin-top: 15px;
  max-width: 600px;
}

.cover-pill {
  display: flex;
  align-items: center;
  gap: 10px;
  background: rgba(255, 255, 255, 0.06);
  border: 1px solid rgba(255, 255, 255, 0.12);
  padding: 9px 14px;
  border-radius: 8px;
  font-size: 11.5px;
  color: #e2e8f0;
}

.cover-pill-icon {
  width: 20px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #3b82f6;
  border-radius: 50%;
  font-size: 10px;
  font-weight: bold;
}

.cover-footer {
  position: relative;
  z-index: 2;
  border-top: 1px solid rgba(255, 255, 255, 0.15);
  padding-top: 20px;
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
}

.cover-meta h4 {
  font-size: 13px;
  font-weight: 600;
  color: #f1f5f9;
}

.cover-meta p {
  font-size: 11px;
  color: #94a3b8;
  margin-top: 3px;
}

.cover-stats {
  display: flex;
  gap: 20px;
}

.stat-item {
  text-align: right;
}

.stat-num {
  font-size: 18pt;
  font-weight: 800;
  color: #60a5fa;
}

.stat-label {
  font-size: 9.5px;
  color: #94a3b8;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

/* ================== TABLE OF CONTENTS ================== */
.toc-container {
  padding: 10px 0;
}

.toc-title {
  font-size: 20pt;
  font-weight: 800;
  color: #0f172a;
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  gap: 10px;
  border-bottom: 2px solid var(--border-color);
  padding-bottom: 12px;
}

.toc-subtitle {
  color: var(--text-muted);
  font-size: 12px;
  margin-bottom: 20px;
}

.toc-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 12px;
}

.toc-card {
  background: var(--bg-card);
  border: 1px solid var(--border-color);
  border-radius: 8px;
  padding: 10px 14px;
  box-shadow: 0 1px 2px rgba(0,0,0,0.03);
}

.toc-card-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 6px;
}

.toc-card-num {
  font-size: 10px;
  font-weight: 700;
  color: var(--primary);
  background: var(--primary-light);
  padding: 2px 7px;
  border-radius: 4px;
}

.toc-card-count {
  font-size: 9.5px;
  color: var(--text-light);
}

.toc-card-title {
  font-size: 12.5px;
  font-weight: 700;
  color: var(--text-main);
  margin-bottom: 4px;
}

.toc-card-desc {
  font-size: 10.5px;
  color: var(--text-muted);
  line-height: 1.4;
}

/* ================== MODULE HEADER ================== */
.module-header {
  background: linear-gradient(135deg, #1e293b 0%, #0f172a 100%);
  color: #ffffff;
  padding: 18px 22px;
  border-radius: 10px;
  margin-top: 15px;
  margin-bottom: 22px;
  box-shadow: 0 3px 6px rgba(0,0,0,0.08);
  page-break-after: avoid;
  break-after: avoid;
}

.module-header-badge {
  display: inline-block;
  font-size: 10px;
  font-weight: 700;
  letter-spacing: 1px;
  text-transform: uppercase;
  color: #60a5fa;
  background: rgba(59, 130, 246, 0.15);
  border: 1px solid rgba(96, 165, 250, 0.3);
  padding: 3px 9px;
  border-radius: 4px;
  margin-bottom: 8px;
}

.module-header-title {
  font-size: 18pt;
  font-weight: 800;
  color: #ffffff;
  margin-bottom: 6px;
}

.module-header-desc {
  font-size: 12px;
  color: #cbd5e1;
  line-height: 1.5;
}

/* ================== PROBLEM CARD ================== */
.problem-card {
  background: var(--bg-card);
  border: 1px solid var(--border-color);
  border-radius: 10px;
  padding: 16px 18px;
  margin-bottom: 22px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.04);
  page-break-inside: avoid;
  break-inside: avoid;
}

.problem-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  border-bottom: 1px solid var(--border-color);
  padding-bottom: 10px;
  margin-bottom: 12px;
}

.problem-title-group h3 {
  font-size: 15pt;
  font-weight: 700;
  color: var(--text-main);
  display: flex;
  align-items: center;
  gap: 8px;
}

.problem-files {
  font-family: 'Fira Code', monospace;
  font-size: 10.5px;
  color: var(--primary-dark);
  background: var(--primary-light);
  padding: 3px 8px;
  border-radius: 4px;
  display: inline-block;
  margin-top: 4px;
}

.problem-meta {
  display: flex;
  gap: 6px;
  align-items: center;
}

.badge {
  font-size: 9.5px;
  font-weight: 600;
  padding: 3px 8px;
  border-radius: 4px;
  letter-spacing: 0.3px;
}

.badge-time {
  background: #f0fdf4;
  color: #166534;
  border: 1px solid #bbf7d0;
}

.badge-space {
  background: #faf5ff;
  color: #6b21a8;
  border: 1px solid #e9d5ff;
}

.badge-category {
  background: #f8fafc;
  color: #475569;
  border: 1px solid #e2e8f0;
}

/* Section blocks */
.section-block {
  margin-bottom: 12px;
}

.section-label {
  font-size: 11px;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 0.7px;
  color: var(--text-muted);
  margin-bottom: 5px;
  display: flex;
  align-items: center;
  gap: 6px;
}

.def-box {
  background: #f8fafc;
  border-left: 3.5px solid var(--primary);
  padding: 9px 12px;
  border-radius: 0 6px 6px 0;
  font-size: 12px;
  color: var(--text-main);
  line-height: 1.5;
}

.def-box p {
  margin-bottom: 5px;
}
.def-box p:last-child {
  margin-bottom: 0;
}

/* Flowchart block */
.flowchart-wrapper {
  background: #f8fafc;
  border: 1px solid var(--border-color);
  border-radius: 8px;
  padding: 10px;
  text-align: center;
  overflow: hidden;
  margin-bottom: 12px;
}

.flowchart-svg {
  max-width: 100%;
  height: auto;
  display: inline-block;
  vertical-align: middle;
}

/* Code block */
.code-container {
  background: var(--code-bg);
  border-radius: 8px;
  padding: 11px 14px;
  margin-bottom: 12px;
  overflow: hidden;
  box-shadow: inset 0 1px 2px rgba(0,0,0,0.2);
}

.code-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 8px;
  border-bottom: 1px solid rgba(255,255,255,0.1);
  padding-bottom: 5px;
}

.code-title {
  font-family: 'Fira Code', monospace;
  font-size: 10px;
  color: #94a3b8;
}

.code-lang {
  font-size: 9px;
  font-weight: 700;
  color: #38bdf8;
  background: rgba(56, 189, 248, 0.15);
  padding: 2px 6px;
  border-radius: 3px;
  text-transform: uppercase;
}

pre.code-block {
  font-family: 'Fira Code', 'JetBrains Mono', Consolas, monospace;
  font-size: 10.5px;
  line-height: 1.45;
  color: #e2e8f0;
  white-space: pre-wrap;
  word-break: break-word;
}

/* Syntax colors */
.kw { color: #f43f5e; font-weight: 600; } /* keyword */
.tp { color: #38bdf8; font-weight: 500; } /* type */
.fn { color: #a855f7; } /* function */
.str { color: #4ade80; } /* string */
.num { color: #fb923c; } /* number */
.cm { color: #64748b; font-style: italic; } /* comment */
.ann { color: #eab308; } /* annotation */

/* Steps & Logic */
.steps-list {
  padding-left: 18px;
  font-size: 11.5px;
  color: var(--text-main);
  line-height: 1.5;
}

.steps-list li {
  margin-bottom: 4px;
}

/* Sample IO */
.io-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 8px;
  margin-bottom: 10px;
}

.io-box {
  background: #f1f5f9;
  border-radius: 6px;
  padding: 7px 10px;
  border: 1px solid var(--border-color);
}

.io-label {
  font-size: 9.5px;
  font-weight: 700;
  text-transform: uppercase;
  color: var(--text-muted);
  margin-bottom: 3px;
}

.io-content {
  font-family: 'Fira Code', monospace;
  font-size: 10px;
  color: #0f172a;
  white-space: pre-wrap;
}

/* Edge cases alert */
.edge-case-box {
  background: var(--accent-amber-bg);
  border: 1px solid #fde68a;
  border-left: 3.5px solid var(--accent-amber);
  border-radius: 0 6px 6px 0;
  padding: 7px 11px;
  font-size: 11px;
  color: #92400e;
  line-height: 1.45;
}

.edge-case-title {
  font-weight: 700;
  margin-bottom: 2px;
  display: flex;
  align-items: center;
  gap: 5px;
}
"""
