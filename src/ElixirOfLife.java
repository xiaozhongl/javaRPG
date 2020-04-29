import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ElixirOfLife extends Item {
	private final String IMAGE_PATH = "assets/items/elixir.png";
	private final int DEFAULT_XPOS = 1976;
	private final int DEFAULT_YPOS = 402;
	public final int DEFAULT_ID = 4;
	
	public ElixirOfLife() throws SlickException{
		
		setXPos(DEFAULT_XPOS);
		setYPos(DEFAULT_YPOS);
		setImage(new Image(IMAGE_PATH));
		setId(DEFAULT_ID);
		
	}

}
