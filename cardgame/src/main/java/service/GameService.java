package service;

import beans.Card;
import beans.Player;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GameService {

    private final static Logger LOGGER = Logger.getLogger(GameService.class.getName());

    public List<Player> checkWinner(List<Player> playerList) {

        LOGGER.info("checking for Winner");
        List<Player> topPlayers = this.checkTrail(playerList);

        LOGGER.info("Trails : " + topPlayers);

        if (topPlayers.isEmpty()) {
            LOGGER.info("No trail found");
            LOGGER.info("checking for Sequence");
            topPlayers = this.checkSequence(playerList);
            LOGGER.info("Sequence : " + topPlayers);
            if (topPlayers.isEmpty()) {
                LOGGER.info("No Sequence found");
                LOGGER.info("checking for Pair");
                topPlayers = this.checkPair(playerList);
                LOGGER.info("Pair : " + topPlayers);
                if (topPlayers.size() > 1) {
                    topPlayers = this.comparePair(topPlayers);
                }

            }

        }
        LOGGER.info("Comparing top cards now");

        return topPlayers.isEmpty() ?
                this.compareTopCard(playerList) : topPlayers.size()==1?topPlayers:this.compareTopCard(topPlayers);

    }

    private List<Player> comparePair(List<Player> players) {


        List<Card> activeCards = new ArrayList<>();
        players.forEach(player -> activeCards.addAll(FastList.newListWith(RuleBook.getPairCard(player.getCardList()))));
        Card topPairCard = RuleBook.getTopCard(activeCards);

        return players.stream().filter(player ->
                RuleBook.getPairCard(player.getCardList()).getNumber() == topPairCard.getNumber()).
                collect(Collectors.toList());


    }

    private List<Player> checkTrail(List<Player> players) {
        return players.stream().filter(player -> RuleBook.isTrail(player.getCardList())).
                collect(Collectors.toList());
    }

    private List<Player> checkSequence(List<Player> players) {

        return players.stream().filter(player -> RuleBook.
                isSequence(player.getCardList())).
                collect(Collectors.toList());
    }

    private List<Player> checkPair(List<Player> players) {
        return players.stream().filter(player -> RuleBook.isPair(player.getCardList())).collect(Collectors.toList());
    }


    public List<Player> compareTopCard(List<Player> players) {

        List<Card> activeCards = new ArrayList<>();
        players.forEach(player -> activeCards.addAll(player.getCardList()));
        Card topCard = RuleBook.getTopCard(activeCards);
        LOGGER.info("Top Card : "+topCard);

        return players.stream().filter(player ->
                RuleBook.getTopCard(player.getCardList()).getNumber() == topCard.getNumber()).collect(Collectors.toList());


    }


}
