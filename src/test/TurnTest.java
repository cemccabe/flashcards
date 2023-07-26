package test;

import main.Turn;
import main.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnTest {
  
  private Card card;
  private Turn turn;

  @BeforeEach
  public void setup() {
    card = new Card("What is the capital of Colorado?", "Denver", "Geography");
    turn = new Turn("Denver", card);
  }

  @Test
  public void testObjectInstance() {
    assertTrue(turn instanceof Turn);
  }

  @Test
  public void testGuess() {
    assertEquals("Denver", turn.getGuess());
  }

  @Test
  public void testCard() {
    assertEquals(card, turn.getCard());
  }

  @Test
  public void testIsCorrect() {
    assertTrue(turn.isCorrect());
  }

  @Test
  public void testCorrectFeedback() {
    assertEquals("Correct!", turn.feedback());
  }

  @Test
  public void testIsIncorrect() {
    turn.setGuess("Boulder");
    assertEquals(false, turn.isCorrect());
  }

  @Test
  public void testIncorrectFeedback() {
    turn.setGuess("Boulder");
    assertEquals("Incorrect.", turn.feedback());
  }
}
