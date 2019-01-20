package cube;

import java.awt.*;
import java.awt.geom.*;

public class Face {
    public Vector[] vector;
    private Color color;
    public boolean altView;
    public Face(Vector v1, Vector v2, Vector v3, Vector v4, Color color) {
        vector = new Vector[] {v1, v2, v3, v4};
        this.color = color;
    }
    public Face(Vector v1, Vector v2, Vector v3, Vector v4) {
        vector = new Vector[] {v1, v2, v3, v4};
        this.color = Color.red;
    }
    public Face rotate(double angleX, double angleY, double angleZ) {
        for (int i = 0; i < 4; i++) vector[i] = vector[i].rotate(angleX, angleY, angleZ);
        return new Face(vector[0], vector[1], vector[2], vector[3]);
    }
    private Vector normal() {
        return vector[2].minus(vector[1]).cross(vector[1].minus(vector[0]));
    }
    private Vector normal(double c) {
        Vector[] vectors = new Vector[4];
        for (int i = 0; i < 4; i++) vectors[i] = new Vector(vector[i].x * c / (c - vector[i].z), vector[i].y * c / (c - vector[i].z), vector[i].z);
        return vectors[2].minus(vectors[1]).cross(vectors[1].minus(vectors[0]));
    }
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        if (!altView) {
            if (normal().z < 0) {
                Path2D path = new Path2D.Double();
                path.moveTo(vector[0].x, -vector[0].y);
                for (int i = 1; i < 4; i++) path.lineTo(vector[i].x, -vector[i].y);
                path.closePath();
                g2.draw(path);
                g2.fill(path);
            }
        } else {
            double c = -200;
            if (normal(c).z < 0) {
                Path2D path = new Path2D.Double();
                path.moveTo(vector[0].x * c / (c - vector[0].z), -vector[0].y * c / (c - vector[0].z));
                for (int i = 1; i < 4; i++) path.lineTo(vector[i].x * c / (c - vector[i].z), -vector[i].y * c / (c - vector[i].z));
                path.closePath();
                g2.fill(path);
            }
        }
    }
}