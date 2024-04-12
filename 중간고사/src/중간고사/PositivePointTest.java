package 중간고사;

class Point {
    private int x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}

class PositivePoint extends Point {
    public PositivePoint() {
        super(); // Call the default constructor of the base class (Point)
    }

    public PositivePoint(int a, int b) {
        if (a < 0 || b < 0) {
            super.setXY(0, 0); // Set the point to (0, 0) when the coordinates are negative
        } else {
            super.setXY(a, b); // Set the point to (a, b)
        }
    }

    @Override
    public void setXY(int x, int y) {
        if (x >= 0 && y >= 0) {
            super.setXY(x, y); // Set the coordinates only if they are positive
        }
    }
    public void move(int x, int y) {
        if (x >= 0 && y >= 0) {
            super.move(x, y); // Move to the new coordinates only if they are positive
        }
    }
}

public class PositivePointTest {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();
        p.move(25, 30);
        System.out.println("p is " + p.toString());

        p.move(-5, 5);
        System.out.println("p is " + p.toString());

        PositivePoint p2 = new PositivePoint(-10, -5);
        System.out.println("p2 is " + p2.toString());
    }
}

