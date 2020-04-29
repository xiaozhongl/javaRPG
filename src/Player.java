import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;


public class Player extends FightingUnit {
	
	private final float SPEED = 0.25f;
	private final String IMAGE_PATH = "assets/units/player.png";
	private final String PANEL_PATH = "assets/panel.png";
	private final int INIT_DIR = 1;
	private final int INIT_XPOS = 756;
	private final int INIT_YPOS = 684;
	private final int DEFAULT_HP = 100;
	private final int DEFAULT_DAMAGE = 26;
	private final int DEFAULT_COOLDOWN = 600;
	private final int DEFAULT_INVENTORY_SIZE = 4;
	private final int REBIRTH_XPOS = 738;
	private final int REBIRTH_YPOS = 549;
	
	private Image panel;
	private int inventory[];
	
	
	public Player() throws SlickException{
		
		setXPos(INIT_XPOS);
		setYPos(INIT_YPOS);
		setDir_x(INIT_DIR);
		setSpeed(SPEED);
		setImage(new Image(IMAGE_PATH));
		setHp(DEFAULT_HP);
		setMaxHp(DEFAULT_HP);
		setDamage(DEFAULT_DAMAGE);
		setCooldown(DEFAULT_COOLDOWN);
		panel = new Image(PANEL_PATH);
		inventory = new int[DEFAULT_INVENTORY_SIZE];
	}
	
	public int[] getInventory() {
		return inventory;
	}

	public void setInventory(int[] inventory) {
		this.inventory = inventory;
	}

	public int getDEFAULT_INVENTORY_SIZE() {
		return DEFAULT_INVENTORY_SIZE;
	}

	public Image getPanel() {
		return panel;
	}

	public void setPanel(Image panel) {
		this.panel = panel;
	}

	/**
	 * update player's position
	 * @param dir_x the new direction of motion in x direction
	 * @param dir_y the new direction of motion in x direction
	 * @param delta the number of millisecond per frame
	 * @throws SlickException 
	 */
	public void update(int dir_x, int dir_y, int delta, World world) throws SlickException {
		
		if (isExist()){
			if (world.CheckBlock(dir_x, dir_y, this)){
				setXPos(getXPos() + dir_x * (0.5f + delta * SPEED));
				setYPos(getYPos() + dir_y * (0.5f + delta * SPEED));
			}
		}
		// player get rebirth after dead
		else{
			setXPos(REBIRTH_XPOS);
			setYPos(REBIRTH_YPOS);
			setDir_x(INIT_DIR);
			setHp(getMaxHp());
			setImage(new Image(IMAGE_PATH));
			setExist(true);
		}
	}
	
	
	/**
	 * render player's image
	 */
	@Override
	public void render(Camera camera){
		
		getImage().drawCentered(camera.ScreenWidth/2, camera.ScreenHeight/2);
	}

	
}
