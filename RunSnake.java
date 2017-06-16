package mySnake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class RunSnake implements KeyListener{
	private boolean action = true;
	private JFrame frame;
//	private Snake snake;
	private MyPanel myPanel;
//	private Food food;
	public void PaintGUI() {
		frame = new JFrame("Snake");
		myPanel = new MyPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(myPanel);
		frame.setVisible(true);
		frame.setSize(485, 515);
		frame.setResizable(false);
		frame.addKeyListener(this);
		Global.food = new Food();
		while (action && Global.snake.getDirection() != -1) {
			try {
				Thread.sleep(300);
				switch (Global.snake.getDirection()) {
					case 0:
						Global.snake.ToUp();
						break;
					case 1:
						Global.snake.ToDown();
						break;
					case 2:
						Global.snake.ToLeft();
						break;
					case 3:
						Global.snake.ToRight();
						break;
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Global.snake.body.getFirst().getX() == Global.food.getX() && Global.snake.body.getFirst().getY() == Global.food.getY()) {
				Global.snake.body.addLast(Global.snake.getTail());
				Global.food = new Food();
			}
			myPanel.repaint();
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (Global.snake.getDirection() == Global.snake.UP) {
				return;
			}
			Global.snake.setDirection(Global.snake.DOWN);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (Global.snake.getDirection() == Global.snake.DOWN) {
				return;
			}
			Global.snake.setDirection(Global.snake.UP);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (Global.snake.getDirection() == Global.snake.RIGHT) {
				return;
			}
			Global.snake.setDirection(Global.snake.LEFT);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (Global.snake.getDirection() == Global.snake.LEFT) {
				return;
			}
			Global.snake.setDirection(Global.snake.RIGHT);
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
