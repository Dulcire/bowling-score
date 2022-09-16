package utils;

import exceptions.DataException;
import lombok.SneakyThrows;
import model.entities.Shot;
import model.enums.Constants;
import model.enums.ExceptionType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Validations Class.
 */
public class Validations {

    /**
     * Method to verify if the list of shots is empty.
     *
     * @param shots Shot
     * @return
     */
    @SneakyThrows
    public static boolean verifyPinFallEmpty(final List<Shot> shots) {
        if (shots.size() <= 0) {
            throw new DataException(ExceptionType.DATA_EMPTY_FILE.getMessage());
        }

        return true;
    }

    /**
     * Method to verify if the score values into the pinfalls list are valid.
     *
     * @param pinFallList String List
     * @return
     */
    @SneakyThrows
    public static List<Integer> verifyPinFallNumber(final List<String> pinFallList) {
        try {
            Collections.replaceAll(pinFallList, Constants.FOUL.getMessage(), Constants.ZERO.getMessage());
            return pinFallList.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new DataException(ExceptionType.DATA_INVALID_SCORE.getMessage());
        }
    }

    /**
     * Method to verify there are no negative number in the pinfall list.
     *
     * @param pinFallList Integer List
     * @return
     */
    @SneakyThrows
    public static boolean verifyPinFallNegativeNumber(final List<Integer> pinFallList) {
        if (pinFallList.stream().anyMatch(pinfall -> pinfall.compareTo(0) < 0)) {
            throw new DataException(ExceptionType.DATA_NEGATIVE_NUMBER.getMessage());
        }
        return true;
    }


    /**
     * Method to verify all data from the shots generator is valid to the score.
     *
     * @param shots Shot List
     * @return
     */
    public static boolean dataValidation(final List<Shot> shots) {
        final List<String> pinfalls = shots.stream().map(Shot::getPinFall).collect(Collectors.toList());
        verifyPinFallEmpty(shots);
        final List<Integer> pinfallsNumeric = verifyPinFallNumber(pinfalls);
        verifyPinFallNegativeNumber(pinfallsNumeric);
        return true;
    }

}
