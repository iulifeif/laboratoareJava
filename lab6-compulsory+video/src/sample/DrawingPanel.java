package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class DrawingPanel extends JPanel {
    MainFrame frame;
    final static int W = 800, H = 600;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image

    public void ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
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
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void drawShape(int x, int y) {
        int radius = generateRadius(); //generate a random number
        int sides = generateSides(); //get the value from UI (in ConfigPanel)
        Color color = generateColor(); //create a transparent random Color.
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    private int generateRadius()
    {
        Random random = new Random();
        int low = 20;
        int high = 100;
        return random.nextInt(high - low) + low;
    }
    private Color generateColor(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return  new Color(r,g,b);
    }
    private int generateSides()
    {
        Random random = new Random();
        int low = 2;
        int high = 6;
        return random.nextInt(high - low) + low;
    }
    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
