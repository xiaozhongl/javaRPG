/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Xiaozhong Liu> <xiaozhongl>
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{
	/** Width of a tile, in pixels. */
    public static final int TILE_SIZE = 72;
    /** Screen width, in tiles. */
    public static final int SCREEN_WIDTH_T = 13;
    /** Screen height, in tiles. */
    public static final int SCREEN_HEIGHT_T = 10;
    
    public static final int GIANT_BAT_NUM = 30;
    
    public static final int ZOMBIE_NUM = 38;
    
    public static final int BANDIT_NUM = 34;
    
    public static final int SKELETON_NUM = 24;
    
   
 
    
	private TiledMap map;
	private Player player;
	private Camera camera;
	private Item[] items;
	private Villager[] villagers;
	private Monster[] giantBats;
	private Monster[] zombies;
	private Monster[] bandits;
	private Monster[] skeletons;
	private Monster draelic;

	
    /** Create a new World object. */
    public World()
    throws SlickException
    {
    	map = new TiledMap("assets/map.tmx","assets/");
    	player = new Player();
    	camera = new Camera(player, RPG.SCREEN_WIDTH, RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT);
    	
    	items = new Item[4];
    	items[0] = new AmuletOfVitality();
		items[1] = new SwordOfStrength();
		items[2] = new TomeOfAgility();
		items[3] = new ElixirOfLife();
		
		villagers = new Villager[3];
		villagers[0] = new Elvira();
		villagers[1] = new Garth();
		villagers[2] = new PrinceAldric();
    	
    	giantBats = new Monster[GIANT_BAT_NUM];
    	for(int i=0; i< giantBats.length; i++)
    		giantBats[i] = new GiantBat(Data.GiantBat[i][0],Data.GiantBat[i][1]);
    	
    	zombies = new Monster[ZOMBIE_NUM];
    	for(int i=0; i< zombies.length; i++)
    		zombies[i] = new Zombie(Data.Zombie[i][0],Data.Zombie[i][1]);
    	
    	bandits = new Monster[BANDIT_NUM];
    	for(int i=0; i< bandits.length; i++)
    		bandits[i] = new Bandit(Data.Bandit[i][0],Data.Bandit[i][1]);
    	
    	skeletons = new Monster[SKELETON_NUM];
    	for(int i=0; i< skeletons.length; i++)
    		skeletons[i] = new Skeleton(Data.Skeleton[i][0],Data.Skeleton[i][1]);
    	
    	draelic = new Draelic();
    	
    	camera.update();
    }

    /** Update the game state for a frame.
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(int dir_x, int dir_y, int delta, boolean AIsOn, boolean TIsOn)
    throws SlickException
    {	
    	
    	player.turnFace(dir_x);
    	player.update(dir_x, dir_y, delta, this);	  	
  	  	
    		
    	for(int i=0; i< items.length; i++)
    		items[i].update(player);
    	
    	for(int i=0; i< giantBats.length; i++)
    		giantBats[i].update(player, delta, AIsOn, this);
    	
    	for(int i=0; i< zombies.length; i++)
    		zombies[i].update(player, delta, AIsOn, this);
    	
    	for(int i=0; i< bandits.length; i++)
    		bandits[i].update(player, delta, AIsOn, this);
    	
    	for(int i=0; i< skeletons.length; i++)
    		skeletons[i].update(player, delta, AIsOn, this);
    	
    	draelic.update(player, delta, AIsOn, this);
    	
    	camera.update();
    	
    	
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g, boolean TIsOn)
    throws SlickException
    {	
    	int sx = (int)(camera.getMinX()/TILE_SIZE);
    	int sy = (int)(camera.getMinY()/TILE_SIZE);
    	int x = (int)(sx * TILE_SIZE - camera.getMinX());
    	int y = (int)(sy * TILE_SIZE - camera.getMinY());;
    	
        map.render(x, y, sx, sy, SCREEN_WIDTH_T, SCREEN_HEIGHT_T);
        player.render(camera);
    
        renderPanel(g);
        
        for(int i=0; i< giantBats.length; i++){
        	giantBats[i].render(camera);
        	giantBats[i].renderHealthBar(g, camera);
        }
        
    	
    	for(int i=0; i< zombies.length; i++){
    		zombies[i].render(camera);
    		zombies[i].renderHealthBar(g, camera);
        }
    	for(int i=0; i< bandits.length; i++){
    		bandits[i].render(camera);
    		bandits[i].renderHealthBar(g, camera);
        }
    	for(int i=0; i< skeletons.length; i++){
    		skeletons[i].render(camera);
    		skeletons[i].renderHealthBar(g, camera);
        }
    	
    	for(int i=0; i< items.length; i++)
    		items[i].render(camera);
    	
    	for(int i=0; i< villagers.length; i++){
    		villagers[i].render(camera);
    		villagers[i].renderHealthBar(g, camera);
    		villagers[i].interact(player, TIsOn, g, camera);
    		
    	
    	}
    	
    	draelic.render(camera);
    	draelic.renderHealthBar(g, camera);
    }
    
    /**
     * check the accessibility of the tile that this unit is going to
     * @param dx distance the unit will move in this frame in x direction
     * @param dy distance the unit will move in this frame in x direction
     * @param unit the unit that can move
     * @return
     */
    public boolean CheckBlock (float dx, float dy, Unit unit) {
		
		float xPos = unit.getXPos() + dx;
  	  	float yPos = unit.getYPos() + dy;
  	  	int tileID = map.getTileId((int)(xPos / TILE_SIZE), (int)(yPos / TILE_SIZE), 0);
  	  	
  	  	return map.getTileProperty(tileID, "block", "0") == "0";
  	}
    
    /**
     * render the panel for status
     * @param g Graphics
     */
    public void renderPanel(Graphics g)
    {
        // Panel colours
        Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                // Text to display
        int text_x, text_y;         // Coordinates to draw text
        int bar_x, bar_y;           // Coordinates to draw rectangles
        int bar_width, bar_height;  // Size of rectangle to draw
        int hp_bar_width;           // Size of red (HP) rectangle
        int inv_x, inv_y;           // Coordinates to draw inventory item
        float health_percent;       // Player's health, as a percentage
        Integer hp, damage, cooldown,maxHp;
       
        int[] inventory;
        
        // Panel background image
        player.getPanel().draw(0, RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT);

        // Display the player's health
        text_x = 15;
        text_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT + 25;
        hp = player.getHp();
        maxHp = player.getMaxHp();
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = hp.toString() + "/" + maxHp.toString();                                

        bar_x = 90;
        bar_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = (float)player.getHp()/player.getMaxHp();                        
        hp_bar_width = (int) (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and cooldown
        text_x = 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        damage = player.getDamage();
        text = damage.toString();                                
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        cooldown = player.getCooldown();
        text = cooldown.toString();                                   
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's inventory
        g.setColor(LABEL);
        g.drawString("Items:", 420, text_y);
        bar_x = 490;
        bar_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = 490;
        inv_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT
            + ((RPG.PANEL_HEIGHT - 72) / 2);
        
        inventory = player.getInventory();
       
        for(int i=0; i < inventory.length;  i++){
        	if (inventory[i] != 0){
		        Image image;
		        image = items[inventory[i] - 1].getImage();
		        image.draw(inv_x,inv_y);
		        inv_x += 72;
	        }
        }
        
    }
    
}
    
