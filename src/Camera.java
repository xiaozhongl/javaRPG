/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Xiaozhong Liu> <xiaozhongl>
 */

import org.newdawn.slick.SlickException;

/** Represents the camera that controls our viewpoint.
 */
public class Camera
{

    /** The unit this camera is following */
    private Player unitFollow;
    
    /** The width and height of the screen */
    /** Screen width, in pixels. */
    public final int ScreenWidth;
    /** Screen height, in pixels. */
    public final int ScreenHeight;

    
    /** The camera's position in the world, in x and y coordinates. */
    private float xPos;
    private float yPos;

    
    public float getxPos() {
        return unitFollow.getXPos();
    }

    public float getyPos() {
    	return unitFollow.getYPos();
    }

    
    /** Create a new Camera object. */
    public Camera(Player player, int screenwidth, int screenheight)
    {   
        unitFollow = player;
        this.ScreenWidth = screenwidth;
        this.ScreenHeight = screenheight;
        
    }

    /** Update the game camera to recenter it's viewpoint around the player 
     */
    public void update()
    throws SlickException
    {
        xPos = getxPos();
        yPos = getyPos();
    }
    
    /** Returns the minimum x value on screen 
     */
    public float getMinX(){
    	return xPos - ScreenWidth/2;
    }
    
    /** Returns the maximum x value on screen 
     */
    public float getMaxX(){
        return xPos + ScreenWidth/2;
    }
    
    /** Returns the minimum y value on screen 
     */
    public float getMinY(){
    	return yPos - ScreenHeight/2;
    }
    
    /** Returns the maximum y value on screen 
     */
    public float getMaxY(){
    	return yPos + ScreenHeight/2;
    }

    /** Tells the camera to follow a given unit. 
     */
    public void followUnit(Object unit)
    throws SlickException
    {
        // TO DO: Fill In
    }
    
}