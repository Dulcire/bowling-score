package utils;

import exceptions.DataException;
import model.entities.Shot;
import model.enums.ExceptionType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

public class ValidationsTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void verifyPinFallEmptyTest() {
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_EMPTY_FILE.getMessage());
        Assert.assertTrue(Validations.verifyPinFallEmpty(Arrays.asList()));
    }

    @Test
    public void verifyPinFallNotEmptyTrueTest() {
        Assert.assertTrue(Validations.verifyPinFallEmpty(shotsGenerator()));
    }

    @Test
    public void verifyPinFallNumberTest() {
        Assert.assertEquals(Validations.verifyPinFallNumber(pinFallNormalList()), pinFallNumericList());
    }

    @Test
    public void verifyPinFallNotNumberTest() {
        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_INVALID_SCORE.getMessage());
        Validations.verifyPinFallNumber(pinFallList());
    }

    @Test
    public void verifyPinFallNegativeNumber() {

        exceptionRule.expect(DataException.class);
        exceptionRule.expectMessage(ExceptionType.DATA_NEGATIVE_NUMBER.getMessage());
        Validations.verifyPinFallNegativeNumber(pinFallNumericList());
    }

    @Test
    public void dataValidation() {
        Validations.dataValidation(shotsGenerator());
    }

    public List<String> pinFallList() {
        return Arrays.asList("10", "7", "A", "9", "0", "10", "-5", "8", "8", "2", "0", "6", "10", "10", "10", "8", "1");
    }

    public List<String> pinFallNormalList() {
        return Arrays.asList("10", "7", "3", "9", "0", "10", "-5", "8", "8", "2", "0", "6", "10", "10", "10", "8", "1");
    }

    public List<Integer> pinFallNumericList() {
        return Arrays.asList(10, 7, 3, 9, 0, 10, -5, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);
    }

    public List<Shot> shotsGenerator() {
        return Arrays.asList(
                new Shot("Jeff", "10"),
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
