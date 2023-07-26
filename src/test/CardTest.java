package test;

import main.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTest {

  private Card card;

  @BeforeEach
  public void setup() {
    card = new Card("What is the capital of Colorado?", "Denver", "Geography");
  }

  @Test
  public void testObjectInstance() {
    assertTrue(card instanceof Card);
  }

  @Test
  public void testQuestion() {
    assertEquals("What is the capital of Colorado?", card.getQuestion());
  }

  @Test
  public void testAnswer() {
    assertEquals("Denver", card.getAnswer());
  }

  @Test
  public void testCategory() {
    assertEquals("Geography", card.getCategory());
  }
}
