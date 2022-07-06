import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

public class Rule {
	
	public Meteorite[] meteorite = new Meteorite[1000];
	public Planet[] planet = new Planet[1000];
	public Speed speed = new Speed(0, 0);
	
	Game game;
	boolean render = false;
	int i = -1;
	int j = -1;
	int o;
	Point p = MouseInfo.getPointerInfo().getLocation();
	Point b = MouseInfo.getPointerInfo().getLocation();
	
	public Rule (Game game) {
		this.game = game;
	}
	
	public void tick() {
		b = MouseInfo.getPointerInfo().getLocation();
		
		if(i == -1) {
			bodiesSet();	
			j++;
			i++;
			}
		
		if(game.getKeyManager().up) {
			p = MouseInfo.getPointerInfo().getLocation();
			j++;
			planet[j].setX(p.x);
			planet[j].setY(p.y);
			planet[j].setNr(j);
			planet[j].rend(true);
			for(int h = 1; h < 1000; h++) {
				meteorite[h].setPoint(j, p.x, p.y);
			}
			game.setKM();
		}
		
		if(game.getKeyManager().down) {
			p = MouseInfo.getPointerInfo().getLocation();
			i++;
			meteorite[i].setX(p.x);
			meteorite[i].setY(p.y);
			meteorite[i].setvX(0);
			meteorite[i].setvY(0);
			if(speed.getX() != 0 && speed.getY() != 0) {
				meteorite[i].setvX(speed.getSpeedX()/50);
				meteorite[i].setvY(speed.getSpeedY()/50);
			}
			meteorite[i].setN(i);
			meteorite[i].rend(true);
			game.setKM();
			speed.clear();
		}
		
		if(game.getKeyManager().right) {
			p = MouseInfo.getPointerInfo().getLocation();
			speed.setBX(p.x);
			speed.setBY(p.y);
			speed.setX(p.x);
			speed.setY(p.y);
			speed.used(true);
			game.setKM();
		}
		
		for(int w = 1; w < 1000; w++) {
			meteorite[w].tick();
			planet[w].tick();
			speed.tick();
		}
	}
	
	public void render(Graphics gfx) {	
		for(int w = 1; w < 1000; w++) {
			meteorite[w].render(gfx);
			planet[w].render(gfx);
			speed.render(gfx);
		}
	}
	
	
	public void bodiesSet() {
		for(int u = 1; u < 1000; u++) {
			meteorite[u] = new Meteorite();
			planet[u] = new Planet();
			meteorite[u].pointSet();
		}
	}
	
}
