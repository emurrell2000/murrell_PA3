import java.util.Scanner;
import java.security.SecureRandom;

public class MathPractice {
    public static double genQuestion(int difficulty, int mathType) {
        SecureRandom rand = new SecureRandom();

        int rand1 = rand.nextInt((int) Math.pow(10, difficulty));
        int rand2 = rand.nextInt((int) Math.pow(10, difficulty));

        if (mathType == 5) {
            mathType = rand.nextInt(4) + 1;
        }
        // cannot divide by 0
        if (mathType == 4) {
            if (rand2 == 0) {
                rand2++;
            }
        }

        switch(mathType) {
            case 1: System.out.println("How much is " + rand1 + " plus " + rand2 + "?");
                return rand1 + rand2;
            case 2: System.out.println("How much is " + rand1 + " times " + rand2 + "?");
                return rand1 * rand2;
            case 3: System.out.println("How much is " + rand1 + " minus " + rand2 + "?");
                return rand1 - rand2;
            case 4: System.out.println("How much is " + rand1 + " divided by " + rand2 + "?");
                return 1.0 * rand1 / rand2;
            default: System.out.println("Something went wrong with math type.");
                return 0;
        }
    }
    public static boolean getAttempt(double answer) {
        Scanner in = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();

        final double THRESHOLD = 0.01;

        double attempt = in.nextDouble();

        int choice;
        // checks if attempt is within the threshold of answer, for division problems
        if (Math.abs(attempt - answer) < THRESHOLD) {
            choice = rand.nextInt(4);
            switch(choice) {
                case 0: System.out.println("Very good!");
                        break;
                case 1: System.out.println("Excellent!");
                        break;
                case 2: System.out.println("Nice work!");
                        break;
                case 3: System.out.println("Keep up the good work!");
                        break;
                default: System.out.println("Something is wrong");
                         break;
            }
            return true;
        }
        choice = rand.nextInt(4);
        switch(choice) {
            case 0: System.out.println("No. Please try again.");
                break;
            case 1: System.out.println("Wrong. Try once more.");
                break;
            case 2: System.out.println("Don’t give up!");
                break;
            case 3: System.out.println("No. Keep trying.");
                break;
            default: System.out.println("Something is wrong.");
                break;
        }
         return false;
    }
    public static void calculateScore(int sumCorrect, final int NUM_QUESTIONS) {
        double percentage = 100.0 * sumCorrect / NUM_QUESTIONS;
        if (percentage >= 75 && percentage <= 100) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else if (percentage < 75 && percentage >= 0) {
            System.out.println("Please ask your teacher for extra help.");
        }
        else {
            System.out.println("Something went wrong in the percentage.");
        }
    }
    public static int getDifficulty() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your difficulty level: 1 2 3 4");
        int difficulty = in.nextInt();
        return difficulty;
    }
    public static int getMathType() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your type of questions: 1-addition 2-multiplication 3-subtraction 4-division 5-all");
        System.out.println("Note: Division should be rounded to the nearest hundredth.");
        int mathType = in.nextInt();
        return mathType;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int NUM_QUESTIONS = 10;

        int i, difficulty, mathType;
        double answer;
        boolean correct;
        int repeat = 1;

        while (repeat == 1) {
            difficulty = getDifficulty();
            mathType = getMathType();

            int sumCorrect = 0;
            for (i = 0; i < NUM_QUESTIONS; i++) {
                answer = genQuestion(difficulty, mathType);

                correct = getAttempt(answer);
                if (correct) {
                    sumCorrect++;
                }
            }
            calculateScore(sumCorrect, NUM_QUESTIONS);
            System.out.println("Would you like to go again? 1=yes 0=no");
            repeat = in.nextInt();
        }

    }
}
