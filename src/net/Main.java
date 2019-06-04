package net;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static String[] namesOfMonth = {"ЯНВАРЬ", "ФЕВРАЛЬ", "МАРТ", "АПРЕЛЬ", "МАЙ", "ИЮНЬ", "ИЮЛЬ", "АВГУСТ", "СЕНТЯБРЬ", "ОКТЯБРЬ", "НОЯБРЬ", "ДЕКАБРЬ", "ПЕРЕХОДЯЩИЕ ПРАЗДНИКИ", "КОНЕЦ"};

    public static void main(String[] args) throws IOException {
        Map<String, List<String>> textOfHolidays = new LinkedHashMap<>();
        Months months = new Months();
        for (int i = 1; i < namesOfMonth.length; i++)
            textOfHolidays.put(namesOfMonth[i - 1], months.getHolidays(namesOfMonth[i - 1], namesOfMonth[i]));
        JFrame frame = new JFrame();
        frame.setTitle("HolidaysRF");
        JPanel jcp = new JPanel(new BorderLayout());
        frame.setContentPane(jcp);
        jcp.add(new DrawingComponent(textOfHolidays), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        frame.setSize(910, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}