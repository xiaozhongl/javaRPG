import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TomeOfAgility extends Item {
	private final String IMAGE_PATH = "assets/items/tome.png";
	private final int DEFAULT_XPOS = 4791;
	private final int DEFAULT_YPOS = 1253;
	private final int DEFAULT_ID = 3;
	private final int EFFECT = -300;

	
	public TomeOfAgility() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setId(DEFAULT_ID);
	}
	
	/**
	 * Tome of Agility get picked and strengthen player.
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
			player.setCooldown(player.getCooldown() + EFFECT);
		}
		
		setExist(false);
	}
}
