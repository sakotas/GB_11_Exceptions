package homework2;

/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        String UserInput = scannerInput();
        System.out.println("Info: " + UserInput);
    }

    public static String scannerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter info: ");
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Exception();
                }
                return input;

            } catch (Exception e) {
                System.out.println("Input must not be empty, please enter info: ");
            }
        }
    }
}
