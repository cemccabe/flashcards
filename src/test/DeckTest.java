package test;

import main.Deck;
import main.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class DeckTest {
  private Deck deck;
  private Card card1, card2, card3;

  @BeforeEach
  public void setup() {
    card1 = new Card("What is the capital of Colorado?", "Denver", "Geography");
    card2 = new Card("What is the capital of California?", "Sacramento", "Geography");
    card3 = new Card("Describe in words the exact direction that is 697.5° clockwise from due north?", "North north west", "STEM");

    List<Card> cards = List.of(card1, card2, card3);
    // List<Card> cards = new ArrayList<Card>();
    // cards.add(card1);
    // cards.add(card2);
    // cards.add(card3);

    deck = new Deck(cards);
  }

  @Test
  public void testObjectInstance() {
    assertTrue(deck instanceof Deck);
  }

  @Test
  public void testCountMethod() {
    assertEquals(3, deck.count());
  }

  @Test
  public void testCardsInCategory() {
    List<Card> expected = List.of(card1, card2);
    assertEquals(expected, deck.cardsInCategory("Geography"));
  }
}
