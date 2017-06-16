package mySnake;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Snake {
	LinkedList<Point> body = new LinkedList<>();
	private Point point;
	private int direction;
	public final int UP = 0;
	public final int DOWN = 1;
	public final int LEFT = 2;
	public final int RIGHT = 3;
	private Point tail;
	public Point head;

	public Snake() {
		direction = RIGHT;
		point = new Point((int)(Math.random() * 10) * 10 + 20, (int)(Math.random() * 10) * 10 + 20);
		body.add(point);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void ToLeft() {
		direction = LEFT;
		head = body.getFirst();
		point = new Point(head.getX() - 10, head.getY());
		move(point);
	}

	public void ToRight() {
		direction = RIGHT;
		head = body.getFirst();
		point = new Point(head.getX() + 10, head.getY());
		move(point);
	}

	public void ToUp() {
		direction = UP;
		head = body.getFirst();
		point = new Point(head.getX(), head.getY() - 10);
		move(point);
	}

	public void ToDown() {
		direction = DOWN;
		head = body.getFirst();
		point = new Point(head.getX(), head.getY() + 10);
		move(point);
	}

	public void move(Point point) {
		for (Point p : body) {
			if (p.getX() == point.getX() && p.getY() == point.getY()) {
				JOptionPane.showMessageDialog(null, "game over! score: " + body.size(), "you eat yourself", JOptionPane.ERROR_MESSAGE);
				direction = -1;
			}
		}
		// why not use body.getFirst().getX()?
		// because point is the position that head will move next, so check point's position is enough
		if (point.getX() < 15 || point.getX() > 465) {
			JOptionPane.showMessageDialog(null, "game over! score: " + body.size(), "you touch the wall", JOptionPane.ERROR_MESSAGE);
			direction = -1;
		}
		if (point.getY() < 15 || point.getY() > 465) {
			JOptionPane.showMessageDialog(null, "game over! score: " + body.size(), "you touch the wall", JOptionPane.ERROR_MESSAGE);
			direction = -1;
		}
		else {
			body.addFirst(point);
			tail = body.removeLast();
		}
	}

	public Point getTail() {
		return tail;
	}
}

