import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends AggressiveMonster {
	private final String IMAGE_PATH = "assets/units/zombie.png";
	private final int DEFAULT_HP = 60;
	private final int DEFAULT_DAMAGE = 10;
	private final int DEFAULT_COOLDOWN = 800;
	

	
	public Zombie(int xPos, int yPos) throws SlickException{
		
		setXPos(xPos);
		setYPos(yPos);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Zombie");
		
	}

}
