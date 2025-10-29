import java.util.Scanner;

public class ValueValidator {

    // Moved value validations to separate class as it was agreed in previous task
    public int readIntFromConsole(int limit, boolean isZeroAllowed) {
        Scanner sc = new Scanner(System.in);
        int chosenOption;
        do {
            if (sc.hasNextInt()) {
                chosenOption = sc.nextInt();
                if (chosenOption < 0) {
                    System.out.println("Ошибка: Введённое значение должно быть больше нуля! Введите заново:");
                } else if (!isZeroAllowed && chosenOption <= 0) {
                    System.out.println("Ошибка: Введённое значение должно быть не меньше нуля! Введите заново:");
                } else if (chosenOption > limit) {
                    System.out.println("Ошибка: Введённое значение не может быть больше " + limit + "! Введите заново:");
                } else {
                    // if all is fine. Then - break the loop and return entered value
                    break;
                }
            } else {
                System.out.println("Ошибка: Вы ввели неверный формат значения! Введите число: ");
                sc.next();
            }
        }
        while (true);
        return chosenOption;
    }

    public double receivePrice() {
        Scanner sc = new Scanner(System.in);
        double price = 0;
        boolean isPriceValid = false;
        while (!isPriceValid) {
            System.out.println("Введите цену. Цена может быть дробным значением (с разделителем ','):");
            if (sc.hasNextDouble()) {
                price = sc.nextDouble();
                if (price >= 0) {
                    isPriceValid = true;
                } else {
                    System.out.println("Ошибка: Цена не может быть отрицательной.");
                }
            } else {
                System.out.println("Ошибка: Неверный формат! Цена должна быть числом.");
                sc.next();
            }
        }
        sc.nextLine();
        return price;
    }
}
