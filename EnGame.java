package Homework;

import java.util.ArrayList;
import java.util.List;

public class EnGame extends AbstractGame {

    @Override
    List<String> generateCharList() {
        String enAbc = "abcdefghijklmnopqrstuvwxyz";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            result.add(String.valueOf(enAbc.charAt(i)));
        }
        return result;
    }
}