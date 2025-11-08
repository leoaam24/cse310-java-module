import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your number here: ");
        int userInput = scanner.nextInt();
        String result = Integer.toString(userInput);

        if (userInput % 5 == 0 && userInput % 3 == 0) {
            result = "FizzBuzz";
        } else if (userInput % 3 == 0) {
            result = "Buzz";
        } else if (userInput % 5 == 0) {
            result = "Fizz";
        }


        System.out.println(result);
    }
}
