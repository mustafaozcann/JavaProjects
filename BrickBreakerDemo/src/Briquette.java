import java.awt.Color;

public class Briquette{
	
	private final int width = 40;
	private final int height = 20;
	private int posX;
	private int posY;
	private Color color;
	private boolean Breakdown = false;
	
	public Briquette(int posX, int posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}

	public boolean isBreakdown() {
		return Breakdown;
	}

	public void setBreakdown(boolean isBreakdown) {
		this.Breakdown = isBreakdown;
	}

	public Color getColor() {
		return color;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
