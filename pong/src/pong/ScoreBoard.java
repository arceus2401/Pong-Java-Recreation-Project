package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ScoreBoard extends Rectangle
{
	private static int GAME_WIDTH;
	private static int GAME_HEIGHT;
	private int teamScore1;
	private int teamScore2;
	
	static final int TILE_WIDTH = 25;
	static final int TILE_HEIGHT = 50;
	
	public ScoreBoard(int GAME_WIDTH, int GAME_HEIGHT)
	{
		ScoreBoard.GAME_WIDTH = GAME_WIDTH;
		ScoreBoard.GAME_HEIGHT = GAME_HEIGHT;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.setFont(new Font("Rubik", Font.PLAIN, 60));
		
		g.drawString((String.valueOf(teamScore1 / 10) + String.valueOf(teamScore1 % 10)), (GAME_WIDTH/2 - 85), 50);
		g.drawString((String.valueOf(teamScore2 / 10) + String.valueOf(teamScore2 % 10)), (GAME_WIDTH/2 + 20), 50);
	}
	
	public void updateScore(int team1Or2)
	{
		if (team1Or2 == 1)
		{
			teamScore1++;
		}
		else if (team1Or2 == 2)
		{
			teamScore2++;
		}
	}
	
	public int getTeamScore1()
	{
		return teamScore1;
	}
	
	public void setTeamScore1(int newTeamScore1)
	{
		teamScore1 = newTeamScore1;
	}
	
	public int getTeamScore2()
	{
		return teamScore2;
	}
	
	public void setTeamScore2(int newTeamScore2)
	{
		teamScore2 = newTeamScore2;
	}
}
