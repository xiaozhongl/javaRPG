
public abstract class PassiveMonster extends Monster {
	
	private final int WONDER_COOLDOWN = 3000;
	private final int OFF_BATTLE_COOLDOWN = 5000;
	private final float SPEED = 0.1f;
	
	private int inBattleTimer = 0;
	private int wonderTimer = 0;
	
	
	
	public void setInBattle(){
		inBattleTimer = OFF_BATTLE_COOLDOWN;
	}
	
	
	/**
	 * the passive wonder around
	 * @param delta delta the number of millisecond per frame
	 * @param world
	 */
	public void wander(int delta, World world){
		float dir, dx, dy;
		if (wonderTimer <= 0){
			setDir_x((int)(Math.random()* 3) - 1);
			setDir_y((int)(Math.random()* 3) - 1);
			wonderTimer = WONDER_COOLDOWN;
		}
		else{
			wonderTimer -= delta;
		}
		
		dir = (float)Math.sqrt(Math.pow(getDir_x(),2) + Math.pow(getDir_y(),2));
		if (dir != 0){
			dx = getDir_x()/dir * delta * SPEED;
			dy = getDir_y()/dir * delta * SPEED;
		}
		else{
			dx = 0;
			dy = 0;
		}
		if (world.CheckBlock(dx, dx, this)){
			setXPos(getXPos() + dx);
			setYPos(getYPos() + dy);
		}
	}
	
	/**
	 * update the passive monster's position
	 */
	public void update(Player player, int delta, boolean AIsOn, World world){
		if (this.checkInRange(player) && AIsOn){
			player.attack(this, delta);
    		setInBattle();
    	}
    	if (inBattleTimer >= 0){
			escapeFromPlayer(player, delta, world);
			inBattleTimer -= delta;

		}
		else{
			wander(delta, world);
		}
	}
	
	
	/**
	 * passive try to escape from the player when it is attacked
	 * @param player the player
	 * @param delta the number of millisecond per frame
	 * @param world the world
	 */
	public void escapeFromPlayer(Player player, int delta, World world){
		float dist_total, dist_x, dist_y, dx, dy;
		
		dist_x = getXPos() - player.getXPos();
		dist_y = getYPos() - player.getYPos();
		dist_total = (float)Math.sqrt(Math.pow(dist_x,2) + Math.pow(dist_y,2));
		dx = dist_x/dist_total * delta * SPEED;
		dy = dist_y/dist_total * delta * SPEED;
		if (world.CheckBlock(dx, dx, this)){
			setXPos(getXPos() + dx);
			setYPos(getYPos() + dy);
		}
	}

}
