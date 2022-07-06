import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 50, height = 50;
	
	public static BufferedImage planet;
	public static BufferedImage meteorite;
	public static BufferedImage speedpoint;
	public static BufferedImage background = ImageLoader.loadImage("/textures/background.png");
	
	
		
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprites.png"));
		planet 	= sheet.crop(0*(width), 0*(height), width, height);
		meteorite 	= sheet.crop(1*(width), 0*(height), width, height);
		speedpoint = sheet.crop(2*(width), 0*(height), width, height);
	}
}
