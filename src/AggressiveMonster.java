
public abstract class AggressiveMonster extends Monster {
	
	private final int MAX_DETECT_DIS = 150;
	private final int MIN_DETECT_DIS = 50;
	private final float SPEED = 0.25f;
	
	
	/**
	 * Aggressive monsters chase player when they detect him
	 * @param dx distance that monster move per frame in x direction
	 * @param dy distance that monster move per frame in x direction
	 * @param world the World object
	 */
	public void chasePlayer(float dx, float dy, World world){
		if (world.CheckBlock(dx, dx, this)){
			setXPos(getXPos() + dx);
			setYPos(getYPos() + dy);
		}
	}
	
	/**
	 * update monster and player after they had battle
	 * @param delta number of millisecond per frame
	 * @param AIsOn if A is pressed from keyboard
	 */
	public void update(Player player, int delta, boolean AIsOn, World world){
		float dist_total, dist_x, dist_y;
		
		// Algorithm 1
		dist_x = player.getXPos() - getXPos() ;
		dist_y = player.getYPos() - getYPos();
		dist_total = (float)Math.sqrt(Math.pow(dist_x,2) + Math.pow(dist_y,2));
		
		if (dist_total <= MAX_DETECT_DIS && dist_total >MIN_DETECT_DIS){
			
			if (isExist())
				chasePlayer(dist_x/dist_total * delta * SPEED, dist_y/dist_total * delta * SPEED, world);

		}
		// player and monster attack each other
		if (dist_total <= MIN_DETECT_DIS){
			if (AIsOn)
				player.attack(this, delta);
			if (isExist())
				this.attack(player, delta);
		}
		
	}

}
