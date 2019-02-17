package cube;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

public class View extends JFrame {
    public JSlider headingSlider, pitchSlider;
    public JButton changeView;
    public boolean altView;
    private Cube cube;
    private final Container pane = getContentPane();
    public View(Cube cube) {
        this.cube = cube;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane.setLayout(new BorderLayout());
        headingSlider = new JSlider(-180, 180, 0);
        pitchSlider = new JSlider(SwingConstants.VERTICAL, -180, 180, 0);
        pane.add(headingSlider, BorderLayout.SOUTH);
        pane.add(pitchSlider, BorderLayout.EAST);
        JPanel renderPanel = new JPanel() {
            @Override public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.translate(getWidth() / 2, getHeight() / 2);
                net(g);
                draw(g2);
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        changeView = new JButton("Perspective View");
        pane.add(changeView, BorderLayout.NORTH);
        setSize(800, 800);
        setVisible(true);
    }
    private void net(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(0, getHeight(), 0, -getHeight());
        g.drawLine(getWidth(), 0, -getWidth(), 0);
    }
    private void draw(Graphics2D g2) {
        for (int i = 0; i < 6; i++)
            drawFace(g2, cube.faces()[i]);
    }
    private void drawFace(Graphics2D g2, Face face) {
        g2.setColor(face.color());
        if (!altView) {
            if (face.normal().z() < 0) {
                Path2D path = new Path2D.Double();
                path.moveTo(face.vectors()[0].x(), -face.vectors()[0].y());
                for (int i = 1; i < 4; i++)
                    path.lineTo(face.vectors()[i].x(), -face.vectors()[i].y());
                path.closePath();
                g2.draw(path);
                g2.fill(path);
            }
        } else {
            double c = -200;
            if (face.normal(c).z() < 0) {
                Path2D path = new Path2D.Double();
                path.moveTo(
                        face.vectors()[0].x() * c / (c - face.vectors()[0].z()),
                        -face.vectors()[0].y() * c / (c - face.vectors()[0].z())
                );
                for (int i = 1; i < 4; i++)
                    path.lineTo(
                            face.vectors()[i].x() * c / (c - face.vectors()[i].z()),
                            -face.vectors()[i].y() * c / (c - face.vectors()[i].z())
                    );
                path.closePath();
                g2.fill(path);
            }
        }
    }
}