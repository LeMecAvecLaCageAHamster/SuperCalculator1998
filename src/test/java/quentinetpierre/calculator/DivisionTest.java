package quentinetpierre.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

    static SuperCalculator1998Application calculator;

    @Before
    public void beforeClass(){
        calculator = new SuperCalculator1998Application();
    }


    @Test
    public void calculatorExists(){
        assertNotNull(calculator);
    }


    @Test
    public void dividePositivePositive(){
        assertEquals(calculator.divide(4,2), 2);
    }
    @Test
    public void dividePositiveNegative() {
        assertEquals(calculator.divide(4, -2), -2);
    }

    @Test
    public void divide_negative_positive() {
        assertEquals(calculator.divide(-4, 2), -2);
    }
    @Test
    public void divide_negative_negative() {
        assertEquals(calculator.divide(-4,-2), 2);
    }
    @Test(expected = Exception.class)
    public void divide_positive_zero(){
        calculator.divide(1,0);
    }
    @Test
    public void divide_zero_positive() {
        assertEquals(calculator.divide(0,-2), 0);
    }
    @Test(expected = Exception.class)
    public void divide_zero_zero(){
        calculator.divide(0,0);
    }

}
