package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Ball extends Rectangle
{
	private Random randomNumber;
	private int xVelocity;
	private int yVelocity;
	private int initialSpeed = 2;
	
	public Ball(int xPosition, int yPosition, int width, int height)
	{
		super(xPosition, yPosition, width, height);
		
		randomNumber = new Random();
		
		int randomXDirection = randomNumber.nextInt(2);
		
		if(randomXDirection == 0)
		{
			randomXDirection--;
		}
		setXVelocity(randomXDirection * initialSpeed);
		
		int randomYDirection = randomNumber.nextInt(2);
		if(randomYDirection == 0)
		{
			randomYDirection--;
		}
		setYVelocity(randomYDirection * initialSpeed);
	}
	
	public int getXVelocity()
	{
		return xVelocity;
	}
	
	public void setXVelocity(int newXVelocity)
	{
		xVelocity = newXVelocity;
	}
	
	public int getYVelocity()
	{
		return yVelocity;
	}
	
	public void setYVelocity(int newYVelocity)
	{
		yVelocity = newYVelocity;
	}
	
	public void move()
	{
		x += xVelocity;
		y += yVelocity;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, height, width);
	}
}
