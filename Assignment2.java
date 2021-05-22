import java.util.Scanner; //User input
import java.util.concurrent.ThreadLocalRandom;

public class Assignment2 {


    //NOTE: Doesn't account for non-integer user input
        // Might come back and fix this later with exception handeling
    static Scanner input;
    static int guess;
    static int num = ThreadLocalRandom.current().nextInt(1, 101); //Random number between 1-100
    static int attempts = 0;
    public static void guessMethod()
    {
        input = new Scanner(System.in);
        System.out.println("Guess a number between 1-100:");
        guess = input.nextInt();

        if(guess < 1 || guess > 100)
        {
            System.out.println("Guess is outside of range. Guess again!");
            guessMethod();
        }
        else if(guess>=num-10 && guess<=num+10)
        {
            System.out.println("Your guess is within 10 of the correct number!\nYour guess : " + guess + "\nCorrect answer: " + num);
            System.exit(1);
        }
        else
        {
            attempts++;
            if (attempts != 5)
            {
                System.out.println("Not quite! Guess again.\nAttempts left: " + (5-attempts));
                guessMethod();
            }
            else
            {
                System.out.println("Sorry, the correct answer is " + num);
                System.exit(1);
            }
        }
    }
    public static void main(String[] args) {
        //Random gen number -> request user input -> if/elses
        guessMethod();
    }
}