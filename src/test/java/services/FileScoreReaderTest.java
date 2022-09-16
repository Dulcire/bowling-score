package services;

import exceptions.DataException;
import model.entities.Shot;
import model.enums.ExceptionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import services.impl.FileReaderServiceImpl;
import services.impl.ShotServiceImpl;

import java.util.Arrays;
import java.util.List;

public class FileScoreReaderTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private ReaderService fileScoreReader;
    private String inputFile;
    private ShotService service;

    @Before
    public void init() {
        inputFile = "./src/test/resources/positive/scores.txt";
        service = new ShotServiceImpl();
        fileScoreReader = new FileReaderServiceImpl(service);

    }

    @Test
    public void createGameNegatiEmptyTest() {
        final String input = "./src/test/resources/negative/empty.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_EMPTY_FILE.getMessage());
        ReaderService fileScore = new FileReaderServiceImpl(service);
        fileScore.readDataFile(input);
    }

    @Test
    public void createGameNegatiFreeTextTest() {
        final String input = "./src/test/resources/negative/free-text.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_FORMAT_ERROR.getMessage());
        ReaderService fileScore = new FileReaderServiceImpl(service);
        fileScore.readDataFile(input);
    }

    @Test
    public void createGameNegatiInvalidScoreTest() {
        final String input = "./src/test/resources/negative/invalid-score.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_INVALID_SCORE.getMessage());
        ReaderService fileScore = new FileReaderServiceImpl(service);
        fileScore.readDataFile(input);
    }

    @Test
    public void createGameNegativeNegativeTest() {
        final String input = "./src/test/resources/negative/negative.txt";
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_NEGATIVE_NUMBER.getMessage());
        ReaderService fileScore = new FileReaderServiceImpl(service);
        fileScore.readDataFile(input);
    }

    @Test
    public void createGamePositivePerfectTest() {
        final String input = "./src/test/resources/positive/perfect.txt";
        ReaderService fileScore = new FileReaderServiceImpl(service);
        fileScore.readDataFile(input);
    }

    @Test
    public void createGamePositiveScoresTest() {
        final String input = "./src/test/resources/positive/scores.txt";
        ReaderService fileScore = new FileReaderServiceImpl(service);
        fileScore.readDataFile(input);
    }

    @Test
    public void readDataFile() {
        List<Shot> shots = fileScoreReader.readDataFile(inputFile);
        Assert.assertEquals(shots, shotsGenerator());
    }

    public List<Shot> shotsGenerator() {
        return Arrays.asList(new Shot("Jeff", "10"),
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
                new Shot("Jeff", "F"),
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
