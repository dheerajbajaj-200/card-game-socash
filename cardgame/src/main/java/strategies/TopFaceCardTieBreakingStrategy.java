package strategies;

import beans.Player;
import runner.Game;
import service.Rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class TopFaceCardTieBreakingStrategy implements TieBreakerStrategy {

    private final static Logger LOGGER = Logger.getLogger(Game.class.getName());
    private int numberOfCardsInTieBreaker = 1;
    private List<Rules> rules;

    public TopFaceCardTieBreakingStrategy(int numberOfCardsInTieBreaker, List<Rules> rules) {
        this.numberOfCardsInTieBreaker = numberOfCardsInTieBreaker;
        this.rules = new ArrayList<>(rules);
    }

    @Override
    public int getNumberOfCardsIntieBreaking() {
        return numberOfCardsInTieBreaker;
    }

    @Override
    public List<Player> breakTie(List<Player> activePlayers) {

        LOGGER.info("Breaking Tie between players "+activePlayers);
        List<Player> tempPlayers = new ArrayList<>(activePlayers);
        List<Player> players = Collections.emptyList();
        for (Rules rule : rules) {

            players = rule.executeRule(tempPlayers);
            if (!players.isEmpty()) {
                tempPlayers = new ArrayList<>(players);
            }

        }

        return players;

    }
}
