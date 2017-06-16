package mySnake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel{
//	private Snake snake;
//	private Food food;
	protected void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.WHITE);
		g.fillRect(15, 15, 450, 450);
		for (Point p : Global.snake.body) {
			g.setColor(Color.BLACK);
			g.fillRect(p.getX() - 5, p.getY() - 5, 10, 10);
		}
		g.setColor(Color.BLUE);
		g.fillRect(Global.food.getX() - 5, Global.food.getY() - 5, 10, 10);
		g.setColor(Color.GRAY);
		g.setColor(Color.RED);
		g.fillRect(Global.snake.body.getFirst().getX() - 5, Global.snake.body.getFirst().getY() - 5, 10, 10);
	}
}
