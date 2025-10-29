import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public static String fileFormatInstruction = """
            -----------------------------------------------------------------------------------------------------
            Csv файл должен содержать атрибуты продуктов разделённые запятой:
            'Имя, Описание, Цена, Категория'
            Каждый продукт должен начинаться с новой строки. Сами атрибуты не должны содержать запятые и кавычки.
            -----------------------------------------------------------------------------------------------------
            """;

    public void saveProducts(Product product) throws IOException {
        File catalogFile = new File("products.csv");
        if (catalogFile.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(catalogFile, true));
            bw.write("\n" + product.name + "," + product.description + "," + product.category + "," + product.price);
            bw.flush();
            bw.close();
        } else {
            System.out.println("""

                    Упс! Кажется файла с продуктами не существует или он находится в неправильной папке. Файл products.csv должен находиться в корневой папке проекта shop
                    При создании нового продукта, продукт будет добавлен в список товаров,
                    НО записи утеряются при перезапуске приложения""");
        }
    }

    public ArrayList<String[]> readProducts() {
        int rowCount = 1;
        ArrayList<String[]> catalog = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("products.csv"));
            String str;
            String rowsWithMistakes = "";
            while ((str = br.readLine()) != null) {
                String[] row = str.split(",");
                catalog.add(row);
                if (row.length != 4) {
                    rowsWithMistakes = rowsWithMistakes + " " + rowCount;
                }
                rowCount++;
            }
            if (!rowsWithMistakes.isEmpty()) {
                System.out.println("Внимание! Некоторые строки имеют лишние атрибуты. Возможны ошибки при заполнении каталога! Пожалуйста, перепроверьте файл products.csv\n" +
                        "Проблемы есть в строках:" + rowsWithMistakes + "\n" +
                        fileFormatInstruction);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Упс! Кажется файла с продуктами не существует или он находится в неправильной папке.\n" +
                    "Файл products.csv должен находиться в корневой папке проекта shop\n" +
                    "Каталог будет пустым, а новые записи каталога утеряются после перезапуска приложения\n" +
                    fileFormatInstruction);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Произошла ошибка! В каталоге имеются неполные строки\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nДальше каталог не был прочитан и обработан. Пожалуйста, исправьте файл products.csv" +
                    "\nТекст ошибки: " + aioobe.getMessage() + "\n" +
                    fileFormatInstruction);
        } catch (NumberFormatException nfe) {
            System.out.println("Произошла ошибка! Файл с продуктами имеет неправильный формат данных или порядок атрибутов.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nТекст ошибки: " + nfe.getMessage() + "\n" +
                    fileFormatInstruction);
        } catch (IllegalArgumentException iae) {
            System.out.println("Произошла ошибка! Файл с продуктами имеет неправильный тип данных.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nДетали ошибки: " + iae.getMessage() + "\n" +
                    fileFormatInstruction);
        } catch (java.io.IOException ioe) {
            System.out.println("Произошла ошибка! Файл с продуктами имеет неправильную структуру данных.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nТекст ошибки: " + ioe.getMessage() + "\n" +
                    fileFormatInstruction);
        }
        return catalog;
    }
}
