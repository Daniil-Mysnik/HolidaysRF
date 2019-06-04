package net;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DrawingComponent extends JPanel {
    private Map<String, List<String>> holidays;

    public DrawingComponent(Map<String, List<String>> holidays) throws IOException {
        setLayout(null);
        this.holidays = holidays;
        BufferedImage buttonIcon = ImageIO.read(new File("question.png"));
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setBounds(910 - 81, 1, 64, 64);
        button.setBackground(new Color(238, 238, 238));
        button.setBorder(null);
        button.addActionListener(e -> new HolidaysInfo("ПЕРЕХОДЯЩИЕ ПРАЗДНИКИ", holidays.get("ПЕРЕХОДЯЩИЕ ПРАЗДНИКИ")));
        add(button);
    }

    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D) gh;
        for (int i = 2; i < 9; i++) {
            drp.drawLine(50, 50 + 44 * i, 1000, 50 + 44 * i);
            int vs = 80 - i * 10;
            drp.drawString(vs + "", 30, 50 + 44 * i);
        }
        int i = 0;
        for (Map.Entry<String, List<String>> entry : holidays.entrySet()) {
            if (i == holidays.size() - 1) continue;
            drp.drawString(entry.getKey(), 54 + i * 70, 420);
            int realY = (400 - 44 * entry.getValue().size() / 10) + 3;
            DrawRect rect = new DrawRect(entry.getKey(), entry.getValue(), 50 + 71 * i++, realY, 40, (int) (entry.getValue().size() * 4.4));
            add(rect);
        }
    }
}

class DrawRect extends JPanel {
    private List<String> month;
    private String title;

    public DrawRect(String title, List<String> month, int x, int y, int width, int height) {
        this.title = title;
        this.month = month;
        setBounds(x, y, width, height);
        addMouseListener(new MouseHandler());
        setBackground(Color.BLACK);
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            new HolidaysInfo(title, month);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }
    }
}