package main;

import java.util.List;
import java.util.ArrayList;


public class Round {
  
  private Deck deck;
  private List<Turn> turns;
  private List<Turn> correctTurns;

  public Round(Deck deck) {
    this.deck = deck;
    this.turns = new ArrayList<Turn>();
    this.correctTurns = new ArrayList<Turn>();
  }

  public Deck getDeck() {
    return deck;
  }

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public List<Turn> getTurns() {
    return turns;
  }

  public void setTurns(List<Turn> turns) {
    this.turns = turns;
  }

  public List<Turn> getCorrectTurns() {
    return correctTurns;
  }

  public void setCorrectTurns(List<Turn> correctTurns) {
    this.correctTurns = correctTurns;
  }

  public Card currentCard() {
    return deck.getCards().get(turns.size());
  }
  
  public Turn takeTurn(String guess) {
    turns.add(new Turn(guess, currentCard()));
    if (turns.get(turns.size() - 1).isCorrect()) {
      correctTurns.add(turns.get(turns.size() - 1));
    }
    return turns.get(turns.size() - 1);
  }

  public int numberCorrect() {
    return correctTurns.size();
  }

  public int numberCorrectByCategory(String category) {
    return (int) correctTurns.stream().filter(turn -> turn.getCard().getCategory().equals(category)).count();
  }

  public double percentCorrect() {
    return (double) numberCorrect() / turns.size() * 100;
  }

  public double percentCorrectByCategory(String category) {
    return (double) numberCorrectByCategory(category) / deck.cardsInCategory(category).size() * 100;
  }
}
