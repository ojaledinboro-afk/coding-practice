# Array Data Analyzer

## Overview
The **Array Data Analyzer** is a Java program that reads numerical data from an external file, processes it in arrays, and outputs structured results to a file. The program demonstrates modular programming concepts, including methods for reading, printing, transforming, and analyzing arrays.  

It also includes optional statistical analysis to determine which values are closest to and furthest from the array’s average.

---

## Features

- Reads a user-specified number of values from an external file (`DataFile.txt`)  
- Prints the original array in neatly formatted columns (5 values per row)  
- Calculates and prints the average of array values  
- Constructs a new array representing each value’s difference from the average  
- Prints the new array and its average  
- Computes and prints the closest and furthest values from the average (optional analysis)  
- Outputs all results to a file (`output.txt`) for easy review  
- Input validation ensures users enter valid array sizes  
- File error handling prevents crashes if `DataFile.txt` is missing  

---

## Requirements

- Java 8 or higher  
- `DataFile.txt` containing numeric values (at least as many as the user-specified array size)  
- Write permissions to create `output.txt`  

---

## Setup & Installation

1. Clone or download this repository.  
2. Place your `DataFile.txt` in the same folder as `Main.java`.  
3. Ensure Java is installed on your system. You can check by running:  
```bash
java -version
