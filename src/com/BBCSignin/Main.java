package com.BBCSignin;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        JFrame frame = new JFrame("Bellevue Badminton Sign-in");
        SignIn signIn = new SignIn();
        JPanel basePanel = signIn.BasePanel;
        SignIn.setTransparent(basePanel);
        signIn.signInBox.setOpaque(true);
        signIn.signInBox.setBackground(Color.white);
        SignIn.BackgroundPanel p = new SignIn.BackgroundPanel();
        p.add(basePanel);
        frame.setContentPane(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
