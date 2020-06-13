package runner;

import beans.Card;
import beans.Player;
import exception.DeckFinishedException;
import exception.NoWinnerFoundException;
import strategies.TieBreakerStrategy;
import strategies.WinningStrategy;
import utils.Dealer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


public class Game {

    private final static Logger LOGGER = Logger.getLogger(Game.class.getName());
    private List<Player> playerList = new ArrayList<>();
    private Dealer cardDealer;
    private int numberOfCards;
    private WinningStrategy winningStrategy;
    private TieBreakerStrategy tieBreakingStrategy;

    public Game(int numberOfPlayers,
                Dealer dealer,
                int numberOfCards,
                WinningStrategy winningStrategy,
                TieBreakerStrategy tieBreakingStrategy) {

        this.cardDealer = dealer;
        this.numberOfCards = numberOfCards;
        this.winningStrategy = winningStrategy;
        this.tieBreakingStrategy = tieBreakingStrategy;
        initPlayers(numberOfPlayers);
    }

    private void initPlayers(int numberOfPlayers) {
        LOGGER.info("Initializing game with " + numberOfPlayers + " players ");
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(i);
            player.setName("player - " + i + 1);
            List<Card> randomCards = null;
            try {
                randomCards = cardDealer.dealCards(numberOfCards);
            } catch (DeckFinishedException e) {
                LOGGER.severe("Initializing game with " + numberOfPlayers + " players ");
                return;
            }
            randomCards.sort(Comparator.comparingInt(Card::getNumber));
            player.setCardList(randomCards);
            playerList.add(player);
        }
        LOGGER.info("Player List" + playerList);

    }

    public Player playGame() throws NoWinnerFoundException {

        List<Player> activePlayers = new ArrayList<>(playerList);

        activePlayers = winningStrategy.findWinner(playerList);

        if (activePlayers.size() > 1) {
            LOGGER.info("Single Winner Not found. Going for the Tie Breaker");

            try {
                while (activePlayers.size() > 1) {
                    activePlayers.forEach(activePlayer -> {
                        try {
                            activePlayer.setCardList(
                                    new ArrayList<>(
                                            getCardsFromDealer(tieBreakingStrategy.getNumberOfCardsIntieBreaking())));
                        } catch (DeckFinishedException e1) {
                            LOGGER.severe("Deck Finished game exit ");
                            throw new RuntimeException(e1.getLocalizedMessage());

                        }
                    });
                    activePlayers = tieBreakingStrategy.breakTie(activePlayers);
                }
            } catch (RuntimeException ex) {
                LOGGER.severe(ex.getLocalizedMessage());
                throw new NoWinnerFoundException(ex.getMessage());
            }
        }

        return activePlayers.get(0);

    }

    private List<Card> getCardsFromDealer(int n) throws DeckFinishedException {
        return cardDealer.dealCards(n);

    }


    public void setPlayerList(List<Player> playerList) {
        this.playerList = new ArrayList<>(playerList);
    }


}
