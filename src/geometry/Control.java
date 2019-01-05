package geometry;

import javax.swing.event.*;

public class Control {
    public Control(Cube cube, Window window) {
        window.pitchSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                cube.rotate((window.pitchSlider.getValue() - 360) / 360, 0, 0);
                window.repaint();
            }
        });
        window.headingSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                cube.rotate(0, window.headingSlider.getValue() / 180, 0);
                window.repaint();
            }
        });
    }
}