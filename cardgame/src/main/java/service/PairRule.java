package service;

import beans.Card;
import beans.Player;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bajadh on 6/12/2020.
 */
public class PairRule implements Rules {
    @Override
    public List<Player> executeRule(List<Player> players) {

        List<Player> playersWithPairs = players.stream().filter(player -> RuleBook.isPair(player.getCardList())).collect(Collectors.toList());
        if(playersWithPairs.size()>1){
            return  comparePair(playersWithPairs);
        }
        return playersWithPairs;
    }

    private List<Player> comparePair(List<Player> players) {

        List<Card> activeCards = new ArrayList<>();
        players.forEach(player -> activeCards.addAll(FastList.newListWith(RuleBook.getPairCard(player.getCardList()))));
        Card topPairCard = RuleBook.getTopCard(activeCards);

        return players.stream().filter(player ->
                RuleBook.getPairCard(player.getCardList()).getNumber() == topPairCard.getNumber()).
                collect(Collectors.toList());


    }
}
