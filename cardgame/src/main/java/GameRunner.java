import exception.NoWinnerFoundException;
import org.eclipse.collections.impl.list.mutable.FastList;
import runner.Game;
import service.PairRule;
import service.SequenceRule;
import service.TopFaceCardRule;
import service.TrailRule;
import strategies.StandardWinningStrategy;
import strategies.TopFaceCardTieBreakingStrategy;
import utils.RandomCardDealer;

import java.util.logging.Logger;

/**
 * Runner Class for the Card Game
 * Program Args : Number of Players , number of cards to each player, Number of cards in tie breaker
 * **/

public class GameRunner {

    private final static Logger LOGGER = Logger.getLogger(GameRunner.class.getName());
    public static void main(String[] args) {

        int n = args.length;
        int numberOfPlayers =4;
        int numberOfCards = 3;
        int tieBreakerCards =1;
        System.out.println(args.length);
        if(n>=3){
            numberOfPlayers= Integer.parseInt(args[0]);
            numberOfCards = Integer.parseInt(args[1]);
            tieBreakerCards= Integer.parseInt(args[2]);

        }
        Game game = new Game(numberOfPlayers,
                new RandomCardDealer(),
                numberOfCards,
                new StandardWinningStrategy(FastList.newListWith(new TrailRule(),new SequenceRule(),new PairRule(),new TopFaceCardRule())),
                new TopFaceCardTieBreakingStrategy(tieBreakerCards,FastList.newListWith(new TopFaceCardRule()))
                    );

        try {
            LOGGER.info("Winner " + game.playGame());
        }catch (NoWinnerFoundException e){
            LOGGER.severe(e.getLocalizedMessage());
        }

    }
}
