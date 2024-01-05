package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Border extends Rectangle
{
	private static int GAME_WIDTH;
	private static int GAME_HEIGHT;
	
	public Border(int GAME_WIDTH, int GAME_HEIGHT)
	{
		Border.GAME_WIDTH = GAME_WIDTH;
		Border.GAME_HEIGHT = GAME_HEIGHT;
	}
	
	public void drawRoof(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT/9);
	}
	
	public void drawFloor(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(0, GAME_HEIGHT - 100, GAME_WIDTH, GAME_HEIGHT/9);
	}
}
