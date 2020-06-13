package beans;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cardList = new ArrayList<>();

    public Deck() {

        for (CardType cardType : CardType.values()) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(i, cardType);
                cardList.add(card);
            }
        }

    }

    public List<Card> getCardList() {
        return new ArrayList<>(cardList);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }
}
