import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ValueValidator validator = new ValueValidator();
        ProductCreator creator = new ProductCreator();
        FileUtil file = new FileUtil();
        ProductCatalog catalog = new ProductCatalog(file.readProducts());
        while (true) {
            menu.showMenu();
            int menuOption = validator.readIntFromConsole(2, true);
            switch (menuOption) {
                case 1: {
                    if (catalog.products.isEmpty()) {
                        System.out.println("Список товаров пуст\n");
                    } else {
                        System.out.println("Список всех товаров:");
                        for (int i = 0; i < catalog.products.size(); i++) {
                            catalog.printProductCard(i);
                        }
                    }
                    break;
                }
                case 2: {
                    try {
                        Product newProduct = creator.createProduct();
                        file.saveProducts(newProduct);
                        catalog.products.add(newProduct);
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
}