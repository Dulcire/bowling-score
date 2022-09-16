package model.entities;

import model.enums.Constants;
import model.enums.ShotType;

import java.util.List;

/**
 * Class to create Spare Frames.
 */
public class Spare extends Frame {

    public Spare() {
        super();
    }

    public Spare(final Integer firstShot, final Integer secodnShot, final Integer thirdShot, final Integer score, final String printFrame) {
        super(firstShot, secodnShot, thirdShot, score, printFrame);
    }


    /**
     * Method to calculate de Normal Frame score.
     *
     * @param shot      shot number.
     * @param pinFalls  list of pinfalls.
     * @param acumScore score acumulated.
     * @return
     */
    @Override
    public Integer socreCalculatio(final Integer shot, final List<Integer> pinFalls, final Integer acumScore) {
        final Integer score = ShotType.SPARE.getShot() + pinFalls.get(shot + 2) + acumScore;
        this.setScore(score);
        return score;

    }

    /**
     * Method to return next shot.
     *
     * @param shot     shot number.
     * @param pinFalls list of pinfalls.
     * @return
     */
    @Override
    public Integer nextShot(final Integer shot, final List<Integer> pinFalls) {
        return shot + 2;
    }

    /**
     * Method to set Last Frame Shots.
     *
     * @param shot     shot number.
     * @param pinFalls list of pinfalls.
     */
    @Override
    public void setLastFrame(final Integer shot, final List<Integer> pinFalls) {
        super.setFirstShot(pinFalls.get(shot));
        super.setSecodnShot(pinFalls.get(shot + 1));
        setThirdShot(pinFalls.get(shot + 2));
        super.setPrintFrame(String.format("%d\t%s\t%d", getFirstShot(), Constants.SPEAR.getMessage(), getThirdShot()));
    }

    /**
     * Method to set shots frame.
     *
     * @param shot     shot number.
     * @param pinFalls list of pinfalls.
     */
    @Override
    public void setFrame(final Integer shot, final List<Integer> pinFalls) {
        setFirstShot(pinFalls.get(shot));
        setSecodnShot(pinFalls.get(shot + 1));
        super.setPrintFrame(String.format("%d\t%s\t", getFirstShot(), Constants.SPEAR.getMessage()));
    }
}
