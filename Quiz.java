import java.util.*;

public class Quiz {
    static class Question {
        String text;
        String[] options;
        int correctIndex;

        Question(String text, String[] options, int correctIndex) {
            this.text = text;
            this.options = options;
            this.correctIndex = correctIndex;
        }

        boolean ask(Scanner scanner) {
            System.out.println(text);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Your answer: ");
            int ans = -1;
            try {
                ans = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                ans = -1;
            }
            return ans - 1 == correctIndex;
        }
    }

    public static void main(String[] args) {
        List<Question> questions = Arrays.asList(
            new Question(
                "What is the capital of France?",
                new String[]{"Berlin", "Paris", "Rome", "Madrid"}, 1),
            new Question(
                "Which language runs in a web browser?",
                new String[]{"Java", "C", "Python", "JavaScript"}, 3),
            new Question(
                "Who developed the theory of relativity?",
                new String[]{"Newton", "Einstein", "Galileo", "Tesla"}, 1)
        );

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (Question q : questions) {
            if (q.ask(scanner)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect.\n");
            }
        }
        System.out.println("You scored " + score + " out of " + questions.size());
        scanner.close();
    }
}
