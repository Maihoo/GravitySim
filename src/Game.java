import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
	
	private double h = 0;
	
	private Display display;
	public int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics gfx;
	
	//States
	private States gameState;
	private States menuState;
	
	//Input
	private KeyManager keyManager;
	private BufferedImage background;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		menuState = new MenuState(this);
		gameState = new GameState(this);
		States.setState(gameState);
		
		background = ImageLoader.loadImage("/textures/background.png");
	}
	
	
	private void tickK() {
		keyManager.tick();
	}
	
	private void tickR() {
		if(States.getState() != null) {
			States.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		gfx = bs.getDrawGraphics();
		gfx.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(States.getState() != null) {
			States.getState().render(gfx);
		}

		//End Drawing
		bs.show();
		gfx.dispose();
	}
	
	public void run() {
		
		init();

		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			timePerTick = 1000000000/fps;
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				if(h == 5) {
					tickK();
					h = 0;
				}
			h++;
			tickR();
			render();
			ticks++;
			delta--;
			}
			
			if(timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public void setKM() {
		keyManager.reset();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}