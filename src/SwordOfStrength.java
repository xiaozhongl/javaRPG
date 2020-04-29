import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SwordOfStrength extends Item {
	private final String IMAGE_PATH = "assets/items/sword.png";
	private final int DEFAULT_XPOS = 546;
	private final int DEFAULT_YPOS = 6707;
	private final int DEFAULT_ID = 2;
	private final int EFFECT = 30;

	
	public SwordOfStrength() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setId(DEFAULT_ID);
		
	}
	
	/**
	 * Sword of Strength get picked and strengthen player.
	 */
	@Override
	public void getPicked(Player player){
		
		if (isExist()){
			int[] inventory = player.getInventory();
			for(int i=0; i < inventory.length;  i++){
				if (inventory[i] == 0){
					inventory[i] = DEFAULT_ID;
					break;
				}
			}
			player.setDamage(player.getDamage() + EFFECT);
		}
		setExist(false);
	}
}
