package wordle.src;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class frame extends JFrame implements KeyListener, DocumentListener {

    JTextField textFields[][] = new JTextField[6][5];
    JPanel panel = new JPanel();
    String selectedWord; // Replace with your selected word
    int currentRow = 0;

    public frame(String selectedWord) {
        this.selectedWord = selectedWord;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setSize(500, 600);

        panel.setVisible(true);
        panel.setLayout(new GridLayout(6, 5));

        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[0].length; j++) {

                textFields[i][j] = new JTextField();
                textFields[i][j].setBackground(Color.WHITE);
                textFields[i][j].setEnabled(true);
                textFields[i][j].setFont(new Font("MV Boli", Font.BOLD, 20));
                textFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                textFields[i][j].addKeyListener(this);
                textFields[i][j].getDocument().addDocumentListener(this);
                panel.add(textFields[i][j]);
            }
        }
        this.add(panel);
        this.setTitle("WORDLE");
        this.addKeyListener(this);

        this.repaint();
        this.revalidate();
        this.setLocationRelativeTo(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    int incorrectCount = 0;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (currentRow < 6) {
                String input = getRowInput(currentRow);
                char[] inputArr = input.toCharArray();
                char[] selectedWordArr = selectedWord.toCharArray();

                int correctCount = 0;

                for (int i = 0; i < inputArr.length; i++) {
                    if (selectedWord.contains(String.valueOf(inputArr[i]))) {
                        if (inputArr[i] == selectedWordArr[i]) {
                            correctCount++;
                            textFields[currentRow][i].setBackground(Color.GREEN);
                        } else {
                            textFields[currentRow][i].setBackground(Color.YELLOW);
                        }
                    } else {
                        textFields[currentRow][i].setBackground(Color.RED);

                    }
                }

                if (correctCount == selectedWord.length()) {
                    // Correct word entered
                    int choice = JOptionPane.showOptionDialog(this, "Correct word! Retry?", "Success",
                            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                    if (choice == JOptionPane.YES_OPTION){
                        dispose();
                        new welcome();
                    }else{
                        System.exit(0);
                    }
                } else {
                    // Incorrect word entered
                    currentRow++;
                    if (currentRow < 6) {
                        textFields[currentRow][0].requestFocus();
                    }

                    if (correctCount != selectedWord.length()) {
                        incorrectCount++;
                    }

                    if (currentRow == 6 && incorrectCount == 6) {
                        int retryChoice = JOptionPane.showOptionDialog(this, "Incorrect word! Retry?", "Failure",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        if (retryChoice == JOptionPane.YES_OPTION) {
                            dispose();
                            new welcome();
                        } else {
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }

    private String getRowInput(int row) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < textFields[0].length; j++) {
            sb.append(textFields[row][j].getText());
        }
        return sb.toString();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // TODO Auto-generated method stub

    }


}

