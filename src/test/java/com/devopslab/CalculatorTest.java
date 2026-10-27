
package com.devopslab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(4, 6));
    }

    @Test
    void testSubtraction() {
        assertEquals(4, calculator.subtract(9, 5));
    }

    @Test
    void testMultiplication() {
        assertEquals(24, calculator.multiply(4, 6));
    }

    @Test
    void testEvenNumber() {
        assertTrue(calculator.isEven(8));
    }

    @Test
    void testOddNumber() {
        assertFalse(calculator.isEven(7));
    }

    @Test
    void testNegativeNumberAddition() {
        assertEquals(2, calculator.add(-3, 5));
    }
}
