package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashCardsRunner {

  private Round round;
  private List<String> categoriesPlayed;
  
  public FlashCardsRunner(String filename) {
    this.round = new Round(new Deck(new CardGenerator(filename).getCards()));
    this.categoriesPlayed = new ArrayList<String>();
  };

  public void start() {
    System.out.println();
    System.out.println("Welcome! You're playing with " + round.getDeck().getCards().size() + " cards.");
    System.out.println("-------------------------------------------------");
    gameTakeTurn();
  }

  public void gameTakeTurn() {
    Scanner scanner = new Scanner(System.in);
    
    for (int i = 0; i < round.getDeck().getCards().size(); i++) {
      System.out.println("This is card number " + (i + 1) + " out of " + round.getDeck().getCards().size() + ".");
      System.out.println("Question: " + round.currentCard().getQuestion());
      
      if (!categoriesPlayed.contains(round.currentCard().getCategory())) {
        categoriesPlayed.add(round.currentCard().getCategory());
      }
      
      String guess = scanner.nextLine().trim();

      round.takeTurn(guess);
      
      System.out.println(round.getTurns().get(round.getTurns().size() - 1).feedback());
      System.out.println();
    }

    scanner.close();

    gameOver();
  }

  public void gameOver() {
    System.out.println("****** Game over! ******");
    System.out.println("You had " + round.numberCorrect() + " correct guesses out of " + round.getDeck().getCards().size() + " for a total score of " + (int) round.percentCorrect() + "%.");
    
    for (String category : categoriesPlayed) {
      System.out.println(category + " - " + round.numberCorrectByCategory(category) + "/" + round.getDeck().getCards().stream().filter(card -> card.getCategory().equals(category)).count() + " correct");
    }
  }
  
  public static void main(String[] args) {
    FlashCardsRunner runner = new FlashCardsRunner("cards.txt");
    runner.start();
  }
}