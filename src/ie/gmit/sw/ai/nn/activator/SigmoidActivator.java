package ie.gmit.sw.ai.nn.activator;


/*
 * Sig Function here
 * 1 divided by 1 + e to the power of -x
 * Derivative of this which is f(x)
 * in the case of sigmoidal f(x) * 1 - f(x)
 * we will use this in the backpropagation trainer
 */

public class SigmoidActivator implements Activator{
	//f(x) = 1 / (1 + exp( − x))
	public double activate(double value) {
		return (1.0d / (1.0d + Math.exp(-value)));
	}
	
	//Derivative dy/dx = f(x)' = f(x) * (1 - f(x))
	public double derivative(double value) {
		return (value * (1.0d - value));
	}
}