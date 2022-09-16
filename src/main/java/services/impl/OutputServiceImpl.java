package services.impl;

import model.entities.Player;
import services.OutputService;

import java.util.List;

/**
 * Implementation Service to print a result by console.
 */
public class OutputServiceImpl implements OutputService {

    /**
     * Method to create string game result.
     * @param player Player to be printed
     * @return
     */
    @Override
    public String printResults(final Player player) {
        final StringBuilder response = new StringBuilder();
        response.append(player.getName()).append("\n");
        response.append("Frame\t\t");
        for (int i = 1; i < 11; i++) {
            response.append(i).append("\t\t");
        }
        response.append("\n").append("PinFalls\t");

        player.getFrames().forEach(frame -> response.append(frame.getPrintFrame()));
        response.append("\n").append("Score\t\t");
        player.getFrames().stream().forEach(frame -> response.append(frame.getScore()).append("\t\t"));
        response.append("\n\n");
        return response.toString();
    }

    /**
     * Method to print by console the game results.
     * @param players list of players to be printed
     */
    @Override
    public void printGame(final List<Player> players) {
        for (Player player : players) {
            System.out.print(printResults(player));
        }

    }
}
