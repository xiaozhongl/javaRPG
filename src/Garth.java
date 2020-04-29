

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Garth extends Villager {
	private final String IMAGE_PATH = "assets/units/peasant.png";
	private final int DEFAULT_XPOS = 756;
	private final int DEFAULT_YPOS = 870;
	private final int DEFAULT_HP = 1;
	private final int DEFAULT_DAMAGE = 0;
	private final int DEFAULT_COOLDOWN = 0;

	
	public Garth() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Garth");
		
	}
		
	public void interact(Player player, boolean TisOn,Graphics g, Camera camera){
		
	}
	

}
