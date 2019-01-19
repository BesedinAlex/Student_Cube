package cube;

public class Vector {
    public double x, y, z;
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double dot(Vector vector) {
        return vector.x * x + vector.y * y + vector.z * z;
    }
    public Vector multiplyByNumber(double a) {
        return new Vector (this.x * a, this.y * a, this.z * a);
    }
    public Vector plus(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }
    public Vector minus(Vector vector) {
        return new Vector(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }
    public Vector cross(Vector vector) {
        return new Vector(this.y * vector.z - this.z * vector.y , this.z * vector.x - this.x * vector.z, this.x * vector.y - this.y * vector.x);
    }
    private Vector rotateByX(double angle) {
        angle *= Math.PI / 180;
        return new Vector(this.x, this.y * Math.cos(angle) + this.z * Math.sin(angle), -this.y * Math.sin(angle) + this.z * Math.cos(angle));
    }
    private Vector rotateByY(double angle) {
        angle *= Math.PI / 180;
        return new Vector(this.x * Math.cos(angle) + this.z * Math.sin(angle), this.y , -this.x * Math.sin(angle) + this.z * Math.cos(angle));
    }
    private Vector rotateByZ(double angle) {
        angle *= Math.PI / 180;
        return new Vector(this.x * Math.cos(angle) - this.y * Math.sin(angle), this.x * Math.sin(angle) + this.y * Math.cos(angle), this.z);
    }
    public Vector rotate(double angleX, double angleY, double angleZ) {
        return this.rotateByX(angleX).rotateByY(angleY).rotateByZ(angleZ);
    }
    public void printCoordinates() {
        System.out.println(" x = " + this.x + " y = " + this.y + " z = " + this.z);
    }
}