package main;

public class Turn {
  private String guess;
  private Card card;

  public Turn(String guess, Card card) {
    this.guess = guess;
    this.card = card;
  }

  public String getGuess() {
    return guess;
  }

  public void setGuess(String guess) {
    this.guess = guess;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public boolean isCorrect() {
    return guess.equals(card.getAnswer());
  }

  public String feedback() {
    if (isCorrect()) {
      return "Correct!";
    } 
    else {
      return "Incorrect.";
    }
  }
}
