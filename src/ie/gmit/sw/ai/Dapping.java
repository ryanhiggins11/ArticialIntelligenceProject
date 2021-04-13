package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;



public class Dapping {
	
	private static final String FCL_FILE = "./Resources/fcl/FuzzyLogic.fcl";
	
	public double getDappingLevel(int player_health, int monster_health) {
		FIS fis = FIS.load(FCL_FILE, true);
		FunctionBlock fb = fis.getFunctionBlock("getDappingLevel");
		fis.setVariable("player_health", player_health);
		fis.setVariable("monster_health", monster_health);
		fis.evaluate();
		Variable victory = fb.getVariable("victory");
		/*
		 * Uncomment out these lines below to get the graphs to display.
		 */
		//JFuzzyChart.get().chart(fis); 
		//JFuzzyChart.get().chart(victory.getDefuzzifier(), "Victory", true);

		return victory.getValue();
		}
	
	public static void main(String [] args) {
		Dapping d = new Dapping();
		double Dapping = d.getDappingLevel(20, 1);
		System.out.println(Dapping);
	}
}