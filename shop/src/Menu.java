import java.io.IOException;
import java.time.LocalDate;

public class Menu {
    // initializing everything
    ValueValidator validator = new ValueValidator();
    ProductCreator creator = new ProductCreator();
    ProductFileReader productFile = new ProductFileReader();
    ProductFileWriter productFileWriter = new ProductFileWriter();
    ProductCatalog catalog = new ProductCatalog(productFile.readProducts());
    LogFileReader logFileReader = new LogFileReader();
    LogFileWriter logFileWriter = new LogFileWriter();
    LogArchive logArchive = new LogArchive(logFileReader.readLogs());

    public void useMenu() {
        while (true) {
            switch (showMenu()) {
                case 1: {
                    // 1. Показать все товары;
                    catalog.showProductCatalog();
                    break;
                }
                case 2: {
                    // 2. Создать продукт;
                    try {
                        Product newProduct = creator.createProduct();
                        productFileWriter.saveProducts(newProduct, !catalog.products.isEmpty());
                        catalog.products.add(newProduct);
                    } catch (IOException ioe) {
                        System.out.println("Произошла ошибка! Каким-то чудом я пропустил IOException при обычной валидации, хотя я думал, что это уже невозможно.\n" +
                                "Введённые параметры продукта не соответствуют формату файла.\n" +
                                "Пожалуйста, перепроверьте данные в файле: " + productFile.catalogFilePath + "\n" +
                                ProductFileReader.catalogFileFormatInstruction);
                        System.out.println("Текст ошибки:\n" + ioe.getMessage());
                    }
                    break;
                }
                case 3: {
                    // 3. Купить товар;
                    catalog.showProductCatalog();
                    System.out.println("Выберите номер товара для покупки:");
                    // item shown number in catalog = index + 1. So, index equals item chosen number minus 1
                    int buyProductIndex = validator.readIntFromConsole(catalog.products.size(), false) - 1;
                    try {
                        LogRecord logRecord = new LogRecord
                                (catalog.products.get(buyProductIndex).name, catalog.products.get(buyProductIndex).category, catalog.products.get(buyProductIndex).price, LocalDate.now());
                        logFileWriter.saveLogs(logRecord, !logArchive.logEntries.isEmpty());
                        logArchive.logEntries.add(logRecord);
                        catalog.products.remove(buyProductIndex);
                        productFileWriter.rewriteProductCatalog(catalog.products);
                        System.out.println("Товар был успешно куплен. Поздравляем!");
                    } catch (IOException ioe) {
                        System.out.println("Произошла ошибка! Каким-то чудом я пропустил IOException при обычной валидации, хотя я думал, что это уже невозможно.\n" +
                                "Введённые параметры продукта не соответствуют формату файла.\n" +
                                "Пожалуйста, перепроверьте данные в файле: " + logFileReader.logFilePath + "\n" +
                                LogFileReader.logFileFormatInstruction);
                        System.out.println("Текст ошибки:\n" + ioe.getMessage());
                    }
                    break;
                }
                case 4: {
                    // 4. Показать логи;
                    logArchive.showLogArchive();
                    break;
                }
                case 0: {
                    // 0. Выйти из приложения.
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

    public int showMenu() {
        System.out.println("""
                \n===== ГЛАВНОЕ МЕНЮ =====
                1. Показать все товары;
                2. Создать продукт;
                3. Купить товар;
                4. Показать логи;
                0. Выйти из приложения.
                """);
        return validator.readIntFromConsole(4, true);
    }
}