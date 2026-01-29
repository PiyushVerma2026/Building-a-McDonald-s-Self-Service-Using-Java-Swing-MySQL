package com.Team01.UI;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {
    
    public SplashScreen() {
        setUndecorated(true); // Removes the top bar
        setSize(600, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        
        // 1. Set GridBagLayout for percentage control
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;

        // --- TOP PART: 55% Image ---
        ImageIcon mcdIcon = new ImageIcon("C:\\Users\\Kartikeyan\\OneDrive\\Desktop\\JAVAPROJECT\\McDONALDS\\images\\mcdonalds.png");
        // We scale the image to roughly 55% of 700px height (~385px)
        Image scaledImg = mcdIcon.getImage().getScaledInstance(600, 385, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        
        gbc.gridy = 0;
        gbc.weighty = 0.55; // This sets the 55% height
        add(imageLabel, gbc);

        // --- BOTTOM PART: 45% Text ---
        JPanel textPanel = new JPanel(new GridBagLayout());
        textPanel.setBackground(new Color(191, 12, 12)); // McDonald's Red
        
        JLabel welcomeLabel = new JLabel("<html><center>WELCOME TO McDONALD'S<br><small>Loading your menu...</small></center></html>", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Impact", Font.PLAIN, 30));
        welcomeLabel.setForeground(new Color(255, 188, 13)); // McDonald's Yellow
        
        textPanel.add(welcomeLabel);

        gbc.gridy = 1;
        gbc.weighty = 0.45; // This sets the 45% height
        add(textPanel, gbc);

        setVisible(true);

        // 2. Timer to switch to Order Screen
        Timer timer = new Timer(4000, e -> {
            new OrderScreen().setVisible(true);
            this.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }
}