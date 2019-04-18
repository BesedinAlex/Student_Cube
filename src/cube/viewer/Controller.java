package cube.viewer;

import javax.swing.event.*;
import java.awt.event.*;
import cube.geometry.*;

public class Controller {
    public Controller(Cube cube, View view) {
        view.changeView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.altView = !view.altView;
                view.repaint();
            }
        });
        view.headingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cube.rotate(0, -view.headingSlider.getValue() / 3.0 - cube.getAngles()[1], 0);
                view.repaint();
            }
        });
        view.pitchSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                cube.rotate(-view.pitchSlider.getValue() / 3.0 - cube.getAngles()[0], 0, 0);
                view.repaint();
            }
        });
    }
}