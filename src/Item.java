
public abstract class Item extends Entity {
	
	
	private int id;
	

	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * the item is picked by player
	 * @param player
	 */
	public void getPicked(Player player){
		if (isExist()){
			int[] inventory = player.getInventory();
			for(int i=0; i < inventory.length;  i++){
				if (inventory[i] == 0){
					inventory[i] = id;
					setExist(false);
					break;
				}
			}
		}
	}
	
	/**
	 * update the existence of the item in the world
	 * @param player the player
	 */
	public void update(Player player){
		if (this.checkInRange(player))
				this.getPicked(player); 
			
		}
	
}
