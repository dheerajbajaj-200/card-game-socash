package service;

import beans.Player;

import java.util.List;

public interface Rules {

    List<Player> executeRule(List<Player>players);
}
