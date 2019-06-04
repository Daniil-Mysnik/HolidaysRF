package net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Months {


    public List<String> getHolidays(String from, String to) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            List<String> list = new ArrayList<>();
            boolean a = false;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(from)) {
                    a = true;
                    continue;
                }
                if (line.equals(to))
                    break;
                if (a)
                    list.add(line);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}