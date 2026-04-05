import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args)throws IOException {
    Scanner KYBD = new Scanner(System.in);
    FileWriter file = new FileWriter("output.txt",false);
    PrintWriter output = new PrintWriter(file);

    int totalTeams = 0;
    double bestWinningAvg = 0.0;
    //double bestFinWinningAvg = 0.0;
    
    System.out.println("Please Enter Team Id:");
    int id = KYBD.nextInt();
    int team = 0;

    while(id != -1){

    System.out.println("Enter Team Wins:");
    int wins = KYBD.nextInt();

    System.out.println("Enter Team Losses:");
    int losses = KYBD.nextInt();

    //formulas 
    int gamesPlayed = wins + losses;
    int gamesLeft = 25 - gamesPlayed;
    double winningAvg = ((double) wins)/gamesPlayed;

    if(gamesPlayed > 25){
      System.out.println("\n---ERROR--- \n\n\nNew Data Required\n");

      
      System.out.println("Please Enter Team Id:");
      id = KYBD.nextInt();

      System.out.println("Enter Team  Wins:");
      wins = KYBD.nextInt();

      System.out.println("Enter Team Losses:");
      losses = KYBD.nextInt();
      
    }
      
    // prints inputted information
     output.println("\nTeam " + id + "\n" + wins + " wins  " + losses + " losses");

     output.printf("Winning Average: %, .4f", winningAvg);
      
     output.println("\nGames Played: " + gamesPlayed + "\tGames Remaining: " + gamesLeft);

      if(gamesPlayed < 25){
      double winGameRatio = ((double)wins + gamesLeft)/gamesPlayed;

      double lossGameRatio = ((double)wins)/gamesPlayed + gamesLeft;

      output.println("\nIf Team " + id + " wins the remaining games it will have a win loss ratio of " + (wins + gamesLeft) + "-" + losses);
      output.printf(" and  an average of  %, .4f", winGameRatio);

      output.println("\n\nIf Team " + id + " loses the remaining games it will have a win loss ratio of " + wins + "-" + (losses + gamesLeft));
      output.printf(" and  an average of  %, .4f", lossGameRatio);
    }

    if(gamesLeft == 0){
      output.println("Team " + id + " season is finished");
    }
    
    //Comparison of games remaining and games won
    if(gamesLeft >= wins){
      output.println("\n\nThe remaining amount of games is greater than or equal to the amount of games won");
    }
    else{
      output.println("\n\nThe remaining amount of games is not greater than  amount of games won");
    }

    //Comparison of games remaining and games lost
    if(gamesLeft > losses){
      output.println("\nThe remaining amount of games is greater than the amount of games lost");
    }
    else{
       output.println("\nThe remaining amount of games is not greater than the amount of games lost" );
    }

    //Best winning avg of teams that haven't completed a season
    if(bestWinningAvg < winningAvg && winningAvg < 1){
      bestWinningAvg = winningAvg;
      team = id;
    }

    //Counts the number of teams entered
    totalTeams += 1;


    System.out.println("\n\n");

    System.out.println("Please Enter Team Id:");
    id = KYBD.nextInt();

    if(id == -1){
      output.println("\n\n");
      output.print("The team with the best winning average is " + team);
      output.printf(" and their average is  %, .4f", bestWinningAvg);  
      output.println("\n");
      output.print("There were " + totalTeams + " teams in the league");
    }
      
    }

    output.close();
    






    
  }
}
