package cube;

import javax.swing.event.*;
import java.awt.event.*;

public class Control {
    public Control(Cube cube, Window window) {
        window.changeView.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                cube.altView = !cube.altView;
                window.repaint();
            }
        });
        window.headingSlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                double currentAngle = cube.getAngles()[1], sliderValue = -window.headingSlider.getValue();
                cube.rotate(0, sliderValue - currentAngle, 0);
                window.repaint();
            }
        });
        window.pitchSlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                double currentAngle = cube.getAngles()[0], sliderValue = -window.pitchSlider.getValue();
                cube.rotate(sliderValue - currentAngle, 0, 0);
                window.repaint();
            }
        });
    }
}