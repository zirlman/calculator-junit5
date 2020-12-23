package org.unibl.etf;

import org.unibl.etf.calculator.Calculator;
import org.unibl.etf.calculator.CalculatorAdvanced;
import org.unibl.etf.exceptions.DivisionByZeroException;
import org.unibl.etf.exceptions.NotSupportedOperationException;
import org.unibl.etf.exceptions.NumberNotInAreaException;

import java.util.Enumeration;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
//        double currentValue = 10;
//        double value = 0;
//        char[] operations = new char[]{'+', '-', '*', '/', 'a'};
//
//        Calculator calculator = new Calculator(currentValue);
//        for (char op : operations) {
//            try {
//                double oldValue = calculator.getCurrentValue();
//                calculator.calculate(value, op);
//                double newValue = calculator.getCurrentValue();
//                calculator.setCurrentValue(currentValue);
//                System.out.println(String.format("%f %c %f = %f", oldValue, op, value, newValue));
//            } catch (NotSupportedOperationException | DivisionByZeroException e) {
//                System.out.println(String.format("%s | Message: %s", e.getClass(), e.getMessage()));
//            }
//        }
//        System.out.println("============== CALCULATOR ADVANCED ==============");
//        currentValue = 4;
//        CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced(currentValue);
//        operations = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!'};
//        for (char op : operations) {
//            try {
//                double oldValue = calculatorAdvanced.getCurrentValue();
//                calculatorAdvanced.calculateAdvanced(op);
//                double newValue = calculatorAdvanced.getCurrentValue();
//                calculatorAdvanced.setCurrentValue(currentValue);
//                System.out.println(String.format("%f ^ %c = %f", oldValue, op, newValue));
//            } catch (NumberNotInAreaException | NotSupportedOperationException e) {
//                System.out.println(String.format("%s | Message: %s", e.getClass(), e.getMessage()));
//            }
//        }
//        System.out.println("-------------------------------------------------");
//        int[] numbers = new int[]{6, 28, 153, 1634};
//        for (int n : numbers) {
//            calculatorAdvanced.setCurrentValue((double) n);
//            try {
//                if (calculatorAdvanced.hasCharacteristic('A')) {
//                    System.out.println(String.format("%d is an Armstrong number", n));
//                }
//                if (calculatorAdvanced.hasCharacteristic('P')) {
//                    System.out.println(String.format("%d is a Perfect number", n));
//                }
//                if (calculatorAdvanced.hasCharacteristic('z')) ;
//            } catch (NotSupportedOperationException | NumberNotInAreaException e) {
//                System.out.println(String.format("%s | Message: %s", e.getClass(), e.getMessage()));
//            }
//        }
    }
}
