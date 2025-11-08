import java.sql.ResultSet;
import java.util.Scanner;

public class MortgageCalc {
    public void main () {
        Scanner scanner = new Scanner(System.in); 
            System.out.print("Principal ($1K - $1M): ");
            int principalInput = scanner.nextInt();;
            while (principalInput < 1000 || principalInput > 1000000) {
                System.out.println("Please input the correct amount");
                System.out.print("Principal ($1K - $1M): ");
                principalInput = scanner.nextInt();
            }

            System.out.print("Annual Interest Rate: ");
            double interestInput = scanner.nextDouble();
            while (interestInput < 0 || interestInput > 30) {
                System.out.println("Please input a number from 1 - 30");
                System.out.print("Annual Interest Rate: ");
                interestInput = scanner.nextDouble();
            }

            System.out.print("Period of Years: ");
            byte periodInput = scanner.nextByte();
            while (periodInput < 0 || periodInput > 30) {
                System.out.println("Please input a number from 1 - 30");
                System.out.print("Period of Years: ");
                periodInput = scanner.nextByte();
            }

            double totalMortgage = ((principalInput * (interestInput / 100)) / periodInput);
            System.out.println("Your total mortgage amount is: " + totalMortgage);
                
    }
}