package utils;

import model.entities.Frame;
import model.entities.Normal;
import model.entities.Spare;
import model.entities.Strike;
import model.enums.ShotType;

import java.util.List;

/**
 * Frame utils class.
 */
public class FrameUtils {

    /**
     * Method to obtain Frame type instantiation.
     *
     * @param shot     Integer
     * @param pinFalls List
     * @return
     */
    public static Frame frameType(final Integer shot, final List<Integer> pinFalls) {
        if (isStrike(shot, pinFalls)) {
            return new Strike();
        } else if (isSpare(shot, pinFalls)) {
            return new Spare();
        } else {
            return new Normal();
        }

    }

    /**
     * Method to verify if a shot is a Spare.
     *
     * @param shot     Integer
     * @param pinFalls list
     * @return
     */
    public static boolean isSpare(final Integer shot, final List<Integer> pinFalls) {
        return pinFalls.get(shot) + pinFalls.get(shot + 1) == ShotType.SPARE.getShot();
    }

    /**
     * Method to verify if a shot is a Strike.
     *
     * @param shot     Integer
     * @param pinFalls List
     * @return
     */
    public static boolean isStrike(final Integer shot, final List<Integer> pinFalls) {
        return pinFalls.get(shot).equals(ShotType.STRIKE.getShot());
    }
}
