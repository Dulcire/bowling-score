package services;

import model.entities.Frame;
import model.entities.Normal;
import model.entities.Spare;
import model.entities.Strike;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.impl.GameServiceImpl;

import java.util.Arrays;
import java.util.List;

public class GameServiceImplTest {

    private GameService gameService;

    @Before
    public void init() {
        gameService = new GameServiceImpl();
    }

    @Test
    public void createGameFramesPerfectTest() {
        List<Frame> frames = gameService.createGameFrames(pinFallPerfectList());
        Assert.assertEquals(frames, framesPerfectGenerator());
    }

    @Test
    public void createGameFramesPerfecSparetTest() {
        List<Frame> frames = gameService.createGameFrames(pinFallPerfectSpareList());
        Assert.assertEquals(framesPerfectSpareGenerator(), frames);
    }

    @Test
    public void createGameFramesZeroTest() {
        List<Frame> frames = gameService.createGameFrames(pinFallZeroList());
        Assert.assertEquals(framesZeroGenerator(), frames);
    }

    public List<Integer> pinFallZeroList() {
        return Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public List<Integer> pinFallPerfectList() {
        return Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    public List<Integer> pinFallPerfectSpareList() {
        return Arrays.asList(7, 3, 8, 2, 5, 5, 9, 1, 9, 1, 1, 9, 8, 2, 7, 3, 4, 6, 5, 5, 1);
    }

    public List<Frame> framesPerfectGenerator() {
        return Arrays.asList(
                new Strike(10, 0, 0, 30, "\tX\t"),
                new Strike(10, 0, 0, 60, "\tX\t"),
                new Strike(10, 0, 0, 90, "\tX\t"),
                new Strike(10, 0, 0, 120, "\tX\t"),
                new Strike(10, 0, 0, 150, "\tX\t"),
                new Strike(10, 0, 0, 180, "\tX\t"),
                new Strike(10, 0, 0, 210, "\tX\t"),
                new Strike(10, 0, 0, 240, "\tX\t"),
                new Strike(10, 0, 0, 270, "\tX\t"),
                new Strike(10, 10, 10, 300, "X\t10\t10\t"));

    }


    public List<Frame> framesPerfectSpareGenerator() {
        return Arrays.asList(
                new Spare(7, 3, 0, 18, "7\t/\t"),
                new Spare(8, 2, 0, 33, "8\t/\t"),
                new Spare(5, 5, 0, 52, "5\t/\t"),
                new Spare(9, 1, 0, 71, "9\t/\t"),
                new Spare(9, 1, 0, 82, "9\t/\t"),
                new Spare(1, 9, 0, 100, "1\t/\t"),
                new Spare(8, 2, 0, 117, "8\t/\t"),
                new Spare(7, 3, 0, 131, "7\t/\t"),
                new Spare(4, 6, 0, 146, "4\t/\t"),
                new Spare(5, 5, 1, 157, "5\t/\t1")
        );
    }

    public List<Frame> framesZeroGenerator() {
        return Arrays.asList(
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "0\t0\t"),
                new Normal(0, 0, 0, 0, "\t0\t0")
        );
    }
}
