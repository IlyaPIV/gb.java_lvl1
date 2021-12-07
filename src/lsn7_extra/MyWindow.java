package lsn7_extra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow(){
        setBounds(200,200,1000,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //базовое при закрытии
        setTitle("My window");

        setLayout(new BorderLayout());
        //setLayout(new GridLayout(5,5)); //табличка
        //setLayout(new FlowLayout()); //заполнение по ширине

        //новая кнопка
        JButton button = new JButton("Say hello");
        add(button, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        //southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setLayout(new GridLayout(5,2));
        for (int i = 0; i < 10; i++) {
            southPanel.add(new JButton("Btn"+(i+1)),BorderLayout.SOUTH);
        }
        add(southPanel, BorderLayout.SOUTH);


        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);

        /*========события======*/

        //олдскул
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textArea.append("Hello world!\n");
//            }
//        });

        //тоже самое что и сверху
        button.addActionListener(e -> textArea.append("Hello world\n"));




        setVisible(true);
    }
}
