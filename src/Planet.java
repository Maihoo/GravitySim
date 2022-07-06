import java.awt.Graphics;

public class Planet{

	private double x;
	private double y;
	private int N;
	static int mass;
	private boolean render;
	
	public void tick() {
	}
	
	public void render(Graphics gfx) {	
		if(render) {	
			gfx.drawImage(Assets.planet, (int) x-25, (int) y-25, null);
		}
	}
	
	public void rend(boolean render) {
		this.render = render;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setNr(int N) {
		this.N = N;
	}
	
	public void status() {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("N: " + N);
		System.out.println("Render: " + render);
	}
}
