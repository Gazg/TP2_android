package mlv.tp2;

/**
 * Created by Florian on 12/12/2014.
 */
public class Point {

    private float x;
    private float y;
    private int color;

    public Point(float x, float y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getColor() {
        return color;
    }
}
