package org.unibl.etf.calculator;

import org.unibl.etf.exceptions.DivisionByZeroException;
import org.unibl.etf.exceptions.NotSupportedOperationException;

/**
 * Represents a simple calculator for basic arithmetic operations (+,-,*,/).
 * @author Dragan Zrilic
 * @version 1.0.0
 */
public class Calculator {

    /**
     * Value on which all operations will be applied
     */
    private Double currentValue;

    /**
     * Constructor which initializes currentValue to 0
     */
    public Calculator() {
        currentValue = Double.valueOf(0);
    }

//    public Calculator(Double currentValue) {
//        this.currentValue = currentValue;
//    }


    /**
     * Calculates a simple mathematic operation on currentValue value based on the provided operator.
     * @param value Second operand in operation
     * @param operator Specifies the operation. Valid inputs are '+', '-', '*', '/'
     * @throws NotSupportedOperationException Is thrown when operator is not valid
     * @throws DivisionByZeroException Is thrown when operator is set to '/' and value is 0
     */
    public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException {
        switch (operator) {
            case '+':
                currentValue += value;
                break;
            case '-':
                currentValue -= value;
                break;
            case '*':
                currentValue *= value;
                break;
            case '/':
                if (0 == value) {
                    throw new DivisionByZeroException("Can't divide by zero");
                }
                currentValue /= value;
                break;
            default:
                throw new NotSupportedOperationException(String.format("Operation %c not supported!", operator));
        }

    }


    /**
     * Getter for currentValue
     * @return Double currentValue
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Setter for currentValue.
     * @param currentValue - value which will be used as the new currentValue
     */
    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }
}
