package wordle.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame {
    String[] wordPool = {"apple", "beach", "candy"};
    String selectedWord = " ";

    public welcome() {

        setTitle("Wordle Game");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel();
        label.setText("Welcome to Wordle!");
        label.setBounds(190, 60, 150, 30);

        JLabel question = new JLabel();
        question.setText("Please choose a word to guess:");
        question.setBounds(150, 140, 200, 30);

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");

        Font buttonFont = new Font(b1.getFont().getName(), Font.PLAIN, 24); // Set the font size for the buttons
        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b3.setFont(buttonFont);

        Dimension buttonSize = new Dimension(90, 60); // Set the size for the buttons
        b1.setPreferredSize(buttonSize);
        b2.setPreferredSize(buttonSize);
        b3.setPreferredSize(buttonSize);

        b1.setBounds(50, 260, 90, 60);
        b2.setBounds(210, 260, 90, 60);
        b3.setBounds(370, 260, 90, 60);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedWord = wordPool[0];
                new frame(selectedWord);
                dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedWord = wordPool[1];
                new frame(selectedWord);
                dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedWord = wordPool[2];
                new frame(selectedWord);
                dispose();
            }
        });

        panel.add(label);
        panel.add(question);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

    }




}
