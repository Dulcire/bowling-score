package services;

import model.entities.Player;
import model.entities.Shot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.impl.GameServiceImpl;
import services.impl.PlayerServiceImpl;

import java.util.Arrays;
import java.util.List;

public class PlayerServiceImplTest {

    private PlayerService playerService;
    private GameService playService;

    @Before
    public void init() {
        playService = new GameServiceImpl();
        playerService = new PlayerServiceImpl(playService);
    }

    @Test
    public void createPlayersTest() {
        Assert.assertEquals(playerList(), playerService.createPlayers(shotsGenerator()));
    }

    public List<Player> playerList() {
        List<Integer> john = Arrays.asList(3, 7, 6, 3, 10, 8, 1, 10, 10, 9, 0, 7, 3, 4, 4, 10, 9, 0);
        List<Integer> jeff = Arrays.asList(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);
        return Arrays.asList(
                new Player("John", john, playService.createGameFrames(john)),
                new Player("Jeff", jeff, playService.createGameFrames(jeff)));
    }

    public List<Shot> shotsGenerator() {
        return Arrays.asList(
                new Shot("Jeff", "10"),
                new Shot("John", "3"),
                new Shot("John", "7"),
                new Shot("Jeff", "7"),
                new Shot("Jeff", "3"),
                new Shot("John", "6"),
                new Shot("John", "3"),
                new Shot("Jeff", "9"),
                new Shot("Jeff", "0"),
                new Shot("John", "10"),
                new Shot("Jeff", "10"),
                new Shot("John", "8"),
                new Shot("John", "1"),
                new Shot("Jeff", "0"),
                new Shot("Jeff", "8"),
                new Shot("John", "10"),
                new Shot("Jeff", "8"),
                new Shot("Jeff", "2"),
                new Shot("John", "10"),
                new Shot("Jeff", "0"),
                new Shot("Jeff", "6"),
                new Shot("John", "9"),
                new Shot("John", "0"),
                new Shot("Jeff", "10"),
                new Shot("John", "7"),
                new Shot("John", "3"),
                new Shot("Jeff", "10"),
                new Shot("John", "4"),
                new Shot("John", "4"),
                new Shot("Jeff", "10"),
                new Shot("Jeff", "8"),
                new Shot("Jeff", "1"),
                new Shot("John", "10"),
                new Shot("John", "9"),
                new Shot("John", "0"));
    }


}

