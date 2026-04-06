import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    Scanner KYBD = new Scanner(System.in);
    PrintWriter output = null;
    Scanner dataScan = null;

    // File Handling With Error Checking
    try {
      dataScan = new Scanner(new File("DataFile.txt"));
      output = new PrintWriter(new FileWriter("output.txt"));
    } catch (IOException e) {
      System.out.println("Error: Could not open file.");
      return;
    }

    // Preview File 
    try {
      Scanner preview = new Scanner(new File("DataFile.txt"));
      System.out.println("Data used:");
      while (preview.hasNextLine()) {
        System.out.println(preview.nextLine());
      }
      preview.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("Error reading preview.");
    }

    // Input validation for size
    int size = 0; 
    while (true) {
      System.out.print("Enter number of values (1-50): ");

      if (KYBD.hasNextInt()) {
        size = KYBD.nextInt();

        if (size >= 1 && size <= 50) {
          break;
        }
        else {
          System.out.println("Please enter a number between 1 and 50.");
        }
      }
      else {
        System.out.println("Invalid input. Enter a number.");
        KYBD.next(); //clear bad input
      }
    }

    double[] first = new double[size];

    // Reads Data 
    readData(size, first, dataScan);

    // Prints Original Array
    output.println("Here Is The Original Array");
    printArray(size, first, output);

    // Average 
    double avg = findAverage(size, first);
    output.printf("\nThe Arrays Average Is %.2f\n", avg);

    // Distance Analysis
    output.println("\nDistance Analysis:");
    analyzeDistances(size, first, avg, output);

    // Create New Array
    double[] second = new double[size];
    howFarAway(size, avg, first, second);

    // Prints New Array
    output.println("\nHere Is The New Array: ");
    printArray(size, second, output);

    // New Average
    avg = findAverage(size, second);
    output.printf("\nThe New Arrays Average Is %.2f\n", avg);

    // New Distance Analysis
    output.println("\nDistance Analysis:");
    analyzeDistances(size, second, avg, output);

    // Clean Up
    output.close();
    dataScan.close();
    KYBD.close();
  }

  // Prints An Array Neatly 5 Values Per Line
  public static void printArray(int n, double[] arr, PrintWriter out) {
    for (int i = 0; i < n; i++) {
        out.printf("%10.2f", arr[i]);
        if ((i + 1) % 5 == 0 || i == n - 1) {  // break line after 5 values or at the end
            out.println();
        }
    }
}

  // Reads Data From Files
  public static void readData(int n, double[] numbers, Scanner dataScan){
    int i = 0;

    while (i < n && dataScan.hasNextDouble()) {
      numbers[i] = dataScan.nextDouble();
      i++;
    }

    if (i < n) {
      System.out.println("Warning: Not enough data in file. Remaing values set to 0.");
    }
  }

  // Find Average
  public static double findAverage(int k, double[] p) {
    double sum = 0;

    if (k == 0) return 0;

    for (int i = 0; i < k; i++) {
      sum += p[i];
    }
    
    return sum / k;
  }

  // Build New Array
  public static void howFarAway(int m, double avg, double[] r, double[] s) {
    for (int i = 0; i < m; i++) {
      s[i] = avg - r[i];
    }
  }

  // Finds Closest and furthest values from avarage
  public static void analyzeDistances(int n, double [] arr, double avg, PrintWriter out) {
    double closest = arr[0];
    double furthest = arr[0];

    double minDiff = Math.abs(arr[0] - avg);
    double maxDiff = Math.abs(arr[0] - avg);

    for (int i = 1; i < n; i++) {
      double diff = Math.abs(arr[i] - avg);
      
      if (diff < minDiff){
        minDiff = diff;
        closest = arr[i];
      }

      if (diff > maxDiff) {
        maxDiff = diff;
        furthest = arr[i];
      }
    }

    out.printf("\nClosest value to average: %.2f (distance: %.2f)\n", closest, minDiff);
    out.printf("Furthest value to average: %.2f (distance: %.2f)\n", furthest, maxDiff);
  }
}
