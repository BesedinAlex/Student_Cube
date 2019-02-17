package cube;

import java.awt.*;

public class Cube {
    private Vector[] vectors;
    private Face[] faces;
    private double[] angles = {0, 0, 0};
    public Cube(double size) {
        Color color = new Color(0, 0, 0);
        vectors = new Vector[] {
            new Vector(0, 0, 0),
            new Vector(size, 0, 0),
            new Vector(size, size, 0),
            new Vector(0, size, 0),
            new Vector(0, 0, size),
            new Vector(size, 0, size),
            new Vector(size, size, size),
            new Vector(0, size, size)
        };
        faces = new Face[] {
            new Face(vectors[0], vectors[1], vectors[2], vectors[3], color.green),
            new Face(vectors[1], vectors[5], vectors[6], vectors[2], color.blue),
            new Face(vectors[6], vectors[7], vectors[3], vectors[2], color.yellow),
            new Face(vectors[0], vectors[3], vectors[7], vectors[4], color.gray),
            new Face(vectors[0], vectors[4], vectors[5], vectors[1], color.orange),
            new Face(vectors[4], vectors[7], vectors[6], vectors[5], color.pink)
        };
    }
    public Face[] faces() {
        return faces;
    }
    public void rotate(double angleX, double angleY, double angleZ) {
        for (int i = 0; i < 6; i++)
            faces[i].rotate(angleX, angleY, angleZ);
        angles[0] += angleX;
        angles[1] += angleY;
        angles[2] += angleZ;
    }
    public void move(double x, double y, double z) {
        for (int i = 0; i < 8; i++)
            vectors[i].move(x, y, z);
    }
    public double[] angles() {
        return angles;
    }
}