import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AmuletOfVitality extends Item {
	private final String IMAGE_PATH = "assets/items/amulet.png";
	private final int DEFAULT_XPOS = 965;
	private final int DEFAULT_YPOS = 3563;
	private final int DEFAULT_ID = 1;
	private final int EFFECT = 80;
	

	
	public AmuletOfVitality() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setId(DEFAULT_ID);
	}
	
	/**
	 * Amulet of Vitality get picked and strengthen the player
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
			player.setHp(player.getHp() + EFFECT);
			player.setMaxHp(player.getMaxHp() + EFFECT);
		}
		setExist(false);
	}
}
