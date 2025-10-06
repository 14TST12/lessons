import java.util.Scanner;

public class Menu {
    public int showMenu() {
        System.out.println("""
                \n===== ГЛАВНОЕ МЕНЮ =====
                1. Показать все товары;
                2. Создать продукт;
                0. Выйти из приложения.
                """);
        return Menu.readIntFromConsole(2, true);
    }

    public static int readIntFromConsole(int limit, boolean isZeroAllowed) {
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

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название товара:");
        String name = sc.nextLine();
        System.out.println("Введите описание товара:");
        String description = sc.nextLine();
        // Added validation for price double value
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
        System.out.println("""
                Выберите категорию товара из предложенных:
                1. Электроника;
                2. Мебель;
                3. Аксессуары.""");
        int categoryType = readIntFromConsole(3, false);
        Category category = null;
        switch (categoryType) {
            case 1: {
                category = Category.ELECTRONICS;
                break;
            }
            case 2: {
                category = Category.FURNITURE;
                break;
            }
            case 3: {
                category = Category.ACCESSORIES;
                break;
            }
        }
        System.out.println("Продукт был добавлен в список товаров!");
        return new Product(name, description, price, category);
    }

}