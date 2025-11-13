import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class ProductCreator {
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название товара. Название не должно содержать запятые и кавычки иначе они будут удалены:");
        String name = sc.nextLine();
        name = name.replaceAll("[,\"]", " ");
        System.out.println("Введите описание товара. Описание не должно содержать запятые и кавычки иначе они будут удалены:");
        String description = sc.nextLine();
        description = description.replaceAll("[,\"]", " ");
        ValueValidator validator = new ValueValidator();
        BigDecimal price = validator.receivePrice();
        System.out.println("""
                Выберите категорию товара из предложенных:
                1. Электроника;
                2. Мебель;
                3. Аксессуары.""");
        int categoryType = validator.readIntFromConsole(3, false);
        Category category = Category.UNDEFINED;
        switch (categoryType) {
            case 1: {
                category = Category.ELECTRONICS;
                break;
            }
            case 2: {
                category = Category.FURNITURE;
                break;
            }
            case 3: {
                category = Category.ACCESSORIES;
                break;
            }
        }
        System.out.println("Продукт был добавлен в список товаров!");
        return new Product(name, description, price, category, LocalDate.now());
    }
}
