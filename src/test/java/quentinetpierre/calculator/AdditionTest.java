package quentinetpierre.calculator;

import org.junit.Before;
import org.junit.Test;
import quentinetpierre.calculator.exceptions.OutOfBoundException;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class AdditionTest {
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
            if(m.getName().equals("plus")){
                if( m.getParameterCount() == 2
                    && m.getParameterTypes()[0] == Integer.class
                    && m.getParameterTypes()[1] == Integer.class
                ) b = true;
            }
        }

        assertTrue(b);
    }

    // TEST TYPE
    /*
    @Test(expected = Exception.class)
    public void testWithWrongType(){
        calculator.plus("Le reseau de l'imie et bah c'est bien de la merde", 1);
    }
    */

    // BASIC TEST
    @Test
    public void testPlusMethodWithNormalValues(){
        assertEquals(calculator.plus(1,2), 3);
    }

    // NEGATIVE VALUES
    @Test
    public void testWithNegativeValueAsFirstParameter(){
        assertEquals(calculator.plus(-1,2), 1);
    }
    @Test
    public void testWithNegativeValueAsSecondParameter(){
        assertEquals(calculator.plus(1,-2), -1);
    }
    @Test
    public void testWithNegativeValues(){
        assertEquals(calculator.plus(-1,-2), -3);
    }

    // VALUES = ZERO
    @Test
    public void testWithZeroAsFirstParameter(){
        assertEquals(calculator.plus(1,0), 1);
    }
    @Test
    public void testWithZeroAsSecondParameter(){
        assertEquals(calculator.plus(0,2), 2);
    }
    @Test
    public void testWithZeros(){
        assertEquals(calculator.plus(0,0), 0);
    }

    // NEGATIVE VALUES AND ZEROS
    @Test
    public void testWithNegativeValueAndZero(){
        assertEquals(calculator.plus(-1,0), -1);
    }
    @Test
    public void testWithZeroAndNegativeValue(){
        assertEquals(calculator.plus(0,-1), -1);
    }

    // MAX VALUES
    @Test(expected = OutOfBoundException.class)
    public void testWithMaxIntValue(){
        calculator.plus(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    @Test
    public void testWithMaxIntValueAndZero(){
        assertEquals(calculator.plus(0, Integer.MAX_VALUE), Integer.MAX_VALUE);
    }
    @Test
    public void testWithMaxIntValueAndNegativeValue(){
        assertEquals(calculator.plus(-1, Integer.MAX_VALUE), Integer.MAX_VALUE-1);
    }

}
