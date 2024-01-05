package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class CenterLine extends Rectangle
{
	public CenterLine(int x, int y, int TILE_WIDTH, int TILE_HEIGHT)
	{
		super(x, y, TILE_WIDTH, TILE_HEIGHT);
	}
	
	public void draw(Graphics gOne)
	{
		gOne.setColor(Color.cyan);
		gOne.fillRect(x, (y - 320), width, height);
		gOne.fillRect(x, (y - 240), width, height);
		gOne.fillRect(x, (y - 160), width, height);
		gOne.fillRect(x, (y - 80), width, height);
		gOne.fillRect(x, y, width, height);
		gOne.fillRect(x, (y + 320), width, height);
		gOne.fillRect(x, (y + 240), width, height);
		gOne.fillRect(x, (y + 160), width, height);
		gOne.fillRect(x, (y + 80), width, height);
	}
}
