

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Elvira extends Villager {
	private final String IMAGE_PATH = "assets/units/shaman.png";
	private final int DEFAULT_XPOS = 738;
	private final int DEFAULT_YPOS = 549;
	private final int DEFAULT_HP = 1;
	private final int DEFAULT_DAMAGE = 0;
	private final int DEFAULT_COOLDOWN = 0;

	
	public Elvira() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Elvira");
	}
	
	
	/**
	 * Elvira interact with the player
	 */
	public void interact(Player player, boolean TisOn,Graphics g, Camera camera){
		String dialogue;
		if (this.checkInRange(player) && TisOn){
			if (player.getHp() < player.getMaxHp()){
				dialogue = "You're looking much healthier now.";
				renderDialogueBar(g, camera, dialogue);
				player.setHp(player.getMaxHp());

				
			}
			else {
				dialogue = "Return to me if you ever need healing.";
				renderDialogueBar(g, camera, dialogue);
			}
		}
	}

}
