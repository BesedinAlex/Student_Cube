package cube;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(100);
        Window window = new Window(cube);
        cube.move(-50, -50, -50);
        Control control = new Control(cube, window);
    }
}