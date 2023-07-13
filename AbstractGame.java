package Homework;

import java.util.*;

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    int currentTry;
    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        Scanner sc = new Scanner(System.in);
        System.out.println("Какую игру начнем? 0 - цифры, 1 - российский алфавит, 2 - английский алфавит");
        Integer game = sc.nextInt();
        if (game == 0) {
            computerWord = generateWordNum();
        } else if (game == 1) {
            computerWord = generateWordRu();
        } else if (game == 2) {
            computerWord = generateWordEn();
        } else {
            System.out.println("Такой игры не найдено, попробуйте еще раз!");
            start(sizeWord, maxTry);
        }
        System.out.println("comp:  " + computerWord);
        this.gameStatus = GameStatus.START;
        this.currentTry = 0;
    }

    @Override
    public Answer inputValue(String value) {
        Map<Integer, String> history = new HashMap<>();
        if (currentTry >= maxTry) {
            gameStatus = GameStatus.FINISH;
            System.out.println("вы проиграли по количеству попыток");
            System.out.println("Компьютер загадал: " + computerWord);
            return null;
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                bull++;
                cow++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cow++;
            }
        }
        currentTry++;
        history.put(currentTry, value);
        if (sizeWord.equals(bull)) {
            gameStatus = GameStatus.FINISH;
            System.out.println("вы Победили!!");
            System.out.println("Компьютер загадал: " + computerWord);
            return null;
        }
        return new Answer(bull, cow, currentTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    abstract List<String> generateCharList();

    /**
     * @return рандомное слово String
     * @apiNote генерирует слово из цифр
     */
    private String generateWordNum() {
        NumberGame ng = new NumberGame();
        List<String> charList = ng.generateCharList();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result += charList.get(randomIndex);
            charList.remove(randomIndex);
        }
        return result;
    }

    /**
     * @return рандомное слово String
     * @apiNote генерирует слово из русского алфавита
     */
    private String generateWordRu() {
        RuGame rg = new RuGame();
        List<String> charList = rg.generateCharList();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result += charList.get(randomIndex);
            charList.remove(randomIndex);
        }
        return result;
    }

    /**
     * @return рандомное слово String
     * @apiNote генерирует слово из английского алфавита
     */
    private String generateWordEn() {
        EnGame en = new EnGame();
        List<String> charList = en.generateCharList();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result += charList.get(randomIndex);
            charList.remove(randomIndex);
        }
        return result;
    }
}
