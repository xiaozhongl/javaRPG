import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skeleton extends AggressiveMonster {
	private final String IMAGE_PATH = "assets/units/skeleton.png";
	private final int DEFAULT_HP = 100;
	private final int DEFAULT_DAMAGE = 16;
	private final int DEFAULT_COOLDOWN = 500;
	

	public Skeleton(int xPos, int yPos) throws SlickException{
		
		setXPos(xPos);
		setYPos(yPos);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Skeleton");
		
	}

}
