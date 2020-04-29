import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Draelic extends AggressiveMonster {
	private final String IMAGE_PATH = "assets/units/necromancer.png";
	private final int DEFAULT_XPOS = 2069;
	private final int DEFAULT_YPOS = 510;
	private final int DEFAULT_HP = 140;
	private final int DEFAULT_DAMAGE = 30;
	private final int DEFAULT_COOLDOWN = 400;

	
	public Draelic() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Draelic");
		
	}

}
