package quentinetpierre.calculator;

import org.junit.Before;
import org.junit.Test;
import quentinetpierre.calculator.exceptions.OutOfBoundException;

import java.lang.reflect.Method;

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


    // TEST METHOD EXISTS
    @Test
    public void divideMethodExists(){
        Boolean b = false;

        for (Method m : calculator.getClass().getMethods() ) {
            if(m.getName().equals("divide")){
                if( m.getParameterCount() == 2
                        && m.getParameterTypes()[0] == Integer.class
                        && m.getParameterTypes()[1] == Integer.class
                ) b = true;
            }
        }

        assertTrue(b);
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
    public void divideNegativePositive() {
        assertEquals(calculator.divide(-4, 2), -2);
    }
    @Test
    public void divideNegativeNegative() {
        assertEquals(calculator.divide(-4,-2), 2);
    }
    @Test(expected = Exception.class)
    public void dividePositiveZero(){
        calculator.divide(1,0);
    }
    @Test
    public void divideZeroPositive() {
        assertEquals(calculator.divide(0,-2), 0);
    }
    @Test(expected = Exception.class)
    public void divideZeroZero(){
        calculator.divide(0,0);
    }

    @Test
    public void divideMaxMax(){
        assertEquals(calculator.divide(Integer.MAX_VALUE, Integer.MAX_VALUE),1);
    }
    @Test
    public void divideZeroMax(){
        assertEquals(calculator.divide(0, Integer.MAX_VALUE), 0);
    }
    @Test
    public void divideMaxNegative(){
        assertEquals(calculator.divide( Integer.MAX_VALUE,-1), Integer.MIN_VALUE+1);
    }
    @Test(expected = Exception.class)
    public void divideMaxZero(){
        calculator.divide(Integer.MAX_VALUE,0);
    }

}
