package quentinetpierre.calculator;

import org.junit.Before;
import org.junit.Test;
import quentinetpierre.calculator.exceptions.OutOfBoundException;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubstractionTest {

    static SuperCalculator1998Application calculator;

    @Before
    public void beforeClass(){
        calculator = new SuperCalculator1998Application();
    }

    // TEST METHOD EXISTS
    @Test
    public void testMethodExists(){
        Boolean b = false;

        for (Method m : calculator.getClass().getMethods() ) {
            if(m.getName().equals("minus")){
                if( m.getParameterCount() == 2
                        && m.getParameterTypes()[0] == Integer.class
                        && m.getParameterTypes()[1] == Integer.class
                ) b = true;
            }
        }

        assertTrue(b);
    }

    // BASIC TEST
    @Test
    public void testWithNormalValues(){
        assertEquals(calculator.minus(3,2), 1);
    }

    // NEGATIVE VALUES
    @Test
    public void testWithNegativeValueAsFirstParameter(){
        assertEquals(calculator.minus(-1,2), -3);
    }
    @Test
    public void testWithNegativeValueAsSecondParameter(){
        assertEquals(calculator.minus(1,-2), 3);
    }
    @Test
    public void testWithNegativeValues(){
        assertEquals(calculator.minus(-1,-2), 1);
    }

    // VALUES = ZERO
    @Test
    public void testWithZeroAsFirstParameter(){
        assertEquals(calculator.minus(1,0), 1);
    }
    @Test
    public void testWithZeroAsSecondParameter(){
        assertEquals(calculator.minus(0,2), -2);
    }
    @Test
    public void testWithZeros(){
        assertEquals(calculator.minus(0,0), 0);
    }

    // NEGATIVE VALUES AND ZEROS
    @Test
    public void testWithNegativeValueAndZero(){
        assertEquals(calculator.minus(-1,0), -1);
    }
    @Test
    public void testWithZeroAndNegativeValue(){
        assertEquals(calculator.minus(0,-1), 1);
    }

    // MAX VALUES
    @Test(expected = OutOfBoundException.class)
    public void testWithMinIntValue(){
        calculator.minus(-Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    @Test
    public void testWithMinIntValueAndZero(){
        assertEquals(calculator.minus(0, Integer.MAX_VALUE), -Integer.MAX_VALUE);
    }
    @Test
    public void testWithMinIntValueAndNegativeValue(){
        assertEquals(calculator.minus(1, Integer.MAX_VALUE), -Integer.MAX_VALUE+1);
    }

}
