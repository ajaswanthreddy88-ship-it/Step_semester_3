class Scorecard {
    private boolean[] results;
    private int answerCount;

    // Constructor
    Scorecard(int numberOfQuestions) {
        results = new boolean[numberOfQuestions];
        answerCount = 0;
    }

    // Record an answer
    void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        } else {
            System.out.println("No more answers can be recorded");
        }
    }

    // Calculate score
    int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
