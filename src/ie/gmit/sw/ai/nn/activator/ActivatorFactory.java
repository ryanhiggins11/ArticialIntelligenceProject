package ie.gmit.sw.ai.nn.activator;

import ie.gmit.sw.ai.nn.activator.Activator.ActivationFunction;
/*
 * Factory Class that lets us get a handle on one of these
 * 
 */
public class ActivatorFactory {
	private static ActivatorFactory fact = new ActivatorFactory();
	
	private ActivatorFactory(){
	}
	
	public static ActivatorFactory getInstance(){
		return fact;
	}
	
	public Activator getActivator(Activator.ActivationFunction function){
		if (function == ActivationFunction.HyperbolicTangent){
			return new HyperbolicTangentActivator();			
		}else{
			return new SigmoidActivator();		
		}		
	}
}