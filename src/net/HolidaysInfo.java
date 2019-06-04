package net;

import javax.swing.*;
import java.util.List;

public class HolidaysInfo extends JFrame {

    public HolidaysInfo(String title, List<String> holidays) {
        setLayout(null);
        setSize(600, 200 + holidays.size() * 12);
        JLabel label = new JLabel(title);
        JLabel label2 = new JLabel("Количество праздников: " + holidays.size());
        label2.setBounds(10, 20, 1000, 40);
        label.setBounds(10, 10, 1000, 40);
        add(label);
        add(label2);
        for (int i = 0; i < holidays.size(); i++) {
            label = new JLabel(holidays.get(i));
            label.setBounds(10, 80 + 15 * i, 1000, 15);
            add(label);
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}