import java.awt.Graphics;
import java.awt.Point;

public class Meteorite{

	private int N;
	static int mass;
	private double x;
	private double y;
	double vX = 0;
	double vY = 0;
	
	private boolean render;
	private Point[] points = new Point[1000];
	
	public void setPoint(int i, int plX, int plY) {
		points[i].setLocation(plX, plY);
	}
	
	public void tick() {
		double F = 0;
		double r = 0;
		double distX = 0;
		double distY = 0;
		
		if(points[1].getX() == 0) {
			x += vX;
			y += vY;
		}

		for(int i = 1; i < 1000; i++) {
			if(points[i].getX() != 0) {
				mass = 10;
				distX = 0;
				distY = 0;
				r = 0;
				F = 0;
				
				distX = -(points[i].getX() - x)/10;
				distY = -(points[i].getY() - y)/10;
					
				r = Math.sqrt((distX)*(distX) + (distY)*(distY));	
				
				F = ((1000)/(r*r));
				
				vX += F*-(distX/r)/100;
				vY += F*-(distY/r)/100;
				
				x += vX;
				y += vY;
			}
		}
	}
	
	
	public void render(Graphics gfx) {		
		if(render) {	
			gfx.drawImage(Assets.meteorite, (int) x-25, (int) y-25, null);
		}
	}
	
	public void rend(boolean render) {
		this.render = render;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setvX(double vX) {
		this.vX = vX;
	}
	
	public void setvY(double vY) {
		this.vY = vY;
	}
	
	public void setN(int N) {
		this.N = N;
	}
	
	public void pointSet(){
		for(int i = 0; i < 1000; i++) {
			points[i] = new Point(0, 0);
		}
	}
	
	public void status() {
		System.out.println("N: " + N);
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("vX: " + vX);
		System.out.println("vY: " + vY);
		System.out.println("Render: " + render);
	}
}
