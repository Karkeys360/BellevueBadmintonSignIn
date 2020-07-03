package com.BBCSignin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn {
    private JButton SignIn;
    private JPanel BasePanel;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel signInBox;

    public SignIn( ) {
        SignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SignIn signIn = new SignIn();
        JPanel basePanel = signIn.BasePanel;
        setTransparent(basePanel);
        signIn.signInBox.setOpaque(true);
        signIn.signInBox.setBackground(Color.white);
        BackgroundPanel p = new BackgroundPanel();
        p.add(basePanel);
        frame.setContentPane(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setTransparent(JPanel p) {
        p.setBackground(new Color(0, 0, 0, 0));
        p.setOpaque(false);
        for (Component c : p.getComponents()) {
            if (c instanceof JPanel)
             {
                setTransparent((JPanel) c);
            }
        }
    }

    private static class BackgroundPanel extends JLabel {
        Image image;
        private final String pic = "Background.png";

        public BackgroundPanel( ) {
            image = new ImageIcon(pic).getImage();
            image = scaleImage(image);
            this.setLayout(new GridLayout());
            this.setIcon(new ImageIcon(image));
        }


        private Image scaleImage(Image rawImage) {
            Image scaledImage = null;
            System.out.println("Scaling");
            try {
                int rawImageWidth = rawImage.getWidth(this);
                int rawImageHeight = rawImage.getHeight(this);
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int paneWidth = d.width;
                int paneHeight = d.height;
                System.out.println("Image W = " + rawImageWidth
                        + ", H = " + rawImageHeight
                        + "; Pane W = " + paneWidth
                        + ", H = " + paneHeight);
                // preserve the original ratio
                float widthRatio = (float) rawImageWidth / (float) paneWidth;
                float heightRatio = (float) rawImageHeight / (float) paneHeight;
                int widthFactor = -1;
                int heightFactor = -1;
                if (( widthRatio >= heightRatio ) && ( widthRatio > 1.0 )) {
                    widthFactor = paneWidth;
                } else if (( heightRatio > widthRatio ) && ( heightRatio > 1.0 )) {
                    heightFactor = paneHeight;
                }
                System.out.println("widthRatio = "
                        + String.format("%.3f", widthRatio)
                        + ", heightRatio = "
                        + String.format("%.3f", heightRatio));
                System.out.println("widthFactor = " + widthFactor
                        + ", heightFactor = " + heightFactor);
                if (( widthFactor < 0 ) && ( heightFactor < 0 )) {
                    scaledImage = rawImage;
                } else {
                    scaledImage = rawImage.getScaledInstance(widthFactor, heightFactor,
                            Image.SCALE_SMOOTH);
                    // load the new image, 'getScaledInstance' loads asynchronously
                    MediaTracker tracker = new MediaTracker(this);
                    tracker.addImage(scaledImage, 0);
                    tracker.waitForID(0);
                }
            } catch (InterruptedException ie) {
                System.err.println("load interrupt: " + ie.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ( scaledImage );
        }
    }


}
