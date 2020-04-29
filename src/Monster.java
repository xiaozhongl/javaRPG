
public abstract class Monster extends FightingUnit {
	
	/**
	 * update the monster's state
	 * @param player the player
	 * @param delta the number of millisecond per frame
	 * @param AIsOn if A is pressed on keyboard
	 * @param world the world
	 */
	public abstract void update(Player player, int delta, boolean AIsOn, World world);

}
