import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class LogArchive {
    public ArrayList<LogRecord> logEntries = new ArrayList<>();

    public LogArchive(ArrayList<String[]> logEntries) {
        for (String[] logRecord : logEntries) {
            this.logEntries.add(new LogRecord(logRecord[0], Category.valueOf(logRecord[1]), new BigDecimal(logRecord[2]), LocalDate.parse(logRecord[3])));
        }
    }

    public void showLogArchive () {
        if (logEntries.isEmpty()) {
            System.out.println("Логи пустые\n");
        } else {
            System.out.println("Список всех логов:");
            for (int i = 0; i < logEntries.size(); i++) {
                printLogEntry(i);
            }
        }
    }

    public void printLogEntry(int logIndex) {
        System.out.println("─".repeat(100) +
                "\nТовар №" + (logIndex + 1) + ": " + logEntries.get(logIndex).name.toUpperCase() +
                "\n     |Категория: " + logEntries.get(logIndex).category.toString().toLowerCase() +
                "\n     |Цена: " + logEntries.get(logIndex).price + " ₾" +
                "\n     |Дата продажи: " + logEntries.get(logIndex).dateOfSale +
                "\n" + "─".repeat(100)
        );
    }
}
