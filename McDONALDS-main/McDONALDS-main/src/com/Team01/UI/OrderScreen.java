package com.Team01.UI;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;

import com.Team01.DTO.OrderDTO;

import com.Team01.dao.OrderDAO;

public class OrderScreen extends JFrame {

    private String orderType;

    private static int orderNo = 90;

    // McDonald's Brand Palette

    Color mcdRed = new Color(191, 12, 12);

    Color mcdYellow = new Color(255, 188, 13);

    // Custom Fonts

    Font titleFont = new Font("Impact", Font.PLAIN, 35);

    Font buttonFont = new Font("Verdana", Font.BOLD, 20);

    public OrderScreen() {

        setTitle("McDonald's Self-Service");

        setSize(600, 700);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        showStartMenu();

    }

    private void showStartMenu() {

        getContentPane().removeAll();

        getContentPane().setBackground(mcdRed);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel logoLabel = new JLabel("READY TO ORDER?", SwingConstants.CENTER);

        logoLabel.setFont(titleFont);

        logoLabel.setForeground(mcdYellow);

        JButton dineIn = createStyledButton("DINE IN", mcdYellow, mcdRed);

        JButton pickUp = createStyledButton("PICK UP", mcdYellow, mcdRed);

        dineIn.addActionListener(e -> {
            orderType = "DINE IN";
            showFoodMenu();
        });

        pickUp.addActionListener(e -> {
            orderType = "PICK UP";
            showFoodMenu();
        });

        gbc.insets = new Insets(15, 0, 15, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;

        add(logoLabel, gbc);

        gbc.gridy = 1;
        add(dineIn, gbc);

        gbc.gridy = 2;
        add(pickUp, gbc);

        revalidate();

        repaint();

    }

    private void showFoodMenu() {

        getContentPane().removeAll();

        getContentPane().setBackground(Color.WHITE);

        setLayout(new BorderLayout());

        JLabel header = new JLabel("SELECT YOUR FAVORITES", SwingConstants.CENTER);

        header.setFont(new Font("Impact", Font.PLAIN, 28));

        header.setOpaque(true);

        header.setBackground(mcdYellow);

        header.setPreferredSize(new Dimension(600, 80));

        add(header, BorderLayout.NORTH);

        JPanel foodGrid = new JPanel(new GridLayout(2, 2, 20, 20));

        foodGrid.setBackground(Color.WHITE);

        foodGrid.setBorder(new EmptyBorder(20, 20, 20, 20));

        foodGrid.add(createFoodButton("Big Mac",
                "C:\\Users\\Kartikeyan\\OneDrive\\Desktop\\JAVAPROJECT\\McDONALDS\\images\\burger.jpg"));

        foodGrid.add(createFoodButton("French Fries",
                "C:\\Users\\Kartikeyan\\OneDrive\\Desktop\\JAVAPROJECT\\McDONALDS\\images\\fries.jpg"));

        foodGrid.add(createFoodButton("McNuggets",
                "C:\\Users\\Kartikeyan\\OneDrive\\Desktop\\JAVAPROJECT\\McDONALDS\\images\\nuggets.jpg"));

        foodGrid.add(createFoodButton("Cold Drink",
                "C:\\Users\\Kartikeyan\\OneDrive\\Desktop\\JAVAPROJECT\\McDONALDS\\images\\drinks.jpg"));

        add(foodGrid, BorderLayout.CENTER);

        // Crucial for refreshing the UI

        revalidate();

        repaint();

    }

    private JButton createFoodButton(String name, String imgPath) {

        JButton btn = new JButton(name);

        btn.setFont(new Font("Arial", Font.BOLD, 16));

        btn.setVerticalTextPosition(SwingConstants.BOTTOM);

        btn.setHorizontalTextPosition(SwingConstants.CENTER);

        btn.setBackground(Color.WHITE);

        btn.setFocusPainted(false);

        try {

            ImageIcon icon = new ImageIcon(imgPath);

            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            btn.setIcon(new ImageIcon(img));

        } catch (Exception e) {

            System.out.println("Image not found: " + imgPath);

        }

        btn.addActionListener(e -> processOrder(name));

        return btn;

    }

    private JButton createStyledButton(String text, Color bg, Color fg) {

        JButton btn = new JButton(text);

        btn.setPreferredSize(new Dimension(250, 60));

        btn.setBackground(bg);

        btn.setForeground(fg);

        btn.setFont(buttonFont);

        btn.setFocusPainted(false);

        btn.setBorder(BorderFactory.createRaisedBevelBorder());

        return btn;

    }
    private void showThankYouScreen() {
        // Clear the food menu from the window
        getContentPane().removeAll();
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;

        // --- TOP PART: 65% Image of a Man ---
        // Ensure this path matches your actual image file location
        ImageIcon manIcon = new ImageIcon("C:\\Users\\Kartikeyan\\OneDrive\\Desktop\\JAVAPROJECT\\McDONALDS\\images\\namaste.jpg");
        // Scaling to fit width and approximately 65% of the 700px height
        Image manImg = manIcon.getImage().getScaledInstance(600, 455, Image.SCALE_SMOOTH); 
        JLabel imageLabel = new JLabel(new ImageIcon(manImg));
        
        gbc.gridy = 0;
        gbc.weighty = 0.65; // Assigns 65% of vertical space
        add(imageLabel, gbc);

        // --- BOTTOM PART: 35% Thank You Text ---
        JPanel textPanel = new JPanel(new GridBagLayout());
        textPanel.setBackground(mcdYellow);
        
        JLabel thankYouText = new JLabel("<html><center>Thank you for ordering from us!<br>Please be patient, your order will arrive soon.</center></html>", SwingConstants.CENTER);
        thankYouText.setFont(new Font("Verdana", Font.BOLD, 22));
        thankYouText.setForeground(mcdRed);
        textPanel.add(thankYouText);

        gbc.gridy = 1;
        gbc.weighty = 0.35; // Assigns 35% of vertical space
        add(textPanel, gbc);

        // Refresh the UI
        revalidate();
        repaint();

        // Optional: Automatically return to the start menu after 7 seconds
        Timer timer = new Timer(7000, e -> showStartMenu());
        timer.setRepeats(false);
        timer.start();
    }

    
    private void processOrder(String food) {
        OrderDTO order = new OrderDTO();
        order.setOrderId(orderNo);
        order.setType(orderType);
        order.setFoodItem(food);

        JOptionPane.showMessageDialog(this, "Order Placed Successfully!");

        int table = 0;
        if (orderType.equals("DINE IN")) {
            String input = JOptionPane.showInputDialog(this, "Enter Table Number:");
            try { 
                table = Integer.parseInt(input); 
            } catch (Exception e) { 
                table = 0; 
            }
        }
        order.setTableNo(table);

        try {
            OrderDAO.saveOrder(order);
            JOptionPane.showMessageDialog(this, "Order #" + orderNo + " Placed!");
            orderNo++;
            
            // Call the Thank You screen instead of showStartMenu()
            showThankYouScreen(); 
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
