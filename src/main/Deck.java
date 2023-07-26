package main;

import java.util.List;
import java.util.ArrayList;

public class Deck {
  private List<Card> cards;

  public Deck(List<Card> cards) {
    this.cards = cards;
  }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public int count() {
    return cards.size();
  }

  public List<Card> cardsInCategory(String category) {
    List<Card> cardList = new ArrayList<Card>();
    for (Card card : cards) {
      if (card.getCategory().equals(category)) {
        cardList.add(card);
      }
    }
    return cardList;
  }
}
