import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Application {


    private static ArrayList<Product> products;

    // Note: some records were added to file during code testing
    static {
        products = FileUtil.readProducts();
    }

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
                    try {
                        Product newProduct = menu.createProduct();
                        FileUtil.saveProducts(newProduct);
                        products.add(newProduct);
                    } catch (IOException ioe) {
                        System.out.println("Произошла ошибка! Каким-то чудом я пропустил IOException при обычной валидации, хотя я думал, что это уже невозможно. Введённые параметры продукта не соответствуют формату файла.\n" +
                                "Пожалуйста, перепроверьте данные в файле products.csv.\n" +
                                FileUtil.fileFormatInstruction);
                        System.out.println("Текст ошибки:\n" + ioe.getMessage());
                    }
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
                "\n" + "─".repeat(100)
        );
    }
}