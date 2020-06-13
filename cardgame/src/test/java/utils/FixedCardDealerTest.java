package utils;

import beans.Card;
import exception.DeckFinishedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajadh on 6/13/2020.
 */
public class FixedCardDealerTest extends Dealer {

    List<Card> testCards = new ArrayList<>();

    public List<Card> getTestCards() {
        return testCards;
    }

    public void setTestCards(List<Card> testCards) {
        this.testCards = testCards;
    }

    @Override
    public List<Card> dealCards(int n) throws DeckFinishedException {

        List<Card> newList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            newList.add(testCards.get(i));
            testCards.remove(i);
        }
        return newList;
    }
}
