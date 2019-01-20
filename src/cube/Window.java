package cube;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
    private final Container pane = getContentPane();
    public JSlider headingSlider, pitchSlider;
    public Window(Cube cube) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane.setLayout(new BorderLayout());
        headingSlider = new JSlider(0, 360, 0);
        pitchSlider = new JSlider(SwingConstants.VERTICAL, 0, 360, 0);
        pane.add(headingSlider, BorderLayout.SOUTH);
        pane.add(pitchSlider, BorderLayout.EAST);
        JPanel renderPanel = new JPanel() {
            @Override public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.translate(getWidth() / 2, getHeight() / 2);
                net(g);
                cube.draw(g2);
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        setSize(800, 800);
        setVisible(true);
    }
    private void net(Graphics g) {
        g.setColor(Color.green);
        g.drawLine(0, getHeight(), 0, -getHeight());
        g.drawLine(getWidth(), 0, -getWidth(), 0);
    }
}