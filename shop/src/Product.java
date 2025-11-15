import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    String name;
    String description;
    BigDecimal price;
    Category category;
    LocalDate  dateOfAdding;

    public Product(String name, String description, BigDecimal price, Category category, LocalDate dateOfAdding) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.dateOfAdding = dateOfAdding;
    }
}