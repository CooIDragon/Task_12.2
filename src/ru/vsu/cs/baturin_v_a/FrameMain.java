package ru.vsu.cs.baturin_v_a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain extends JFrame {
    private JTextArea textArea;
    private JPanel panelMain;
    private JButton buttonDrawTriangle;
    private JSpinner spinnerDepthOfRecursion;

    public FrameMain() {
        this.setTitle("Task_12");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setResizable(true);
        this.pack();

        textArea.setFont(new Font("Monospaced", Font.PLAIN, 10));

        buttonDrawTriangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(null);
                DrawingTriangle drawingTriangle = new DrawingTriangle();

                int n = (int) spinnerDepthOfRecursion.getValue();
                if(n == 1) {
                    String[][] array1 = drawingTriangle.drawFirstTriangle();
                    for(int i = 0; i < array1.length; i++) {
                        for(int j = 0; j < array1[0].length; j++) {
                            textArea.append(array1[i][j]);
                        }
                        textArea.append("\n");
                        ;
                    }
                } else {
                    String[][] array = drawingTriangle.drawTriangle(drawingTriangle.drawFirstTriangle(), n);
                    for(int i = 0; i < array.length; i++) {
                        for(int j = 0; j < array[0].length; j++) {
                            textArea.append(array[i][j]);
                        }
                        textArea.append("\n");
                        ;
                    }
                }
            }
        });
    }
}
