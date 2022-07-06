import java.awt.Graphics;

public class GameState extends States {

	private Rule r;
	int h = 0;
	
	public GameState(Game game) {
		super(game);
		r = new Rule(game);
	}
	
	@Override
	public void tick() {
		if(h > 0) {
			h--;
		}
		if(h == 0) {
			r.tick();
			h = 1;
		}
		
		
	}
	
	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(Assets.background, 0, 0, null);
		r.render(gfx);
	}
}
