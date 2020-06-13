package service;

import beans.Card;
import beans.Player;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TrailRule implements Rules{
    @Override
    public List<Player> executeRule(List<Player> players) {

        List<Player> playersWithTrail = players.stream().filter(player -> RuleBook.isTrail(player.getCardList())).
                collect(Collectors.toList());
        if(playersWithTrail.size()>1){
            return  compareTrail(playersWithTrail);
        }
        return playersWithTrail;
    }

    private List<Player> compareTrail(List<Player> players) {


        List<Card> activeCards = new ArrayList<>();
        players.forEach(player -> activeCards.addAll(FastList.newListWith(RuleBook.getPairCard(player.getCardList()))));
        Card topTrailCard = RuleBook.getTopCard(activeCards);

        return players.stream().filter(player ->
                RuleBook.getPairCard(player.getCardList()).getNumber() == topTrailCard.getNumber()).
                collect(Collectors.toList());


    }
}
