
public abstract class FightingUnit extends Unit {
	
	private int cooldownTimer = 0;
	private int dir_x;
	private int dir_y;
	private float speed;
	
	
	
	public int getDir_x() {
		return dir_x;
	}

	public void setDir_x(int dir_x) {
		this.dir_x = dir_x;
	}

	public int getDir_y() {
		return dir_y;
	}

	public void setDir_y(int dir_y) {
		this.dir_y = dir_y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getCooldownTimer() {
		return cooldownTimer;
	}

	public void setCooldownTimer(int cooldownTimer) {
		this.cooldownTimer = cooldownTimer;
	}
	
	/**
	 * make unit turn around if it changes direction
	 * @param dir_x the x direction of movement in this frame
	 */
	public void turnFace(int dir_x) {
		
		if (this.dir_x * dir_x < 0){
			setImage(getImage().getFlippedCopy(true, false));
			this.dir_x = dir_x;
		}
	}
	
	
	/**
	 * to let this object attack another
	 * @param target the object which is attacked
	 * @param delta the number of millisecond per frame
	 */
	public void attack(Unit target, int delta){
		
		if (cooldownTimer <= 0){
			target.setHp(target.getHp() - (int)(Math.random()*getDamage()));
			target.checkDeath();
			cooldownTimer = getCooldown();
		}
		else{
			cooldownTimer -= delta;
		}
	}
	
	
	
}
