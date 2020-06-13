package utils;

import beans.Card;
import exception.DeckFinishedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCardDealer extends Dealer {

    @Override
    public List<Card> dealCards(int n) throws DeckFinishedException {

        Random rand = new Random();

        List<Card> newList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int randomIndex = rand.nextInt(totalCards.size());

            newList.add(totalCards.get(randomIndex));
            totalCards.remove(randomIndex);
        }
        return newList;
    }
}
