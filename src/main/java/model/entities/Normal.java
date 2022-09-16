package model.entities;

import java.util.List;

/**
 * Class to create Normal Frames.
 */
public class Normal extends Frame {

    public Normal() {
        super();
    }


    public Normal(final Integer firstShot, final Integer secodnShot, final Integer thirdShot, final Integer score, final String printFrame) {
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
        final Integer score = pinFalls.get(shot) + pinFalls.get(shot + 1) + acumScore;
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
        setFirstShot(pinFalls.get(shot));
        setSecodnShot(pinFalls.get(shot + 1));
        setPrintFrame(String.format("\t%d\t%d", getFirstShot(), getSecodnShot()));
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
        setPrintFrame(String.format("%d\t%d\t", getFirstShot(), getSecodnShot()));
    }
}
