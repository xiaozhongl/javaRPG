
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PrinceAldric extends Villager {

	private final String IMAGE_PATH = "assets/units/prince.png";
	private final int DEFAULT_XPOS = 467;
	private final int DEFAULT_YPOS = 679;
	private final int DEFAULT_HP = 1;
	private final int DEFAULT_DAMAGE = 0;
	private final int DEFAULT_COOLDOWN = 0;
	public final int ELIXIR_ID = 4;
	
	// if the Elixir is founded
	private boolean elixirIsFounded = false;

	
	public PrinceAldric() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		setName("Prince Aldric");
		setDialogue("Please seek out the Elixir of Life to cure the king.");
		
	}
	
	/**
	 * Prince Aldric interact with player
	 */
	public void interact(Player player, boolean TisOn, Graphics g, Camera camera){
		String dialogue;
		if (this.checkInRange(player) && TisOn){
			if (elixirIsFounded == false){
				int[] inventory = player.getInventory();
				for (int i=0; i < inventory.length;  i++){
					if ( inventory[i] == ELIXIR_ID){
						inventory[i] = 0;
						player.setInventory(inventory);
						elixirIsFounded = true;
						dialogue = "The elixir! My father is cured! Thank you!";
						renderDialogueBar(g,camera, dialogue);
						break;
					
					}
					else{
						dialogue = "Please seek out the Elixir of Life to cure the king.";
						renderDialogueBar(g,camera, dialogue);
					}
				}
			}
			else{
				dialogue = "The elixir! My father is cured! Thank you!";
				renderDialogueBar(g,camera, dialogue);
			}
			
		}
	}

}
