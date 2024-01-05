package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Paddle extends Rectangle
{
	private int playerNumber;
	private int yVelocity;
	private int speed = 10;
	
	
	public Paddle(int xPosition, int yPosition, int PADDLE_WIDTH, int PADDLE_HEIGHT, int playerNumber)
	{
		super(xPosition, yPosition, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.playerNumber = playerNumber;
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(playerNumber) 
		{
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W)
			{
				setYDirection(-speed);
				move();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_S)
			{
				setYDirection(speed);
				move();
			}
		
		break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				setYDirection(-speed);
				move();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				setYDirection(speed);
				move();
			}
		break;
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		switch(playerNumber) 
		{
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W)
			{
				setYDirection(0);
				move();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_S)
			{
				setYDirection(0);
				move();
			}
		
		break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				setYDirection(0);
				move();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				setYDirection(0);
				move();
			}
		break;
		}
	}
	
	public void setYDirection(int yDirection)
	{
		yVelocity = yDirection;
	}
	
	public void move()
	{
		y = y + yVelocity;
	}
	
	public void draw(Graphics g)
	{
		if(playerNumber == 1) 
		{
			g.setColor(Color.green);
		}
		else
		{
			g.setColor(Color.magenta);
		}
		
		g.fillRect(x, y, width, height);
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	
	public void setPlayerNumber(int newPlayerNumber)
	{
		playerNumber = newPlayerNumber;
	}
	
	
}
