package cube.viewer;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;
import cube.geometry.*;

public class View extends JFrame {
    JSlider headingSlider, pitchSlider;
    JButton changeView;
    boolean altView;
    private Cube cube;
    public View(Cube cube) {
        Container pane = getContentPane();
        this.cube = cube;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane.setLayout(new BorderLayout());
        headingSlider = new JSlider(-180, 180, 0);
        pitchSlider = new JSlider(SwingConstants.VERTICAL, -180, 180, 0);
        pane.add(headingSlider, BorderLayout.SOUTH);
        pane.add(pitchSlider, BorderLayout.EAST);
        JPanel renderPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.translate(getWidth() / 2, getHeight() / 2);
                net(g);
                draw(g2);
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        changeView = new JButton("Switch View");
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
        g2.setColor(face.getColor());
        if (!altView) {
            if (face.getNormal().getZ() < 0) {
                Path2D path = new Path2D.Double();
                path.moveTo(face.getVectors()[0].getX(), -face.getVectors()[0].getY());
                for (int i = 1; i < 4; i++)
                    path.lineTo(face.getVectors()[i].getX(), -face.getVectors()[i].getY());
                path.closePath();
                g2.draw(path);
                g2.fill(path);
            }
        } else {
            double c = -200;
            if (face.getNormal(c).getZ() < 0) {
                Path2D path = new Path2D.Double();
                path.moveTo(
                        face.getVectors()[0].getX() * c / (c - face.getVectors()[0].getZ()),
                        -face.getVectors()[0].getY() * c / (c - face.getVectors()[0].getZ())
                );
                for (int i = 1; i < 4; i++)
                    path.lineTo(
                            face.getVectors()[i].getX() * c / (c - face.getVectors()[i].getZ()),
                            -face.getVectors()[i].getY() * c / (c - face.getVectors()[i].getZ())
                    );
                path.closePath();
                g2.fill(path);
            }
        }
    }
}