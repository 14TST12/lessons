import java.util.*;

public class Application {

    private static ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product("Laptop", "Gaming Laptop", 1000, Category.ELECTRONICS),
            new Product("Laptop", "Office Laptop", 500, Category.ELECTRONICS),
            new Product("Chair", "Office Chair", 60, Category.FURNITURE),
            new Product("Screen Protector", "Screen Protector for monitors and laptops", 60, Category.ACCESSORIES)
    ));

    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            int menuOption = menu.showMenu();
            switch (menuOption) {
                case 1: {
                    if (products.isEmpty()) {
                        System.out.println("Список товаров пуст\n");
                    } else {
                        System.out.println("Список всех товаров:");
                        for (int i = 0; i < products.size(); i++) {
                            printProductCard(i);
                        }
                    }
                    break;
                }
                case 2: {
                    Product newProduct = menu.createProduct();
                    products.add(newProduct);
                    break;
                }
                case 0: {
                    System.out.println("Закрываем приложение. Пока!");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Ошибка: Вы ввели невалидную опцию меню. Выберите заново!");
                }
            }
        }
    }

    private static void printProductCard(int productIndex) {
        System.out.println("─".repeat(100) +
                "\nТовар №" + (productIndex + 1) + ": " + products.get(productIndex).name.toUpperCase() +
                "\n     |Описание: " + products.get(productIndex).description +
                "\n     |Цена: " + products.get(productIndex).price + " ₾" +
                "\n     |Категория: " + products.get(productIndex).category.toString().toLowerCase() +
                "\n" +"─".repeat(100)
        );
    }
}