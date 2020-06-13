package utils;

import beans.Card;
import beans.Deck;
import exception.DeckFinishedException;

import java.util.ArrayList;
import java.util.List;


public abstract class Dealer {

    Dealer() {
        Deck deck = new Deck();
        this.setTotalCards(new ArrayList<>(deck.getCardList()));
    }

    List<Card> totalCards = new ArrayList<>();

    private void setTotalCards(List<Card> totalCards) {
        this.totalCards =  new ArrayList<>(totalCards);
    }

    public abstract List<Card> dealCards(int n) throws DeckFinishedException;

}
