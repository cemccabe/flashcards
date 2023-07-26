package test;

import main.Round;
import main.Deck;
import main.Turn;
import main.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RoundTest {
  private Card card1, card2, card3;
  private Deck deck;
  private Round round;

  @BeforeEach
  public void setup() {
    card1 = new Card("What is the capital of Colorado?", "Denver", "Geography");
    card2 = new Card("What is the capital of California?", "Sacramento", "Geography");
    card3 = new Card("Describe in words the exact direction that is 697.5° clockwise from due north?", "North north west", "STEM");
    List<Card> cards = List.of(card1, card2, card3);

    deck = new Deck(cards);
    round = new Round(deck);
  }

  @Test
  public void testObjectInstance() {
    assertTrue(round instanceof Round);
  }

  @Test
  public void testDeck() {
    assertEquals(deck, round.getDeck());
  }

  @Test
  public void testEmptyDefaultTurns() {
    assertEquals(0, round.getTurns().size());
  }

  @Test
  public void testEmptyDefaultCorrectTurns() {
    assertEquals(0, round.getCorrectTurns().size());
  }
  
  @Test
  public void testTakeTurnInstance() {
    assertTrue(round.takeTurn("Denver") instanceof Turn);
  }

  @Test
  public void testCurrentCard() {
    assertEquals(card1, round.currentCard());
    
    round.takeTurn("Denver");
    assertEquals(card2, round.currentCard());

    round.takeTurn("Sacramento");
    assertEquals(card3, round.currentCard());
  }

  @Test
  public void testCountTurnsTaken() {
    round.takeTurn("Denver");
    assertEquals(1, round.getTurns().size());

    round.takeTurn("Sacramento");
    assertEquals(2, round.getTurns().size());
  }

  @Test
  public void testNumberCorrect() {
    round.takeTurn("Denver");
    round.takeTurn("Sacramento");
    round.takeTurn("WRONG");

    assertEquals(2, round.numberCorrect());
  }

  @Test
  public void testNumberCorrectByCategory() {
    round.takeTurn("Denver");
    round.takeTurn("Sacramento");
    round.takeTurn("North north west");

    assertEquals(2, round.numberCorrectByCategory("Geography"));
    assertEquals(1, round.numberCorrectByCategory("STEM"));
  }

  @Test
  public void testPercentCorrect() {
    round.takeTurn("Denver");
    assertEquals(100.0, round.percentCorrect());

    round.takeTurn("WRONG");
    assertEquals(50.0, round.percentCorrect());
  }

  @Test
  public void testPercentCorrectByCategory() {
    round.takeTurn("Denver");
    round.takeTurn("WRONG");
    round.takeTurn("North north west");

    assertEquals(50.0, round.percentCorrectByCategory("Geography"));
    assertEquals(100.0, round.percentCorrectByCategory("STEM"));
  }
}
