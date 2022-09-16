package model.entities;

import model.enums.Constants;
import model.enums.ShotType;

import java.util.List;

/**
 * Class to create Strike Frames.
 */

public class Strike extends Frame {


    public Strike() {
        super();
    }

    public Strike(final Integer firstShot, final Integer secodnShot, final Integer thirdShot, final Integer score, final String printFrame) {
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
        final Integer score = ShotType.STRIKE.getShot() + pinFalls.get(shot + 1) + pinFalls.get(shot + 2) + acumScore;
        super.setScore(score);
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
        return shot + 1;
    }

    /**
     * Method to set Last Frame Shots.
     *
     * @param shot     shot number.
     * @param pinFalls list of pinfalls.
     */
    @Override
    public void setLastFrame(final Integer shot, final List<Integer> pinFalls) {
        setFirstShot(pinFalls.get(shot));
        setSecodnShot(pinFalls.get(shot + 1));
        setThirdShot(pinFalls.get(shot + 2));
        super.setPrintFrame(String.format("%s\t%d\t%d\t", Constants.STRIKE.getMessage(), getSecodnShot(), getThirdShot()));
    }

    /**
     * Method to set shots frame.
     *
     * @param shot     shot number.
     * @param pinFalls list of pinfalls.
     */
    @Override
    public void setFrame(final Integer shot, final List<Integer> pinFalls) {
        setFirstShot(ShotType.STRIKE.getShot());
        setPrintFrame(String.format("\t%s\t", Constants.STRIKE.getMessage()));
    }

}
