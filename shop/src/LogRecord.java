import java.math.BigDecimal;
import java.time.LocalDate;

public class LogRecord {
    String name;
    Category category;
    BigDecimal price;
    LocalDate dateOfSale;

    public LogRecord(String name, Category category, BigDecimal price, LocalDate dateOfSale) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.dateOfSale = dateOfSale;
    }
}
