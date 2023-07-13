package Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> history = new HashMap<>();
        Integer count = 1;
        NumberGame numberGame = new NumberGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько будет символов? ");
        Integer sizeWord = scanner.nextInt();
        System.out.println("Сколько будет попыток? ");
        Integer maxTry = scanner.nextInt();
        numberGame.start(sizeWord, maxTry);
        scanner.nextLine();
        while (!numberGame.getGameStatus().equals(GameStatus.FINISH)) {
            System.out.println("Введите символы: ");
            String value = scanner.nextLine().toLowerCase();
            history.put(count, value);
            count += 1;
            Answer answer = numberGame.inputValue(value);
            if (answer != null) {
                System.out.println("Результат: " + answer);
            }
        }
        System.out.println("Хотите посмотреть историю игры? 0 - нет, 1 - да");
        Integer historyAnswer = scanner.nextInt();
        if (historyAnswer == 1) {
            for (int i = 1; i < history.size(); i++) {
                System.out.println("Попытка " + i + " ввели " + history.get(i));
            }
        }
    }
}