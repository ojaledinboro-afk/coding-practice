# Baseball Stats Analyzer

## Overview
The **Baseball Stats Analyzer** is a simple Java console program that allows users to input baseball team data, calculate key statistics, and generate a detailed report for each team. The program also tracks the team with the best winning average among teams that have not completed their season. All output is written to a file called `output.txt`.
---

## Features
- Input multiple teams’ data (team ID, wins, losses) until the user signals completion with `-1`.
- Validate inputs: 
  - Wins and losses must be non-negative integers.
  - Total games played cannot exceed 25.
- Calculate statistics for each team:
  - Total games played
  - Games remaining
  - Winning average (formatted to 4 decimal places)
  - Potential outcomes if the team wins or loses remaining games
- Comparison messages:
  - Whether remaining games are greater than or equal to games won
  - Whether remaining games are greater than games lost
- Track and display the team with the highest winning average for incomplete seasons.
- Output all results to `output.txt`.

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any IDE (IntelliJ, Eclipse) or command-line setup for running Java programs

### Running the Program
1. Compile the Java program:

```bash
javac Main.java
