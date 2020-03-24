package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(3, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("./test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e) {
        try {
            final BufferedImage read = ImageIO.read(new FileInputStream("./test1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void reset(ActionEvent e) {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void exit(ActionEvent e) {
        frame.setVisible(false);
    }
}
