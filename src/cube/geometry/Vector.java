package cube.geometry;

public class Vector {
    private double x, y, z;
    Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    void move(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }
    Vector minus(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }
    Vector cross(Vector vector) {
        return new Vector(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x
        );
    }
    void rotate(double angleX, double angleY, double angleZ) {
        this.rotateByX(angleX);
        this.rotateByY(angleY);
        this.rotateByZ(angleZ);
    }
    private void rotateByX(double angle) {
        angle *= Math.PI / 180;
        double tempY = y * Math.cos(angle) + z * Math.sin(angle);
        z = -y * Math.sin(angle) + z * Math.cos(angle);
        y = tempY;
    }
    private void rotateByY(double angle) {
        angle *= Math.PI / 180;
        double tempX = x * Math.cos(angle) + z * Math.sin(angle);
        z = -x * Math.sin(angle) + z * Math.cos(angle);
        x = tempX;
    }
    private void rotateByZ(double angle) {
        angle *= Math.PI / 180;
        double tempX = x * Math.cos(angle) - y * Math.sin(angle);
        y = x * Math.sin(angle) + y * Math.cos(angle);
        x = tempX;
    }
}