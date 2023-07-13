package Homework;

public class Answer {
    Integer bull;
    Integer cow;
    static int numTry;

    public Answer(Integer bull, Integer cow, int numTry) {
        this.bull = bull;
        this.cow = cow;
        this.numTry = numTry;
    }

    public Answer() {
    }

    @Override
    public String toString() {
        return "{" +
                "Быки " + bull +
                ", Коровы " + cow +
                ", Попытка " + numTry +
                '}';
    }
}

