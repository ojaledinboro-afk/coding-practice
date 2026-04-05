import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner KYBD = new Scanner(System.in);
    FileWriter file = new FileWriter("output.txt", false);
    PrintWriter output = new PrintWriter(file);

    File data = new File("DataFile.txt");
    Scanner dataScan = new Scanner(data);

    Scanner input = new Scanner(new File("DataFile.txt"));

    System.out.println("Data used:");
    while (input.hasNextLine()) {
      System.out.println(input.nextLine());
    }

    int a = 50;

    System.out.println("Enter Number");
    int size = KYBD.nextInt();
    double[] first = new double[a];

    // Reads Data For Array
    readData(size, first);

    // Prints Out Array
    output.println("Here Is The Original Array");
    printArray(size, first, output);

    // Finds Average Of Array
    double avg = findAverage(size, first);
    output.println("");
    output.printf("The Arrays Average Is %.1f", avg);

    // New Array
    double[] second = new double[a];
    howFarAway(size, avg, first, second);

    // Prints Out New Array
    output.println("\n\nHere Is The New Array");
    printArray(size, second, output);

    // Finds Average Of New Array
    avg = findAverage(size, second);
    output.println("");
    output.printf("The New Arrays Average Is %.1f", avg);

    output.close();

  }

  // Reads in Numbers Entered
  public static void readData(int n, double[] numbers) throws IOException {
    File data = new File("DataFile.txt");
    Scanner dataScan = new Scanner(data);

    for (int i = 0; i < n; i++) {
      numbers[i] = dataScan.nextDouble();
    }
  }

  // Prints Out The Array In Rows And Coloums
  public static void printArray(int q, double[] numb, PrintWriter a) {
    int i = 0;
    while (i < q) {
      for (int row = 0; row < (q / 5); row++) {
        for (int col = 0; col < 5; col++) {
          a.printf("%10.1f", numb[i]);
          i++;
        }
        a.println();
      }
    }

  }

  // Finds The Average Of The Array
  public static double findAverage(int k, double[] p) {
    double sum = 0;
    double avg = 0;

    for (int i = 0; i < k; i++) {
      sum += p[i];
    }
    sum = 0.1 * Math.floor(sum * 10.0);
    avg = sum / k;
    avg = 0.1 * Math.floor(avg * 10.0);
    return avg;
  }

  // Makes New Array
  public static void howFarAway(int m, double avg, double[] r, double[] s) {
    for (int i = 0; i < m; i++) {
      s[i] = r[i] - avg;
    }
  }
}
