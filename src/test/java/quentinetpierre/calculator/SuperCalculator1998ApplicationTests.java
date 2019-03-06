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
	public void multiply(){
		assertEquals(calculator.multiply(2,2), 4);
	}

	@Test
	public void divide(){
		assertEquals(calculator.divide(4,2), 2);
	}
	@Test(expected = Exception.class)
	public void zero_divisiion(){
		calculator.divide(1,0);
	}

}
