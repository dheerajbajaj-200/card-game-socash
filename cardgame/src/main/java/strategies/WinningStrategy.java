package strategies;

import beans.Player;
import service.Rules;

import java.util.List;

public interface WinningStrategy {

    List<Player> findWinner(List<Player> activePlayers) ;

    List<Rules> getRules();
}
