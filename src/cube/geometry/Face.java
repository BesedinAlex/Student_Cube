package cube.geometry;

import java.awt.Color;

public class Face {
    private Vector[] vectors;
    private Color color;
    Face(Vector v1, Vector v2, Vector v3, Vector v4, Color color) {
        vectors = new Vector[] {v1, v2, v3, v4};
        this.color = color;
    }
    public Vector[] getVectors() {
        return vectors;
    }
    public Color getColor() {
        return color;
    }
    void rotate(double angleX, double angleY, double angleZ) {
        for (int i = 0; i < 4; i++)
            vectors[i].rotate(angleX, angleY, angleZ);
    }
    public Vector getNormal() {
        return vectors[2].minus(vectors[1]).cross(vectors[1].minus(vectors[0]));
    }
    public Vector getNormal(double c) {
        Vector[] vectors = new Vector[4];
        for (int i = 0; i < 4; i++)
            vectors[i] = new Vector(
                    this.vectors[i].getX() * c / (c - this.vectors[i].getZ()),
                    this.vectors[i].getY() * c / (c - this.vectors[i].getZ()),
                    this.vectors[i].getZ()
            );
        return vectors[2].minus(vectors[1]).cross(vectors[1].minus(vectors[0]));
    }
}