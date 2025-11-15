import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ProductCatalog {
    public ArrayList<Product> products = new ArrayList<>();

    public ProductCatalog(ArrayList<String[]> catalog) {
        // I've tried to do my best to make the catalog stress resistant :)
        boolean isCatalogDefective = false;
        StringBuilder mainMessage = new StringBuilder("""
                В каталоге есть записи с ошибками. Для таких записей были добавлены некоторые обязательные атрибуты со значением по умолчанию.
                Изменения были сделаны для следующих строк:
                """);
        StringBuilder brokenAttributes = new StringBuilder();
        for (int i = 0; i < catalog.size(); i++) {
            boolean isRecordDefective = false;
            //name, description, price, category, addingDate - from String arrayList
            String name = catalog.get(i)[0];
            String description = catalog.get(i)[1];
            BigDecimal price = BigDecimal.ZERO;
            if (catalog.get(i)[2] != null && !catalog.get(i)[2].isBlank()) {
                price = new BigDecimal(catalog.get(i)[2]);
            } else {
                isRecordDefective = true;
                brokenAttributes.append("Цена: ").append(BigDecimal.ZERO).append("; ");
            }
            Category category = Category.UNDEFINED;
            LocalDate addingDate = LocalDate.EPOCH;
            try {
                if (catalog.get(i)[3] != null && !catalog.get(i)[3].isBlank()) {
                    category = Category.valueOf(catalog.get(i)[3].trim());
                } else {
                    isRecordDefective = true;
                    brokenAttributes.append("Категория: ").append(Category.UNDEFINED).append("; ");
                }
                if (catalog.get(i)[4] != null && !catalog.get(i)[4].isBlank()) {
                    addingDate = LocalDate.parse(catalog.get(i)[4].trim());
                } else {
                    isRecordDefective = true;
                    brokenAttributes.append("Дата добавления: ").append(LocalDate.EPOCH).append("; ");
                }
            } catch (DateTimeParseException dtpe) {
                System.out.println("Произошла ошибка! Файл с продуктами имеет неправильный формат данных или порядок атрибутов.\n" +
                        "Ошибка возникла с элементом номер " + (i + 1) +
                        "\nВАЖНО! Пустые строки файла не учитываются в подсчете." +
                        "\nТекст ошибки: " + dtpe.getMessage() + "\n");
            } catch (IllegalArgumentException iae) {
                System.out.println("Произошла ошибка! Файл с продуктами имеет неправильный тип данных.\n" +
                        "Ошибка возникла с элементом номер " + (i+1) +
                        "\nВАЖНО! Пустые строки файла не учитываются в подсчете." +
                        "\nДетали ошибки: " + iae.getMessage() + "\n");
            }
            if (isRecordDefective) {
                isCatalogDefective = true;
                mainMessage.append("Строка номер ").append(i + 1).append(": Добавлены следующие дефолтные атрибуты: ").append(brokenAttributes).append("\n");
                brokenAttributes = new StringBuilder();
            }
            this.products.add(new Product(name, description, price, category, addingDate));
        }

        if (isCatalogDefective) {
            System.out.println(mainMessage);
        }
    }

    public void printProductCard(int productIndex) {
        System.out.println("─".repeat(100) +
                "\nТовар №" + (productIndex + 1) + ": " + products.get(productIndex).name.toUpperCase() +
                "\n     |Описание: " + products.get(productIndex).description +
                "\n     |Цена: " + products.get(productIndex).price + " ₾" +
                "\n     |Категория: " + products.get(productIndex).category.toString().toLowerCase() +
                "\n     |Дата добавления: " + products.get(productIndex).dateOfAdding.toString() +
                "\n" + "─".repeat(100)
        );
    }

    public void showProductCatalog() {
        if (products.isEmpty()) {
            System.out.println("Список товаров пуст\n");
        } else {
            System.out.println("Список всех товаров:");
            for (int i = 0; i < products.size(); i++) {
                printProductCard(i);
            }
        }
    }
}