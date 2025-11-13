import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileWriter {
    LogFileReader lfr = new LogFileReader();

    public void saveLogs(LogRecord logRecord, boolean append) throws IOException {
        File logFile = new File(lfr.logFilePath);
        if (logFile.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, append));
            StringBuilder sb = new StringBuilder();
            if (append) sb.append("\n");
            sb.append(logRecord.name).append(",").append(logRecord.category).append(",").append(logRecord.price).append(",").append(logRecord.dateOfSale);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } else {
            System.out.println("\n Упс! Кажется файла с журналом не существует или он находится в неправильной папке. " +
                    "Файл журнала должен находиться в корневой папке проекта shop: " + lfr.logFilePath);
        }
    }
}
