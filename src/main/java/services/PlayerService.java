package services;

import model.entities.Player;
import model.entities.Shot;

import java.util.List;

/**
 * PlayerService.
 */
public interface PlayerService {

    Player save(final String name, final List<String> pinFalls);

    List<Player> createPlayers(final List<Shot> shots);
}
