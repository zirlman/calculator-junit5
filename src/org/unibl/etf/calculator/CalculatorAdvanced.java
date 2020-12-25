package org.unibl.etf.calculator;

import org.unibl.etf.exceptions.NotSupportedOperationException;
import org.unibl.etf.exceptions.NumberNotInAreaException;

/**
 * Inherits the Calculator class.
 * Ads support for advanced computation like factoriel calculation, n-th power, check if the currentValue is an Armstrong
 * number, or a perfect number.
 *
 * @author Dragan Zrilic
 * @version 1.0.0
 */
public class CalculatorAdvanced extends Calculator {

    /**
     * Specifies the lower bound for currentValue in hasCharacteristic. Default value is 1
     */
    private static final double LOWER_BOUND_HC = 1;

    /**
     * Specifies the lower bound for currentValue in calculateAdvanced. Default value is 0
     */
    private static final double LOWER_BOUND_CA = 0;
    /**
     * Specifies the uper bound for currentValue in calculateAdvanced. Default value is 10
     */
    private static final double UPPER_BOUND_CA = 10;

    /**
     * Specifies the lower bound for calculating the power in calculateAdvanced. Default value is '0'
     */
    private static final char ACTION_LOWER_BOUND = '0';
    /**
     * Specifies the upper bound for calculating the power calculateAdvanced. Default value is '0'
     */
    private static final char ACTION_UPPER_BOUND = '9';

    /**
     * No argument constructor
     */
    public CalculatorAdvanced() {
    }

//    public CalculatorAdvanced(Double currentValue) {
//        super(currentValue);
//    }


    /**
     * Helper functions which is used to calculate the factoriel of the currentValue
     */
    private void calculateFactoriel(int factoriel) {
        for (int i = factoriel - 1; i > 1; i--) {
            factoriel *= i;
        }
        setCurrentValue((double) factoriel);
    }


    /**
     * Helper function for calculating power
     *
     * @param value The value for which we want to calculate the power
     * @param power The exponent used to raise the value.
     * @return int A number representing the given base taken to the power of the given exponent.
     */
    private int getPower(int value, int power) {
        int res = 1;
        for (int i = 0; i < power; i++) {
            res *= value;
        }
        return res;
    }

    /**
     * Calculates power of current value.
     *
     * @param power The exponent used to raise the currentValue.
     * @throws NumberNotInAreaException Is thrown if currentValue is {@literal <} 1
     */
    private void calculatePower(int currentValue, int power) throws NumberNotInAreaException {
        if (power == 0) {
            setCurrentValue((double) 1);
        } else {
            setCurrentValue((double) getPower(currentValue, power));
        }
    }

    /**
     * Calculates either the power of currentValue or the factoriel depending on the provided action.
     *
     * @param action Character which specifies the action which will be applied. For values [0,9] the character is treated
     *               as the power, while for value '!' the factoriel of currentValue is calculated
     * @throws NumberNotInAreaException       Is thrown if currentValue is out of range [LOWER_BOUND_CA,UPPER_BOUND_CA]
     * @throws NotSupportedOperationException Is thrown if action is not supported
     */
    public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
        if ('!' == action) {
            double currentValue = getCurrentValue();
            if (LOWER_BOUND_CA <= currentValue && currentValue <= UPPER_BOUND_CA)
                calculateFactoriel(getCurrentValue().intValue());
            else {
                throw new NumberNotInAreaException(String.format("Current value (%f) must be in range [%f,%f]", currentValue, LOWER_BOUND_CA, UPPER_BOUND_CA));
            }
        } else if (ACTION_LOWER_BOUND <= action && action <= ACTION_UPPER_BOUND) {
            calculatePower(getCurrentValue().intValue(), Integer.parseInt(String.valueOf(action)));
        } else {
            throw new NotSupportedOperationException(String.format("Operation '%c' not supported!", action));
        }
    }


    /**
     * Checks if currentValue is an Armstrong number
     *
     * @return Boolean Whether the currentValue is an Armstrong number or not
     */
    private Boolean isArmstrong(int currentValue) {
        int power = String.valueOf(currentValue).length();
        int sum = 0;
        for (int i = 0; i < power; i++) {
            sum += getPower(currentValue % 10, power);
            currentValue /= 10;
        }
        return sum == getCurrentValue().intValue();
    }

    /**
     * Checks if currentValue is a Perfect number
     *
     * @return Boolean Whether the currentValue is a Perfect number or not
     */
    private Boolean isPerfect(int currentValue) {
        double sum = 0;
        for (int i = 1; i <= currentValue / 2; i++) {
            if (currentValue % i == 0) {
                sum += i;
            }
        }
        return sum == currentValue;
    }

    /**
     * Checks if currentValue is an Armstrong number or a perfect number
     *
     * @param value Specifies which property of currentValue will be checked. Valid inputs are ['A','P']
     * @return Boolean Whether the currentValue has the specified characteristic
     * @throws NotSupportedOperationException Is thrown if value is not a valid input
     * @throws NumberNotInAreaException       Is thrown if currentValue is {@literal <} 1
     */
    public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
        if (getCurrentValue() < LOWER_BOUND_HC) {
            throw new NumberNotInAreaException(String.format("Current value (%f) must be > 1!", getCurrentValue()));
        }

        switch (value) {
            case 'A':
                return isArmstrong(getCurrentValue().intValue());
            case 'P':
                return isPerfect(getCurrentValue().intValue());
            default:
                throw new NotSupportedOperationException(String.format("Value %c is invalid! Valid values are 'A' or 'P'", value));
        }
    }

    /**
     * @return double Getter for the lower bound of currentValue in {@link #hasCharacteristic(char) hasCharacteristic} method
     */
    public static double getLowerBoundHc() {
        return LOWER_BOUND_HC;
    }

    /**
     * @return double Getter for the lower bound of currentValue in {@link #calculateAdvanced(char) calculateAdvanced} method
     */
    public static double getLowerBoundCa() {
        return LOWER_BOUND_CA;
    }

    /**
     * @return double Getter for the upper bound of currentValue in {@link #calculateAdvanced(char) calculateAdvanced} method
     */
    public static double getUpperBoundCa() {
        return UPPER_BOUND_CA;
    }

    /**
     * @return char Getter for the lower bound of the action parameter in {@link #calculateAdvanced(char) calculateAdvanced} method
     */
    public static char getActionLowerBound() {
        return ACTION_LOWER_BOUND;
    }

    /**
     * @return char Getter for the upper bound of the action parameter in {@link #calculateAdvanced(char) calculateAdvanced} method
     */
    public static char getActionUpperBound() {
        return ACTION_UPPER_BOUND;
    }
}
