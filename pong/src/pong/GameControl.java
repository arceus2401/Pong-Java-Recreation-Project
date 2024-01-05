package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameControl extends JPanel implements Runnable
{
	private static final int GAME_WIDTH = 1200;
	private static final int GAME_HEIGHT = 900;
	private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	private static final int BALL_DIAMETER = 20;
	private static final int PADDLE_WIDTH = 25;
	private static final int PADDLE_HEIGHT = 100;
	private static final int TILE_WIDTH = 30;
	private static final int TILE_HEIGHT = 40;
	private Thread gameThread;
	private Image image;
	private Graphics graphics;
	private Random randomNumber;
	private Paddle paddle1;
	private Paddle paddle2;
	private Ball ball;
	private ScoreBoard score;
	private Border roof;
	private Border floor;
	private CenterLine lineOne;
	
	public GameControl()
	{
		newPaddles();
		newBall();
		score = new ScoreBoard(GAME_WIDTH, GAME_HEIGHT);
		roof = new Border(GAME_WIDTH, GAME_HEIGHT);
		floor = new Border(GAME_WIDTH, GAME_HEIGHT);
		lineOne = new CenterLine(GAME_WIDTH/2, (GAME_HEIGHT/2) - (TILE_HEIGHT/2), TILE_WIDTH, TILE_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall()
	{
		randomNumber = new Random();
		ball = new Ball(((GAME_WIDTH/2) - (BALL_DIAMETER/2)), (randomNumber.nextInt((GAME_HEIGHT/9) - BALL_DIAMETER, GAME_HEIGHT - GAME_HEIGHT/9)), BALL_DIAMETER, BALL_DIAMETER);
	}
	
	public void newPaddles()
	{
		paddle1 = new Paddle(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle((GAME_WIDTH - PADDLE_WIDTH), (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	public void paint(Graphics g)
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g)
	{
		lineOne.draw(g);
		roof.drawRoof(g);
		floor.drawFloor(g);
		paddle1.draw(g);
		paddle2.draw(g);
		
		ball.draw(g);
		
		score.draw(g);
		
	}
	
	public void move()
	{
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision()
	{
		
	//stops ball at roof and floor
		
		if(ball.y <= GAME_HEIGHT/9)
		{
			ball.setYVelocity(-ball.getYVelocity());
		}
		
		if(ball.y >= ((GAME_HEIGHT-(GAME_HEIGHT/9) - BALL_DIAMETER)))
		{
			ball.setYVelocity(-ball.getYVelocity());
		}
		
	//reflects ball off paddles
		if(ball.intersects(paddle1))
		{
			ball.setXVelocity(Math.abs(ball.getXVelocity()));
			ball.setXVelocity(ball.getXVelocity() + 1); //speeds up ball when reflected
			
			if(ball.getYVelocity() > 0)
			{
				ball.setYVelocity(ball.getYVelocity() + 1);
			}
			else
			{
				ball.setYVelocity(ball.getYVelocity() - 1);
			}
			ball.setXVelocity(ball.getXVelocity());
			ball.setYVelocity(ball.getYVelocity());
		}
		
		if(ball.intersects(paddle2))
		{
			ball.setXVelocity(Math.abs(ball.getXVelocity()));
			ball.setXVelocity(ball.getXVelocity() + 1); //speeds up ball when reflected
			
			if(ball.getYVelocity() > 0)
			{
				ball.setYVelocity(ball.getYVelocity() + 1);
			}
			else
			{
				ball.setYVelocity(ball.getYVelocity() - 1);
			}
			ball.setXVelocity(-ball.getXVelocity());
			ball.setYVelocity(ball.getYVelocity());
		}
		
	//paddles
		if(paddle1.y <= GAME_HEIGHT/9)
		{
			paddle1.y = GAME_HEIGHT/9;
		}
		
		if(paddle1.y >= ((GAME_HEIGHT-GAME_HEIGHT/9) - PADDLE_HEIGHT))
		{
			paddle1.y = ((GAME_HEIGHT-GAME_HEIGHT/9) - PADDLE_HEIGHT);
		}
		
		if(paddle2.y <= GAME_HEIGHT/9)
		{
			paddle2.y = GAME_HEIGHT/9;
		}
		
		if(paddle2.y >= ((GAME_HEIGHT-GAME_HEIGHT/9) - PADDLE_HEIGHT))
		{
			paddle2.y = ((GAME_HEIGHT-GAME_HEIGHT/9) - PADDLE_HEIGHT);
		}
		
	//gives a point to a player
		if(ball.x <= 0)
		{
			score.updateScore(2);
			newBall();
			System.out.println("Player 2: " + score.getTeamScore2() + " points");
		}
		if(ball.x >= (GAME_WIDTH - BALL_DIAMETER))
		{
			score.updateScore(1);
			newBall();
			System.out.println("Player 1: " + score.getTeamScore1() + " points");
		}

	}
	
	public void run()
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) 
			{
				move();
				checkCollision();
				repaint();
				delta--;
				//System.out.println("TEST");
			}
		}
	}
	
	public class AL extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) 
		{
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
