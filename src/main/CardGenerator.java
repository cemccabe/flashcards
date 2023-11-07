package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGenerator {
  private String filename;
  private List<String> cardData;
  private List<Card> cards;

  public CardGenerator(String filename) {
    this.filename = filename;
    this.cardData = new ArrayList<String>();
    this.cards = new ArrayList<Card>();

    File file = new File(filename);
    
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String trimmedLine = line.trim();
        cardData.add(trimmedLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (String card : cardData) {
      String[] cardInput = card.split(",");
      cards.add(new Card(cardInput[0], cardInput[1], cardInput[2]));
    }

    //Collections.shuffle(cards);
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public List<String> getCardData() {
    return cardData;
  }

  public void setCardData(List<String> cardData) {
    this.cardData = cardData;
  }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }
}
