package homework2;

import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {


    public static void main(String[] args) {
        Float num = enterNumber();
        System.out.println("Number entered: " + num);
    }

    public static Float enterNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter float number: ");
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("This is not a float number. Please enter number: ");
            }
        }
    }

}
