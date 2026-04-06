📄 Array Data Analyzer
Overview

The Array Data Analyzer is a Java program that reads numerical data from an external file, processes it in arrays, and outputs structured results to a file. The program demonstrates modular programming concepts, including methods for reading, printing, transforming, and analyzing arrays.

It also includes optional statistical analysis to determine which values are closest to and furthest from the array’s average.

Features
Reads a user-specified number of values from an external file (DataFile.txt)
Prints the original array in neatly formatted columns (5 values per row)
Calculates and prints the average of array values
Constructs a new array representing each value’s difference from the average
Prints the new array and its average
Computes and prints the closest and furthest values from the average (optional analysis)
Outputs all results to a file (output.txt) for easy review
Requirements
Java 8 or higher
DataFile.txt containing numeric values (at least as many as the user-specified array size)
Write permissions to create output.txt
Usage
Ensure DataFile.txt exists in the same folder as the program, containing numeric values separated by spaces or newlines.
Compile the program:
javac Main.java
Run the program:
java Main
Enter the number of values to read (e.g., 12–50).
The program will read the data, perform calculations, and generate an output file named output.txt.
Review output.txt for the original array, new array, averages, and distance analysis.
Example Output

Original Array:

     5.00      3.00      2.00      8.00      4.00

Array Average:

The Array Average Is 4.40

Distance Analysis:

Closest value to average: 4.00 (distance: 0.40)
Furthest value from average: 8.00 (distance: 3.60)

New Array (difference from average):

    -0.40      1.40      2.40     -3.60      0.40

New Array Average:

The New Array Average Is 0.00

Distance Analysis (New Array):

Closest value to average: 0.00 (distance: 0.00)
Furthest value from average: -3.60 (distance: 3.60)
Project Structure
Main.java           # Main Java program with all methods
DataFile.txt        # Input data file
output.txt          # Generated output file
README.md           # Project documentation
Notes
The program includes input validation to ensure the user enters a valid number of values.
If the file contains fewer numbers than requested, remaining array positions are set to zero.
All outputs are written to output.txt and formatted with two decimal places.
Author

[Your Name] – Developed as a Java learning project focusing on arrays, file I/O, and statistical analysis.
