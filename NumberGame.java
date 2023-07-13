package Homework;

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> resultNum = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            resultNum.add(String.valueOf(i));
        }
        return resultNum;
    }
}