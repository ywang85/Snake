package mySnake;

public class Food extends Point{
	public Food() {
		Point p = new Point((int)(Math.random() * 45) * 10 + 20, (int)(Math.random() * 45) * 10 + 20);
		while (check(p)) {
			p = new Point((int)(Math.random() * 45) * 10 + 20, (int)(Math.random() * 45) * 10 + 20);
		}
		this.setX(p.getX());
		this.setY(p.getY());
	}

	private boolean check(Point p) {
		for (Point x : Global.snake.body) {
			if (x.getX() == p.getX() && x.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}
}
