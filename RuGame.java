package Homework;

import java.util.ArrayList;
import java.util.List;

public class RuGame extends AbstractGame {

    @Override
    List<String> generateCharList() {
        String ruAbc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            result.add(String.valueOf(ruAbc.charAt(i)));
        }
        return result;
    }
}