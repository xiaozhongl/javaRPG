
import org.newdawn.slick.Image;



public abstract class Entity {
	
	private final int INTERACTION_DISTANCE = 50;
	
	private float xPos;
	private float yPos;
	private Image image;
	private boolean isExist = true;
	
	public float getXPos() {
		return xPos;
	}

	public void setXPos(float xPos) {
		this.xPos = xPos;
	}

	public float getYPos() {
		return yPos;
	}
	
	public void setYPos(float yPos) {
		this.yPos = yPos;
	}

	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	
	/**
	 * Render the image of this object in the camera
	 * @param camera
	 */
	public void render(Camera camera){
		if (checkInCamera (camera) && isExist()){
			float xRender = xPos - camera.getMinX();
			float yRender = yPos - camera.getMinY();
			
			image.drawCentered(xRender, yRender);
		}
	}
	
	
	
	/**
	 * check if this object is in camera
	 * @param camera the camera
	 * @return the object is in the camera
	 */
	public boolean checkInCamera(Camera camera){
		return (xPos >= camera.getMinX()) && (xPos <= camera.getMaxX()) && 
				(yPos >= camera.getMinY()) && (yPos <= camera.getMaxY());
	}
	
	
	
	/**
	 * check if this object is within 50 pixel with player
	 * @param player the player
	 * @return this object is within 50 pixel with player
	 */
	public boolean checkInRange(Player player){
		
		double distance, dx, dy;
		
		dx = xPos - player.getXPos();
		dy = yPos - player.getYPos();
		distance = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
		return distance <= INTERACTION_DISTANCE;
	}
	

}
