import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

public class Speed{

	int count;
	private double x;
	private double y;
	private int bx;
	private int by;
	public int sx;
	public int sy;
	private boolean used;
	Point p = MouseInfo.getPointerInfo().getLocation();

	
	public Speed(int bx, int by) {
		this.bx = bx;
		this.by = by;
	}
	
	public void tick() {
	}
	
	public void render(Graphics gfx) {
		p = MouseInfo.getPointerInfo().getLocation();
		if(used) {
			gfx.drawLine(p.x, p.y, bx, by);
			sx = (bx - p.x);
			sy = (by - p.y);
			gfx.drawImage(Assets.speedpoint, (int) x-25, (int) y-25, null);
		}
	}
	
	public void used(boolean used) {
		this.used = used;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setBX(int bx) {
		this.bx = bx;
	}
	
	public int getSpeedX() {
		return sx;
	}
	
	public int getSpeedY() {
		return sy;
	}
	
	public void setBY(int by) {
		this.by = by;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void clear() {
		x = 0;
		y = 0;
		used = false;
	}
	
	public void status() {
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("USED: " + used);
	}
}
