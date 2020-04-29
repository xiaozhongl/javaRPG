import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GiantBat extends PassiveMonster {
	private final String IMAGE_PATH = "assets/units/dreadbat.png";
	private final int DEFAULT_HP = 40;
	private final int DEFAULT_DAMAGE = 8;
	private final int DEFAULT_COOLDOWN = 200;
	

	
	public GiantBat(int xPos, int yPos) throws SlickException{
		
		setXPos(xPos);
		setYPos(yPos);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Giant Bat");
		
		
	}

	

}
