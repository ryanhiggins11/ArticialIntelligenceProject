package ie.gmit.sw.ai;

import javafx.application.Application;
import ie.gmit.sw.ai.n.BackpropagationTrainer;
import ie.gmit.sw.ai.n.NeuralNetwork;
import ie.gmit.sw.ai.n.Utils;
import ie.gmit.sw.ai.nn.activator.Activator;

public class Runner {
	
	private enemyHealth eh = new enemyHealth();
	private playerHealth ph = new playerHealth();
	public static void main(String[] args) throws Exception {
		new Runner().go();
		/*
		 * PLEASE READ CAREFULLY
		 * ---------------------
		 * If you need to load FCL functions to the application or
		 * train, configure and load a neural network, then it is 
		 * best to do all of this before loading the UI. Launching
		 * a UI in any language or framework and then starting a 
		 * long running task in the same thread is guaranteed to
		 * freeze the screen and crash the programme.
		 * 
		 * NB: you can assume that the JavaFX 15 API is already
		 * available and configured on the MODULE-PATH (NOT THE 
		 * CLASSPATH). 
		 */
		
		  //Add long-running initialisation instructions here.
		
		
		
		/*
		 * Launch the JavaFX UI only when all the long-running AI 
		 * configuration tasks have been completed. Use the arrow 
		 * keys to move the player character and the 'Z' key to 
		 * toggle the zoom in / out.
		 */
		Application.launch(GameWindow.class, args);
	}
	
	
	public void go() throws Exception{
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 2, 1, 2);
		
		BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.6, 10000);
		
		double[] arr = {ph.getPlayerHealth(), eh.getEnemyHealth()};
		double[] result = nn.process(arr);
		int classification = Utils.getMaxIndex(result) + 1;
		
		if(classification == 1){
			panic();
		}
		else{
			attack();
		}
	}
	
	public void panic() {
		System.out.println("Panic...");
		
	}
	
	public void attack() {
		System.out.println("Attack...");
	}
	

	/*
	 * ------------------------------------------------------------------------
	 * B.Sc. (Hons) in Software Development - Artificial Intelligence
	 * ------------------------------------------------------------------------
	 * 
	 * Data set for the Neural Network Game Action Lab
	 * 
	 * 
	 */

	private double[][] data = { 
			{ 2, 0}, { 2, 1,}, { 2, 2}, //if players healthy = 2, 0 and enemy health = low , 2 1 = player healthy enemy health half then 2, 2 both equal high
			{ 1, 0}, { 1, 1 }, { 1, 2}, // 1, 0 = player half healthy enemy goosed, 
			{ 0, 0}, { 0, 1}, {0, 2}};
			

	private double[][] expected = {
			{ 0, 1}, { 1, 0}, { 0, 1}, // 1, 0 panic either panic or attack ,, 0,1 so classification would be 2.. if classifacation = 0
			{ 1, 0}, { 0, 1 }, { 0, 1},
			{ 0, 1}, { 0, 1}, {0, 1}};

}