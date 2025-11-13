import java.io.*;
import java.util.ArrayList;

public class LogFileReader {
    String logFilePath = "logs.csv";
    public static String logFileFormatInstruction = """
            -----------------------------------------------------------------------------------------------------
            Csv файл должен содержать атрибуты продуктов разделённые запятой:
            'Название товара, Категория товара, Цена, Дата продажи'
            Каждый лог должен начинаться с новой строки. Сами атрибуты не должны содержать запятые и кавычки.
            -----------------------------------------------------------------------------------------------------
            """;

    public ArrayList<String[]> readLogs() {
        int rowCount = 1;
        ArrayList<String[]> logEntry = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(logFilePath));
            String fileRow;
            StringBuilder rowsWithMistakes = new StringBuilder();
            while ((fileRow = br.readLine()) != null) {
                if (!fileRow.isEmpty()) {
                    String[] rowArray = fileRow.split(",");
                    String name = (rowArray.length > 0) ? rowArray[0].trim() : null;
                    String description = (rowArray.length > 1) ? rowArray[1].trim() : null;
                    String category = (rowArray.length > 2) ? rowArray[2].trim() : null;
                    String price = (rowArray.length > 3) ? rowArray[3].trim() : null;
                    String addingDate = (rowArray.length > 4) ? rowArray[4].trim() : null;
                    logEntry.add(new String[]{name, description, category, price, addingDate});
                    if (rowArray.length != 4) {
                        rowsWithMistakes.append(rowCount).append(" ");
                    }
                    rowCount++;
                }
            }
            if (!rowsWithMistakes.isEmpty()) {
                System.out.println("Внимание! Некоторые строки имеют лишние атрибуты. Возможны ошибки при заполнении лог архива! Пожалуйста, перепроверьте файл " + logFilePath +
                        "Проблемы есть в строках:" + rowsWithMistakes + "\n" +
                        logFileFormatInstruction);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Упс! Кажется файла с логами не существует или он находится в неправильной папке.\n" +
                    "Файл журнала должен находиться в корневой папке проекта shop: " + logFilePath +
                    "\nЛог архив будет пустым, а новые записи лога утеряются после перезапуска приложения\n" +
                    logFileFormatInstruction);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Произошла ошибка! В логах имеются неполные строки\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nДальше логи не был прочитаны и обработаны. Пожалуйста, исправьте файл " + logFilePath +
                    "\nТекст ошибки: " + aioobe.getMessage() + "\n" +
                    logFileFormatInstruction);
        } catch (NumberFormatException nfe) {
            System.out.println("Произошла ошибка! Файл с логами имеет неправильный формат данных или порядок атрибутов.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nТекст ошибки: " + nfe.getMessage() + "\n" +
                    logFileFormatInstruction);
        } catch (IllegalArgumentException iae) {
            System.out.println("Произошла ошибка! Файл с логами имеет неправильный тип данных.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nДетали ошибки: " + iae.getMessage() + "\n" +
                    logFileFormatInstruction);
        } catch (java.io.IOException ioe) {
            System.out.println("Произошла ошибка! Файл с логами имеет неправильную структуру данных.\n" +
                    "Ошибка возникла на строке " + rowCount +
                    "\nТекст ошибки: " + ioe.getMessage() + "\n" +
                    logFileFormatInstruction);
        }
        return logEntry;
    }
}