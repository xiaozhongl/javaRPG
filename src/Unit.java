import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Unit extends Entity {
	
	private int hp;
	private int maxHp;
	private int damage;
	private int cooldown;
	private String Name;
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	/**
	 * render health bar for each unit
	 * @param g Graphics
	 * @param camera camera
	 */
	public void renderHealthBar(Graphics g, Camera camera){
		if (checkInCamera (camera) && isExist()){
			// Bar colors
			
	        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
	        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
	        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
	        
	        // Variables for layout
	        String text;                // Text to display
	        float text_x, text_y;         // Coordinates to draw text
	        float bar_x, bar_y;           // Coordinates to draw rectangles
	        float bar_width, bar_height;  // Size of rectangle to draw
	        float hp_bar_width;           // Size of red (HP) rectangle
	        float health_percent;       // Player's health, as a percentage
	       
	        // Display the player's health/name bar
	        text = getName();
	        bar_width = Math.max(g.getFont().getWidth(text) + 6, 70);
	        bar_height = 20;
	        bar_x = (getXPos() - camera.getMinX()) - bar_width/2;
	        bar_y = (getYPos() - camera.getMinY()) - bar_height - 30;
	        health_percent = (float)hp / maxHp;                        
	        hp_bar_width = (int) (bar_width * health_percent);
	        
	        
	        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
	        text_y = bar_y + (bar_height - g.getFont().getHeight(text)) / 2;
	        g.setColor(BAR_BG);
	        g.fillRect(bar_x, bar_y, bar_width, bar_height);
	        g.setColor(BAR);
	        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
	        g.setColor(VALUE);
	        g.drawString(text, text_x, text_y);
		}
	}
	
	/**
	 * check if the unit is exist in the world
	 */
	public void checkDeath(){
		if (getHp() <= 0)
			setExist(false);
	}
	
	
}
