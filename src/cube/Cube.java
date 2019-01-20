package cube;

import java.awt.*;

public class Cube {
    private Vector[] vector;
    private Face[] face;
    private Color color = new Color(0, 0, 0);
    private double[] angles = {0, 0, 0};
    public Cube(double size) {
        vector = new Vector[] {
            new Vector(0, 0, 0),
            new Vector(size, 0, 0),
            new Vector(size, size, 0),
            new Vector(0, size, 0),
            new Vector(0, 0, size),
            new Vector(size, 0, size),
            new Vector(size, size, size),
            new Vector(0, size, size)
        };
        face = new Face[] {
            new Face(vector[0], vector[1], vector[2], vector[3], color.green),
            new Face(vector[1], vector[5], vector[6], vector[2], color.blue),
            new Face(vector[6], vector[7], vector[3], vector[2], color.yellow),
            new Face(vector[0], vector[3], vector[7], vector[4], color.gray),
            new Face(vector[0], vector[4], vector[5], vector[1], color.orange),
            new Face(vector[4], vector[7], vector[6], vector[5], color.pink)
        };
    }
    public void rotate(double angleX, double angleY, double angleZ) {
        for (int i = 0; i < 6; i++) face[i].rotate(angleX, angleY, angleZ);
        angles[0] += angleX;
        angles[1] += angleY;
        angles[2] += angleZ;
    }
    public void draw(Graphics2D g2) {
        for (int i = 0; i < 6; i++) face[i].draw(g2);
    }
    public void draw(Graphics2D g2, double c) {
        for (int i = 0; i < 6; i++) face[i].draw(g2, c);
    }
    public void move(double x, double y, double z) {
        for (int i = 0; i < 8; i++){
            vector[i].x += x;
            vector[i].y += y;
            vector[i].z += z;
        }
    }
    public double[] getAngles() {
        return angles;
    }
}