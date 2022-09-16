package services;

import model.entities.Player;

import java.util.List;

/**
 * OutputService.
 */
public interface OutputService {

    String printResults(Player player);

    void printGame(List<Player> players);
}
