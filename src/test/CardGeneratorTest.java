package test;

import main.CardGenerator;
import main.Card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CardGeneratorTest {
  
  CardGenerator cards;
  
  @BeforeEach
  public void setup() {
    // Needed absolute path to cards.txt file, otherwise test would fail
    // Can't figure out how to get relative path to work
    // JUnit may not see current working directory? (works fine in main)
    cards = new CardGenerator("/Users/christian/turing/flash/cards.txt");
  }

  @Test
  public void testObjectInstance() {
    assertTrue(cards instanceof CardGenerator);
  }

  @Test
  public void testReadFile() {
    List<String> data = List.of("What is the capital of Colorado?,Denver,Geography", "What is the capital of California?,Sacramento,Geography", "Describe in words the exact direction that is 697.5° clockwise from due north?,North north west,STEM");
    assertEquals(data, cards.getCardData());
  }

  @Test
  public void testConvertedIntoCards() {
    List<Card> converted = cards.getCards();
    
    for (Card card : converted) {
      assertTrue(card instanceof Card);
    }
  }

  @Test
  public void testCardParameters() {
    List<Card> converted = cards.getCards();
    
    assertEquals("What is the capital of Colorado?", converted.get(0).getQuestion());
    assertEquals("Denver", converted.get(0).getAnswer());
    assertEquals("Geography", converted.get(0).getCategory());
  }
}
