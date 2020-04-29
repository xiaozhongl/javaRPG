import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class Villager extends Unit {
	
	public final int DIALOGUE_PERIOD = 4000;
	private int dialogueTimer = 0;
	private String dialogue;
	
	
	public String getDialogue() {
		return dialogue;
	}

	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}

	public int getDialogueTimer() {
		return dialogueTimer;
	}

	public void setDialogueTimer(int dialogueTimer) {
		this.dialogueTimer = dialogueTimer;
	}
	
	/**
	 * render the dialogue bar of villagers
	 * @param g
	 * @param camera
	 * @param text dialogue the villager is going to make
	 */
	public void renderDialogueBar(Graphics g, Camera camera, String text){
		// Bar colors
		
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black,
     
        
        // Variables for layout
        float text_x, text_y;         // Coordinates to draw text
        float bar_x, bar_y;           // Coordinates to draw rectangles
        float bar_width, bar_height;  // Size of rectangle to draw
      
       
        // Display the player's health/name bar
        bar_width = Math.max(g.getFont().getWidth(text) + 6, 70);
	    bar_height = 20;
	    bar_x = (getXPos() - camera.getMinX()) - bar_width/2;
	    bar_y = (getYPos() - camera.getMinY()) - bar_height - 50;
	    text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
	    text_y = bar_y + (bar_height - g.getFont().getHeight(text)) / 2;
	    g.setColor(BAR_BG);
	    g.fillRect(bar_x, bar_y, bar_width, bar_height);
	    g.setColor(VALUE);
	    g.drawString(text, text_x, text_y);
	}
	
	/**
	 * interaction between villager and player
	 * @param player
	 * @param TisOn if T is pressed on keyboard
	 * @param g
	 * @param camera
	 */
	public abstract void interact(Player player, boolean TisOn,Graphics g, Camera camera);

}
