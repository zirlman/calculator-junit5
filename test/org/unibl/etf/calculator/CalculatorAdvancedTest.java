package org.unibl.etf.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.unibl.etf.exceptions.NotSupportedOperationException;
import org.unibl.etf.exceptions.NumberNotInAreaException;

import java.util.stream.Stream;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for CalculatorAdvanced
 *
 * @author Dragan Zrilic
 * @version 1.0.0
 */
class CalculatorAdvancedTest {

    private static CalculatorAdvanced calculatorAdvanced;
    private static final Double INITIAL_VALUE = Double.valueOf(4);

    @BeforeAll
    static void beforeAll() {
        calculatorAdvanced = new CalculatorAdvanced();
        assertThat(calculatorAdvanced, notNullValue(CalculatorAdvanced.class));
        assertThat(calculatorAdvanced.getCurrentValue(), is(Double.valueOf(0)));
    }

    @AfterAll
    static void afterAll() {
        calculatorAdvanced = null;
        assertThat(calculatorAdvanced, nullValue());
    }

    @BeforeEach
    void setUp() {
        calculatorAdvanced.setCurrentValue(Double.valueOf(INITIAL_VALUE));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateAdvancedExceptionsTest() {
        final double lowerBound = CalculatorAdvanced.getLowerBoundCa();
        final double upperBound = CalculatorAdvanced.getUpperBoundCa();

        final Double invalidValueForLowerBound = lowerBound - 1;
        final Double invalidValueForUpperBound = upperBound + 1;

        final int invalidActionLowerValue = CalculatorAdvanced.getActionLowerBound() - 1;
        final int invalidActionUpperValue = CalculatorAdvanced.getActionUpperBound() + 1;
        Character action = '!';

        NumberNotInAreaException exception1 = assertThrows(NumberNotInAreaException.class, () -> {
            calculatorAdvanced.setCurrentValue(invalidValueForLowerBound);
            calculatorAdvanced.calculateAdvanced(action);
        });
        NumberNotInAreaException exception2 = assertThrows(NumberNotInAreaException.class, () -> {
            calculatorAdvanced.setCurrentValue(invalidValueForUpperBound);
            calculatorAdvanced.calculateAdvanced(action);
        });
        assertThat(exception1, is(instanceOf(NumberNotInAreaException.class)));
        assertThat(exception2, is(instanceOf(NumberNotInAreaException.class)));

        Character finalAction1 = Character.valueOf((char) invalidActionLowerValue);
        NotSupportedOperationException exception3 = assertThrows(NotSupportedOperationException.class, () -> {
            calculatorAdvanced.setCurrentValue(lowerBound);
            calculatorAdvanced.calculateAdvanced(finalAction1);
        });
        Character finalAction2 = Character.valueOf((char) invalidActionUpperValue);
        NotSupportedOperationException exception4 = assertThrows(NotSupportedOperationException.class, () -> {
            calculatorAdvanced.setCurrentValue(invalidValueForUpperBound);
            calculatorAdvanced.calculateAdvanced(finalAction2);
        });
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        assertThat(exception4, is(instanceOf(NotSupportedOperationException.class)));

    }

    @Test
    void hasCharacteristicExceptionsTest() {
        final Double lowerBoundHc = CalculatorAdvanced.getLowerBoundHc();
        final Double invalidValue = lowerBoundHc - 1;
        final Character invalidCharacter = 'a';

        NumberNotInAreaException exception1 = assertThrows(NumberNotInAreaException.class, () -> {
            calculatorAdvanced.setCurrentValue(invalidValue);
            calculatorAdvanced.hasCharacteristic(invalidCharacter);
        });
        assertThat(exception1, is(instanceOf(NumberNotInAreaException.class)));

        NotSupportedOperationException exception2 = assertThrows(NotSupportedOperationException.class, () -> {
            calculatorAdvanced.setCurrentValue(lowerBoundHc);
            calculatorAdvanced.hasCharacteristic(invalidCharacter);
        });
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
    }

    @Test
    void calculateAdvancedZeroTest() throws NumberNotInAreaException, NotSupportedOperationException {
        final Double expected = Double.valueOf(1);
        calculatorAdvanced.setCurrentValue(Double.valueOf(0));
        calculatorAdvanced.calculateAdvanced('0');
        assertThat(calculatorAdvanced.getCurrentValue(), is(expected));
    }

    @ParameterizedTest
    @MethodSource("calculateAdvancedNegativeNumbersParams")
    void calculateAdvancedNegativeNumbersTest(Double expected, Character action) throws NumberNotInAreaException, NotSupportedOperationException {
        final Double currentValue = calculatorAdvanced.getCurrentValue();
        if (currentValue >= 0)
            calculatorAdvanced.setCurrentValue(currentValue * -1);
        calculatorAdvanced.calculateAdvanced(action);
        assertThat(calculatorAdvanced.getCurrentValue(), is(expected));
    }

    @ParameterizedTest
    @MethodSource("calculateAdvancedParams")
    void calculateAdvancedTest(Double expected, Character action) throws NumberNotInAreaException, NotSupportedOperationException {
        calculatorAdvanced.calculateAdvanced(action);
        assertThat(calculatorAdvanced.getCurrentValue(), is(expected));
    }

    @ParameterizedTest
    @MethodSource("hasCharacteristicParams")
    void hasCharacteristicTest(Boolean expected, Double currentValue, Character value) throws NotSupportedOperationException, NumberNotInAreaException {
        calculatorAdvanced.setCurrentValue(currentValue);
        Boolean result = calculatorAdvanced.hasCharacteristic(value);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> calculateAdvancedNegativeNumbersParams() {
        return Stream.of(
                Arguments.of(Double.valueOf(1), '0'),
                Arguments.of(Double.valueOf(-4), '1'),
                Arguments.of(Double.valueOf(16), '2'),
                Arguments.of(Double.valueOf(-64), '3'),
                Arguments.of(Double.valueOf(256), '4'),
                Arguments.of(Double.valueOf(-1024), '5'),
                Arguments.of(Double.valueOf(4096), '6'),
                Arguments.of(Double.valueOf(-16384), '7'),
                Arguments.of(Double.valueOf(65536), '8'),
                Arguments.of(Double.valueOf(-262144), '9')
        );
    }

    private static Stream<Arguments> calculateAdvancedParams() {
        return Stream.of(
                Arguments.of(Double.valueOf(1), '0'),
                Arguments.of(Double.valueOf(4), '1'),
                Arguments.of(Double.valueOf(16), '2'),
                Arguments.of(Double.valueOf(64), '3'),
                Arguments.of(Double.valueOf(256), '4'),
                Arguments.of(Double.valueOf(1024), '5'),
                Arguments.of(Double.valueOf(4096), '6'),
                Arguments.of(Double.valueOf(16384), '7'),
                Arguments.of(Double.valueOf(65536), '8'),
                Arguments.of(Double.valueOf(262144), '9'),
                Arguments.of(Double.valueOf(24), '!')
        );
    }

    private static Stream<Arguments> hasCharacteristicParams() {
        return Stream.of(
                Arguments.of(true, Double.valueOf(6), 'P'),
                Arguments.of(true, Double.valueOf(6.34), 'P'),
                Arguments.of(true, Double.valueOf(28), 'P'),
                Arguments.of(true, Double.valueOf(28.2222), 'P'),
                Arguments.of(true, Double.valueOf(496.1111), 'P'),
                Arguments.of(true, Double.valueOf(8128), 'P'),
                Arguments.of(true, Double.valueOf(8128.4342), 'P'),
                Arguments.of(true, Double.valueOf(33550336), 'P'),
                Arguments.of(true, Double.valueOf(33550336.4321423), 'P'),
                Arguments.of(true, Double.valueOf(6), 'A'),
                Arguments.of(true, Double.valueOf(6.332), 'A'),
                Arguments.of(true, Double.valueOf(153), 'A'),
                Arguments.of(true, Double.valueOf(371), 'A'),
                Arguments.of(true, Double.valueOf(1634), 'A'),
                Arguments.of(true, Double.valueOf(9474), 'A'),
                Arguments.of(true, Double.valueOf(54748), 'A'),
                Arguments.of(true, Double.valueOf(548834.32323), 'A'),
                Arguments.of(false, Double.valueOf(1), 'P'),
                Arguments.of(false, Double.valueOf(1.1131), 'P'),
                Arguments.of(false, Double.valueOf(153), 'P'),
                Arguments.of(false, Double.valueOf(1634), 'P'),
                Arguments.of(false, Double.valueOf(54748), 'P'),
                Arguments.of(false, Double.valueOf(548834), 'P'),
                Arguments.of(false, Double.valueOf(28), 'A'),
                Arguments.of(false, Double.valueOf(28.2222), 'A'),
                Arguments.of(false, Double.valueOf(496.1111), 'A'),
                Arguments.of(false, Double.valueOf(8128), 'A'),
                Arguments.of(false, Double.valueOf(8128.4342), 'A'),
                Arguments.of(false, Double.valueOf(33550336), 'A'),
                Arguments.of(false, Double.valueOf(33550336.4321423), 'A')
        );
    }
}