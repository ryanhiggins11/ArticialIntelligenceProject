package ie.gmit.sw.ai.nn.activator;

import ie.gmit.sw.ai.n.BackpropagationTrainer;
import ie.gmit.sw.ai.n.NeuralNetwork;
import ie.gmit.sw.ai.n.Utils;
import ie.gmit.sw.ai.nn.activator.Activator;

public class GameRunner {
	
	public static void main(String[] args) throws Exception {
		new GameRunner().go();
	}
	
	public void go() throws Exception{
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);
		
		BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.6, 10000);
		
		double[] arr = {2, 1, 0, 2};
		double[] result = nn.process(arr);
		int classification = Utils.getMaxIndex(result) + 1;
		
		if(classification == 1) {
			panic();
		}
		else if(classification == 2) {
			attack();
		}
		else if(classification == 3) {
			hide();
		}
		else {
			run();
		}
	}
	
	public void panic() {
		System.out.println("Panic...");
	}
	
	public void attack() {
		System.out.println("Attack...");
	}
	
	public void hide() {
		System.out.println("Hide...");
	}
	
	public void run() {
		System.out.println("Run...");
	}

	/*
	 * ------------------------------------------------------------------------
	 * B.Sc. (Hons) in Software Development - Artificial Intelligence
	 * ------------------------------------------------------------------------
	 * 
	 * Data set for the Neural Network Game Action Lab
	 * 
	 * Inputs ------------- 1) Health (2 = Healthy, 1 = Minor Injuries, 0 = Serious
	 * Injuries) 2) Has a Sword (1 = yes, 0 = no) 3) Has a Gun (1 = yes, 0 = no) 4)
	 * Number of Enemies (This value may need to be normalized)
	 * 
	 * Outputs ------------- 1) Panic 2) Attack 3) Hide 4) Run
	 * 
	 */

	private double[][] data = { // Health, Sword, Gun, Enemies
			{ 2, 0, 0, 0 }, { 2, 0, 0, 1 }, { 2, 0, 1, 1 }, { 2, 0, 1, 2 }, { 2, 1, 0, 2 }, { 2, 1, 0, 1 },
			{ 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 }, { 1, 0, 1, 2 }, { 1, 1, 0, 2 }, { 1, 1, 0, 1 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 2 }, { 0, 1, 0, 2 }, { 0, 1, 0, 1 } };

	private double[][] expected = { // Panic, Attack, Hide, Run
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 1.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 },
			{ 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 1.0, 0.0, 0.0 },
			{ 0.0, 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 } };

}