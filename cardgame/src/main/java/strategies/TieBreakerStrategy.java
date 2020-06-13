package strategies;

import beans.Player;

import java.util.List;


public interface TieBreakerStrategy {

    int getNumberOfCardsIntieBreaking();
    List<Player> breakTie(List<Player> players);




}
