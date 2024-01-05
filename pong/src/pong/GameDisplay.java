package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GameDisplay extends JFrame
{
	private GameControl panel;
	
	public GameDisplay()
	{
		panel = new GameControl();
		this.add(panel);
		this.setTitle("Pong");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
