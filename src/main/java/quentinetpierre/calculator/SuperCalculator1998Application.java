package quentinetpierre.calculator;

import quentinetpierre.calculator.exceptions.OutOfBoundException;

public class SuperCalculator1998Application {

	public static void main(String[] args) {
	}

	public int plus(Integer a, Integer b){
		if((Math.abs(a) == Integer.MAX_VALUE && Math.abs(b) == Integer.MAX_VALUE) && a != b){
			throw new OutOfBoundException();
		}

		return a+b;
	}

	public int minus(Integer a, Integer b) throws OutOfBoundException {
        if((Math.abs(a) == Integer.MAX_VALUE && Math.abs(b) == Integer.MAX_VALUE) && a != b){
            throw new OutOfBoundException();
        }

		return a-b;
	}

	public int multiply(int a, int b){
		return a*b;
	}

	public int divide(Integer a, Integer b){
		return a/b;
	}

}
