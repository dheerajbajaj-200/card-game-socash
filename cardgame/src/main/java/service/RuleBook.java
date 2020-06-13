package service;

import beans.Card;

import java.util.Comparator;
import java.util.List;

class RuleBook {


    static Card getTopCard(List<Card> cards) {

        cards.sort(Comparator.comparingInt(Card::getNumber));

        if (cards.get(0).getNumber() == 1) {
            return cards.get(0);
        }
        return cards.get(cards.size() - 1);

    }

    static boolean isSequence(List<Card> cards) {


        if (cards.get(0).getNumber() == 1) {

            return cards.get(1).getNumber() % 10 == 2 && cards.get(2).getNumber() % 10 == 3;
        }

        return (cards.get(0).getNumber() == cards.get(1).getNumber() - 1) &&
                (cards.get(2).getNumber() == cards.get(1).getNumber() + 1);

    }

    static boolean isPair(List<Card> cards) {

        return cards.get(0).getNumber() == cards.get(1).getNumber() ||
                cards.get(0).getNumber() == cards.get(2).getNumber() ||
                cards.get(1).getNumber() == cards.get(2).getNumber();

    }

    static boolean isTrail(List<Card> cards) {

        return cards.get(0).getNumber() == cards.get(1).getNumber() &&
                cards.get(0).getNumber() == cards.get(2).getNumber();

    }

    static Card getPairCard(List<Card> cards) {

        if (cards.get(0).getNumber() == cards.get(1).getNumber() || cards.get(0).getNumber() == cards.get(2).getNumber()) {

            return cards.get(0);
        }

        return cards.get(1);

    }

}
