package cube;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(100);
        cube.move(-50, -50, -50);
        View view = new View(cube);
        Controller controller = new Controller(cube, view);
    }
}