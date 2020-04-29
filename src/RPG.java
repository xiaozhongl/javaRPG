/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: Matt Giuca <mgiuca>
 */

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/** Main class for the Role-Playing Game engine.
 * Handles initialization, input and rendering.
 */
public class RPG extends BasicGame
{
    private World world;

    /** Screen width, in pixels. */
    public static final int SCREEN_WIDTH = 800;
    /** Screen height, in pixels. */
    public static final int SCREEN_HEIGHT = 600;
    public static final int PANEL_HEIGHT = 70;
  
   
    /** Create a new RPG object. */
    public RPG()
    {
        super("RPG Game Engine");
    }

    /** Initialize the game state.
     * @param gc The Slick game container object.
     */

    public void init(GameContainer gc)
    throws SlickException
    {
        world = new World();
    }

    /** Update the game state for a frame.
     * @param gc The Slick game container object.
     * @param delta Time passed since last frame (milliseconds).
     */

    public void update(GameContainer gc, int delta)
    throws SlickException
    {
        // Get data about the current input (keyboard state).
        Input input = gc.getInput();

        // Update the player's movement direction based on keyboard presses.
        int dir_x = 0;
        int dir_y = 0;
        boolean AIsOn = false;
        boolean TIsOn = false;
        
        
        if (input.isKeyDown(Input.KEY_DOWN))
            dir_y += 1;
        if (input.isKeyDown(Input.KEY_UP))
            dir_y -= 1;
        if (input.isKeyDown(Input.KEY_LEFT))
            dir_x -= 1;
        if (input.isKeyDown(Input.KEY_RIGHT))
            dir_x += 1;
        if (input.isKeyDown(Input.KEY_A))
        	AIsOn = true;
        if (input.isKeyDown(Input.KEY_T))
        	TIsOn = true;

        // Let World.update decide what to do with this data.
        world.update(dir_x, dir_y, delta, AIsOn, TIsOn);
    }

    /** Render the entire screen, so it reflects the current game state.
     * @param gc The Slick game container object.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(GameContainer gc, Graphics g)
    throws SlickException
    {
    	Input input = gc.getInput();
    	boolean TIsOn = false;
    	if (input.isKeyDown(Input.KEY_T))
        	TIsOn = true;
        // Let World.render handle the rendering.
        world.render(g, TIsOn);
       
    }

    /** Start-up method. Creates the game and runs it.
     * @param args Command-line arguments (ignored).
     */
    public static void main(String[] args)
    throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new RPG());
        // setShowFPS(true), to show frames-per-second.
        app.setShowFPS(false);
        app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
        app.start();
    }
}
