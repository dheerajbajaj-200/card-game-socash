package utils;

import beans.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bajadh on 6/10/2020.
 */
public class CardPicker {


    public List<Card> pickRandom(int n,List<Card> cards){

        Random rand = new Random();

        List<Card> newList = new ArrayList<>();
        for (int i = 0; i < n; i++) {


            int randomIndex = rand.nextInt(cards.size());

            newList.add(cards.get(randomIndex));
            cards.remove(randomIndex);
        }
        return newList;
    }
}
