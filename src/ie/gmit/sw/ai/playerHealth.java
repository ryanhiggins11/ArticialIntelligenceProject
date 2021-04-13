package ie.gmit.sw.ai;

public class playerHealth {
	private int playerHealth = 100;
	public int Strength;
	public int getStrength() {
		return Strength;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}
	public void playerHit() {
		playerHealth -= 10;
	}
}
