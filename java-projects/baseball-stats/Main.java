import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args)throws IOException {
    Scanner KYBD = new Scanner(System.in);
    PrintWriter output = new PrintWriter(new FileWriter("output.txt", false));

    int totalTeams = 0;
    double bestWinningAvg = 0.0;
    int bestTeamId = 0;
    
    System.out.println("Enter Team Id (-1 to finish):");
    int id = KYBD.nextInt();

    while (id != -1) {
    
      //Input Wins and Losses
      int wins = readNonNegative("Enter Team Wins:", KYBD);
      int losses =  readNonNegative("Enter Team Losses:", KYBD);

      int gamesPlayed = wins + losses;

      //Validate max games played
      while (gamesPlayed > 25) {
        System.out.println("\n---ERROR-- \nTotal games cannot exceed 25. Re-enter data.");
        wins = readNonNegative("Enter Team Wins:", KYBD);
        losses = readNonNegative("Enter Team Losses:", KYBD);
        gamesPlayed = wins + losses;
      }

      int gamesLeft = 25 - gamesPlayed;
      double winningAvg = (double) wins / gamesPlayed;

      // Print report to file
      printTeamReport(output, id, wins, losses, gamesPlayed, gamesLeft, winningAvg);

      // Update best winning average for incomplete seasons
      if (winningAvg < 1 && winningAvg > bestWinningAvg) {
        bestWinningAvg = winningAvg;
        bestTeamId = id;
      }

      totalTeams++;
      System.out.println("\nEnter Team Id (-1 to finish):");
      id = KYBD.nextInt();
    }

    //Summary at the end
    output.println("\n\nSummary:");
    output.printf("Team with the best winning average: %d (%.4f)\n", bestTeamId, bestWinningAvg);
    output.print("Total teams in league: " + totalTeams);

    output.close();
    KYBD.close();
  }

  // Reads non-negative integer input
  public static int readNonNegative(String prompt, Scanner sc) {
    int value = -1;
    while (value < 0) {
      System.out.println(prompt);
      if (sc.hasNextInt()) {
        value = sc.nextInt();
        if (value < 0) {
          System.out.println("Please enter a non-negative value.");
        }
      }
      else {
        System.out.println("Invalid input. Please enter a number.");
        sc.next();   // clear invalid input      
        }
    }
    return value;
  }

  // Prints team report
  public static void printTeamReport(PrintWriter output, int id, int wins, int losses, int gamesPlayed, int gamesLeft, double winningAvg){
    output.printf("\nTeam %d\n", id);
    output.printf("%d wins  %d losses\n", wins, losses);
    output.printf("Games Played: %d\tGames Remaining: %d\n", gamesPlayed, gamesLeft);
    output.printf("Winning Average: %.4f\n", winningAvg);

    if (gamesLeft > 0) {
      output.printf("\nIf team %d wins remaining games: %d-%d, avg %.4f\n", id, wins + gamesLeft, losses, (double)(wins +  gamesLeft)/(gamesPlayed +  gamesLeft));
      output.printf("If team %d loses remaining games: %d-%d, avg %.4f\n", id, wins, losses + gamesLeft, (double)wins/(gamesPlayed +  gamesLeft));
    }
    else {
      output.printf("Team %d season is finished. \n", id);
    }

    // Comparisons
    if (gamesLeft >= wins) {
      output.println("The remaining amount of games is greater than or equal to the amount of games won.");
    } 
    else {
      output.println("The remaining amount of games is not greater than the amount of games won.");
    }

    if (gamesLeft > losses) {
      output.println("The remaining amount of games is greater than the amount of games lost.");
    } 
    else {
      output.println("The remaining amount of games is not greater than the amount of games lost.");
    }
  }

}
