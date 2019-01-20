package cube;

import javax.swing.event.*;
import java.awt.event.*;

public class Control {
    public Control(Cube cube, Window window) {
        window.headingSlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                double currentAngle = cube.getAngles()[1], sliderValue = -window.headingSlider.getValue(), toChange = 0;
                if (currentAngle > sliderValue) toChange = -(currentAngle - sliderValue);
                if (currentAngle < sliderValue) toChange = sliderValue - currentAngle;
                cube.rotate(0, toChange, 0);
                window.repaint();
            }
        });
        window.pitchSlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                double currentAngle = cube.getAngles()[0], sliderValue = -window.pitchSlider.getValue(), toChange = 0;
                if (currentAngle > sliderValue) toChange = -(currentAngle - sliderValue);
                if (currentAngle < sliderValue) toChange = sliderValue - currentAngle;
                cube.rotate(toChange, 0, 0);
                window.repaint();
            }
        });
        window.changeView.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                cube.altView = !cube.altView;
                window.repaint();
            }
        });
    }
}