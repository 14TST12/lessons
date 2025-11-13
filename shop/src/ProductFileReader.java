import java.io.*;
import java.util.ArrayList;

public class ProductFileReader {
    String catalogFilePath = "products.csv";
    File catalogFile = new File(catalogFilePath);

    public static String catalogFileFormatInstruction = """
            -----------------------------------------------------------------------------------------------------
            Csv файл должен содержать атрибуты продуктов разделённые запятой:
            'Имя, Описание, Цена, Категория, Дата добавления'
            Каждый продукт должен начинаться с новой строки. Сами атрибуты не должны содержать запятые и кавычки.
            -----------------------------------------------------------------------------------------------------
            """;

    public ArrayList<String[]> readProducts() {
        int rowCount = 1;
        ArrayList<String[]> catalog = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(catalogFilePath));
            String fileRow;
            StringBuilder rowsWithMistakes = new StringBuilder();
            while ((fileRow = br.readLine()) != null) {
                // name-description-category-price-addingDate
                if (!fileRow.isEmpty()) {
                    String[] rowArray = fileRow.split(",");
                    if(rowArray.length > 0) {
                        String name = rowArray[0].trim();
                        String description = (rowArray.length > 1) ? rowArray[1].trim() : "";
                        String category = (rowArray.length > 2) ? rowArray[2].trim() : null;
                        String price = (rowArray.length > 3) ? rowArray[3].trim() : null;
                        String addingDate = (rowArray.length > 4) ? rowArray[4].trim() : null;
                        catalog.add(new String[]{name, description, price, category, addingDate});
                    }
                    if (rowArray.length != 5) {
                        rowsWithMistakes.append(rowCount).append(" ");
                    }
                    rowCount++;
                }
            }
            if (!rowsWithMistakes.isEmpty()) {
                System.out.println("Внимание! Некоторые строки имеют лишние атрибуты или их не хватает. " +
                        "Возможны ошибки при заполнении каталога! Пожалуйста, перепроверьте файл " + catalogFilePath +
                        "\nПроблемы есть в строках:" + rowsWithMistakes + "\n" +
                        catalogFileFormatInstruction);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Упс! Кажется файла с продуктами не существует или он находится в неправильной папке.\n" +
                    "Файл каталога должен находиться в корневой папке проекта shop " + catalogFilePath +
                    "\nКаталог будет пустым, а новые записи каталога утеряются после перезапуска приложения\n" +
                    catalogFileFormatInstruction);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Произошла ошибка! В каталоге имеются неполные строки\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nДальше каталог не был прочитан и обработан. Пожалуйста, исправьте файл " + catalogFilePath +
                    "\nТекст ошибки: " + aioobe.getMessage() + "\n" +
                    catalogFileFormatInstruction);
        } catch (NumberFormatException nfe) {
            System.out.println("Произошла ошибка! Файл с продуктами имеет неправильный формат данных или порядок атрибутов.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nТекст ошибки: " + nfe.getMessage() + "\n" +
                    catalogFileFormatInstruction);
        } catch (IllegalArgumentException iae) {
            System.out.println("Произошла ошибка! Файл с продуктами имеет неправильный тип данных.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nДетали ошибки: " + iae.getMessage() + "\n" +
                    catalogFileFormatInstruction);
        } catch (java.io.IOException ioe) {
            System.out.println("Произошла ошибка! Файл с продуктами имеет неправильную структуру данных.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nТекст ошибки: " + ioe.getMessage() + "\n" +
                    catalogFileFormatInstruction);
        }
        return catalog;
    }
}
