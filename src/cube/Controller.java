package cube;

import javax.swing.event.*;
import java.awt.event.*;

public class Controller {
    public Controller(Cube cube, View view) {
        view.changeView.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                view.altView = !view.altView;
                view.repaint();
            }
        });
        view.headingSlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                cube.rotate(0, -view.headingSlider.getValue() - cube.angles()[1], 0);
                view.repaint();
            }
        });
        view.pitchSlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                cube.rotate(-view.pitchSlider.getValue() - cube.angles()[0], 0, 0);
                view.repaint();
            }
        });
    }
}