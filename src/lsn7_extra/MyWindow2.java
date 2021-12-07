package lsn7_extra;

import javax.swing.*;
import java.awt.*;

public class MyWindow2 extends JFrame {

    public MyWindow2(){
        setBounds(200,200,1000,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //базовое при закрытии
        setTitle("My window");

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        add(panel);

        JTextField textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        setVisible(true);
    }
}
