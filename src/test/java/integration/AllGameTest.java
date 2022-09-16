package integration;

import exceptions.DataException;
import model.entities.Player;
import model.entities.Shot;
import model.enums.ExceptionType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import services.*;
import services.impl.*;

import java.util.List;

public class AllGameTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private ReaderService fileReaderService;
    private ShotService shotService;
    private GameService playService;
    private PlayerService playerService;
    private OutputService outputService;

    @Before
    public void init() {
        shotService = new ShotServiceImpl();
        playService = new GameServiceImpl();
        playerService = new PlayerServiceImpl(playService);
        outputService = new OutputServiceImpl();
    }

    @Test
    public void createGameNegatiEmptyTest() {
        final String input = "./src/test/resources/negative/empty.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_EMPTY_FILE.getMessage());
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }

    @Test
    public void createGameNegatiFreeTextTest() {
        final String input = "./src/test/resources/negative/free-text.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_FORMAT_ERROR.getMessage());
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }

    @Test
    public void createGameNegatiInvalidScoreTest() {
        final String input = "./src/test/resources/negative/invalid-score.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_INVALID_SCORE.getMessage());
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }

    @Test
    public void createGameNegativeNegativeTest() {
        final String input = "./src/test/resources/negative/negative.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_NEGATIVE_NUMBER.getMessage());
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }

    @Test
    public void createGamePositivePerfectTest() {
        final String input = "./src/test/resources/positive/perfect.txt";
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }

    @Test
    public void createGamePositiveScoresTest() {
        final String input = "./src/test/resources/positive/scores.txt";
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }

    @Test
    public void createGamePositiveZeroScoresTest() {
        final String input = "./src/test/resources/positive/zero.txt";
        fileReaderService = new FileReaderServiceImpl(shotService);
        List<Shot> shots = fileReaderService.readDataFile(input);
        List<Player> players = playerService.createPlayers(shots);
        outputService.printGame(players);
    }


}
