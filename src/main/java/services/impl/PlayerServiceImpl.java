package services.impl;

import model.entities.Player;
import model.entities.Shot;
import model.enums.Constants;
import services.GameService;
import services.PlayerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Player Class Service.
 */
public class PlayerServiceImpl implements PlayerService {

    private GameService gameService;

    public PlayerServiceImpl(final GameService playService) {
        this.gameService = playService;
    }

    /**
     * Method to create a player.
     *
     * @param name String name player
     * @param pinFalls List fo shots
     * @return
     */
    @Override
    public Player save(final String name, final List<String> pinFalls) {
        Collections.replaceAll(pinFalls, Constants.FOUL.getMessage(), Constants.ZERO.getMessage());
        final List<Integer> pinFallsNumeric = pinFalls.stream().map(Integer::parseInt).collect(Collectors.toList());
        return new Player(name, pinFallsNumeric, gameService.createGameFrames(pinFallsNumeric));
    }

    /**
     * Method to create multiples players.
     *
     * @param shots List of Shots
     * @return
     */
    @Override
    public List<Player> createPlayers(final List<Shot> shots) {
        final List<Player> players = new ArrayList<>();
        shots.stream()
                .collect(Collectors.groupingBy(Shot::getName, Collectors.mapping(Shot::getPinFall, Collectors.toList())))
                .entrySet().forEach(game -> {
                    players.add(save(game.getKey(), game.getValue()));
                });
        return players;
    }
}
