package strategies;

import beans.Player;
import runner.Game;
import service.Rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class StandardWinningStrategy implements WinningStrategy {

    private final static Logger LOGGER = Logger.getLogger(Game.class.getName());
    private List<Rules> rules;

    public StandardWinningStrategy(List<Rules> rules) {
        this.rules = rules;
    }

    @Override
    public List<Player> findWinner(List<Player> activePlayers) {

        LOGGER.info("Finding winner ");
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

    @Override
    public List<Rules> getRules() {
        return this.rules;
    }
}
