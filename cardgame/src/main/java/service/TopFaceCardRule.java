package service;


import beans.Card;
import beans.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopFaceCardRule implements Rules {
    @Override
    public List<Player> executeRule(List<Player> players) {

        List<Card> activeCards = new ArrayList<>();
        players.forEach(player -> activeCards.addAll(player.getCardList()));
        Card topCard = RuleBook.getTopCard(activeCards);

        return players.stream().filter(player ->
                RuleBook.getTopCard(player.getCardList()).getNumber() == topCard.getNumber())
                .collect(Collectors.toList());
    }
}
