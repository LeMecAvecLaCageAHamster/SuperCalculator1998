package quentinetpierre.calculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SuperCalculator1998ApplicationTests {

	static SuperCalculator1998Application calculator;

	@Before
	public void beforeClass(){
		calculator = new SuperCalculator1998Application();
	}

	@Test
	public void plus(){
		assertEquals(calculator.plus(1,2), 3);
	}

	@Test
	public void minus(){
		assertEquals(calculator.minus(3,2), 1);
	}

	@Test
	public void multiply_by_positive(){
		assertEquals(calculator.multiply(2,1), 2);
	}
	@Test
	public void multiply_by_negative(){
		assertEquals(calculator.multiply(3,-2), -6);
		assertEquals(calculator.multiply(-4,3), -12);
		assertEquals(calculator.multiply(-5,-4), 20);
	}

	@Test
	public void divide(){
		assertEquals(calculator.divide(4,2), 2);
	}

}
