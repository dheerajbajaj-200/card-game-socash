package service;

import beans.Player;

import java.util.List;
import java.util.stream.Collectors;

public class SequenceRule implements Rules {
    @Override
    public List<Player> executeRule(List<Player> players) {
        return players.stream().filter(player -> RuleBook.
                isSequence(player.getCardList())).
                collect(Collectors.toList());
    }
}
