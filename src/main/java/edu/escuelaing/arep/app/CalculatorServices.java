package edu.escuelaing.arep.app;



public class CalculatorServices implements Calculator {
	
	@Override
	public Double calculateSen(Double value) {
		Double sen = java.lang.Math.sin(value);
		return sen;
	}

	@Override
	public Double calculateTan(Double value) {
		Double tan = java.lang.Math.tan(value);
		return tan;
	}



}