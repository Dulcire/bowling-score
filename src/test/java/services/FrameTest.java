package services;

import model.entities.Frame;
import model.entities.Normal;
import model.entities.Spare;
import model.entities.Strike;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameTest {

    private Frame frame;

    @Before
    public void init() {
    }

    @Test
    public void socreCalculatioFirstFrameStrike() {
        final Integer expected = 20;
        frame = new Strike();
        frame.socreCalculatio(0, pinFallList(), 0);
        Assert.assertEquals(expected, frame.getScore());
    }

    @Test
    public void setFirstFrameStrike() {
        final Integer expected = 0;
        frame = new Strike();
        frame.setFrame(0, pinFallList());
        Assert.assertEquals(pinFallList().get(0), frame.getFirstShot());
        Assert.assertEquals(frame.getSecodnShot(), expected);
        Assert.assertEquals(frame.getThirdShot(), expected);
    }

    @Test
    public void socreCalculatioSecondFrameSpare() {
        final Integer expected = 39;
        frame = new Spare();
        final Integer acum = 20;
        final Integer result = frame.socreCalculatio(1, pinFallList(), acum);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void setSecondFrameSpeare() {
        final Integer expected = 0;
        frame = new Spare();
        frame.setFrame(1, pinFallList());
        Assert.assertEquals(pinFallList().get(1), frame.getFirstShot());
        Assert.assertEquals(pinFallList().get(2), frame.getSecodnShot());
        Assert.assertEquals(frame.getThirdShot(), expected);
    }

    @Test
    public void socreCalculatioThirdFrameNormal() {
        final Integer expected = 48;
        frame = new Normal();
        final Integer acum = 39;
        final Integer result = frame.socreCalculatio(3, pinFallList(), acum);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void setThirdFrameNormal() {
        final Integer expected = 0;
        frame = new Normal();
        frame.setFrame(15, pinFallList());
        Assert.assertEquals(pinFallList().get(15), frame.getFirstShot());
        Assert.assertEquals(pinFallList().get(16), frame.getSecodnShot());
        Assert.assertEquals(frame.getThirdShot(), expected);
    }

    @Test
    public void setLastSpeare() {
        final Integer expected = 0;
        frame = new Spare();
        frame.setLastFrame(14, pinFallList());
        Assert.assertEquals(pinFallList().get(14), frame.getFirstShot());
        Assert.assertEquals(pinFallList().get(15), frame.getSecodnShot());
        Assert.assertEquals(pinFallList().get(16), frame.getThirdShot());
    }

    @Test
    public void setLastStrike() {
        final Integer expected = 0;
        frame = new Strike();
        frame.setLastFrame(14, pinFallList());
        Assert.assertEquals(pinFallList().get(14), frame.getFirstShot());
        Assert.assertEquals(pinFallList().get(15), frame.getSecodnShot());
        Assert.assertEquals(pinFallList().get(16), frame.getThirdShot());
    }

    @Test
    public void setLastNormal() {
        final Integer expected = 0;
        frame = new Normal();
        frame.setLastFrame(3, pinFallList());
        Assert.assertEquals(pinFallList().get(3), frame.getFirstShot());
        Assert.assertEquals(pinFallList().get(4), frame.getSecodnShot());
        Assert.assertEquals(frame.getThirdShot(), expected);
    }

    @Test
    public void creatingFrames() {
        List<FrameTypeService> frames = new ArrayList<>();
        frames.add(new Spare());
    }

    public List<Integer> pinFallList() {
        return Arrays.asList(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);
    }
}
