package org.unibl.etf.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.unibl.etf.exceptions.DivisionByZeroException;
import org.unibl.etf.exceptions.NotSupportedOperationException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Test class for Calculator class
 *
 * @author Dragan Zrilic
 * @version 1.0.0
 */
class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
        assertThat(calculator, notNullValue(Calculator.class));
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
    }

    @AfterAll
    static void afterAll() {
        calculator = null;
        assertThat(calculator, nullValue());
    }

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

//    @ParameterizedTest
//    @MethodSource("addTestParams")
//    void addTestParams(Double expected, Double value) throws NotSupportedOperationException, DivisionByZeroException {
//        final char operator = '+';
//        calculator.calculate(value, operator);
//        assertThat(calculator.getCurrentValue(), is(expected));
//    }
//
//    @ParameterizedTest
//    @MethodSource("subTestParams")
//    void subTestParams(Double expected, Double value) throws NotSupportedOperationException, DivisionByZeroException {
//        final char operator = '-';
//        calculator.calculate(value, operator);
//        assertThat(calculator.getCurrentValue(), is(expected));
//    }
//
//    @ParameterizedTest
//    @MethodSource("mulTestParams")
//    void mulTestParams(Double expected, Double value) throws NotSupportedOperationException, DivisionByZeroException {
//        final char operator = '*';
//        calculator.calculate(value, operator);
//        assertThat(calculator.getCurrentValue(), is(expected));
//    }
//
//    @ParameterizedTest
//    @MethodSource("divTestParams")
//    void divTestParams(Double expected, Double value) throws NotSupportedOperationException, DivisionByZeroException {
//        final char operator = '/';
//        calculator.calculate(value, operator);
//        assertThat(calculator.getCurrentValue(), is(expected));
//    }


    @Test
    void calculateTest() throws NotSupportedOperationException, DivisionByZeroException {
        // Test addition
        char operator = '+';
        calculator.calculate(Double.valueOf(5), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(5)));
        calculator.calculate(Double.valueOf(-5), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
        calculator.calculate(Double.valueOf(1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(1)));
        calculator.calculate(Double.valueOf(-1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
        calculator.calculate(Double.valueOf(0), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
        calculator.calculate(Double.valueOf(-10), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(-10)));
        // Test subtraction
        operator = '-';
        calculator.setCurrentValue(Double.valueOf(0));
        calculator.calculate(Double.valueOf(0), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
        calculator.calculate(Double.valueOf(-1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(1)));
        calculator.calculate(Double.valueOf(1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
        calculator.calculate(Double.valueOf(5), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(-5)));
        calculator.calculate(Double.valueOf(-10), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(5)));
        calculator.calculate(Double.valueOf(5), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0)));
        // Test multiplication
        operator = '*';
        calculator.setCurrentValue(Double.valueOf(1));
        calculator.calculate(Double.valueOf(2), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(2)));
        calculator.calculate(Double.valueOf(2), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(4)));
        calculator.calculate(Double.valueOf(10), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(40)));
        calculator.calculate(Double.valueOf(-1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(-40)));
        calculator.calculate(Double.valueOf(-1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(40)));
        // Test division
        operator = '/';
        calculator.setCurrentValue(Double.valueOf(10));
        calculator.calculate(Double.valueOf(1), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(10)));
        calculator.calculate(Double.valueOf(5), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(2)));
        calculator.calculate(Double.valueOf(2), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(1)));
        calculator.calculate(Double.valueOf(2), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0.5)));
        calculator.calculate(Double.valueOf(2), operator);
        assertThat(calculator.getCurrentValue(), is(Double.valueOf(0.25)));
    }

    @Test
    void calculateTestExceptions() {
        char finalOperator1 = '/';
        DivisionByZeroException divEx = assertThrows(DivisionByZeroException.class,
                () -> calculator.calculate(Double.valueOf(0), finalOperator1));
        assertThat(divEx, is(instanceOf(DivisionByZeroException.class)));

        char finalOperator2 = '.';
        NotSupportedOperationException exception = assertThrows(NotSupportedOperationException.class,
                () -> calculator.calculate(Double.valueOf(0), finalOperator2));
        assertThat(exception, is(instanceOf(NotSupportedOperationException.class)));
    }
}