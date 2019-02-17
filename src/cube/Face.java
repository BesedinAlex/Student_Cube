package cube;

import java.awt.Color;

public class Face {
    private Vector[] vectors;
    private Color color;
    public Face(Vector v1, Vector v2, Vector v3, Vector v4, Color color) {
        vectors = new Vector[] {v1, v2, v3, v4};
        this.color = color;
    }
    public Vector[] vectors() {
        return vectors;
    }
    public Color color() {
        return color;
    }
    public Face rotate(double angleX, double angleY, double angleZ) {
        for (int i = 0; i < 4; i++)
            vectors[i] = vectors[i].rotate(angleX, angleY, angleZ);
        return new Face(vectors[0], vectors[1], vectors[2], vectors[3], color);
    }
    public Vector normal() {
        return vectors[2].minus(vectors[1]).cross(vectors[1].minus(vectors[0]));
    }
    public Vector normal(double c) {
        Vector[] vectors = new Vector[4];
        for (int i = 0; i < 4; i++)
            vectors[i] = new Vector(
                    this.vectors[i].x() * c / (c - this.vectors[i].z()),
                    this.vectors[i].y() * c / (c - this.vectors[i].z()),
                    this.vectors[i].z()
            );
        return vectors[2].minus(vectors[1]).cross(vectors[1].minus(vectors[0]));
    }
}