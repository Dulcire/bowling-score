package services;

import model.entities.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.impl.GameServiceImpl;
import services.impl.OutputServiceImpl;
import services.impl.PlayerServiceImpl;

import java.util.Arrays;
import java.util.List;

public class OutputServiceImplTest {

    private OutputService outputService;
    private PlayerService playerService;
    private GameService playService;

    @Before
    public void init() {
        outputService = new OutputServiceImpl();
        playService = new GameServiceImpl();
        playerService = new PlayerServiceImpl(playService);
    }

    @Test
    public void printResultsTest() {

        Assert.assertEquals(responseGenerator(),outputService.printResults(playerList().get(0)));
    }

    public String responseGenerator(){
        return  "John\n" +
                "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\t\t\n" +
                "PinFalls\t3\t/\t6\t3\t\tX\t8\t1\t\tX\t\tX\t9\t0\t7\t/\t4\t4\tX\t9\t0\t\n" +
                "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151\t\t\n\n";

    }
    public List<Player> playerList() {
        List<Integer> john = Arrays.asList(3, 7, 6, 3, 10, 8, 1, 10, 10, 9, 0, 7, 3, 4, 4, 10, 9, 0);
        List<Integer> jeff = Arrays.asList(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);
        List<Integer> dulcire = Arrays.asList(1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 2, 2, 3, 1, 0, 0, 1, 1, 1, 0);
        return Arrays.asList(
                new Player("John", john, playService.createGameFrames(john)),
                new Player("Jeff", jeff, playService.createGameFrames(jeff)),
                new Player("Dulcire", jeff, playService.createGameFrames(dulcire)));
    }

}
