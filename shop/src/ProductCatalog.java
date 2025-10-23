import java.util.ArrayList;

public class ProductCatalog {
    public ArrayList<Product> products = new ArrayList<>();

    public ProductCatalog(ArrayList<String[]> catalog) {
        for (String[] product : catalog) {
            this.products.add(new Product(product[0], product[1], Double.parseDouble(product[3]), Category.valueOf(product[2])));
        }
    }

    public void printProductCard(int productIndex) {
        System.out.println("─".repeat(100) +
                "\nТовар №" + (productIndex + 1) + ": " + products.get(productIndex).name.toUpperCase() +
                "\n     |Описание: " + products.get(productIndex).description +
                "\n     |Цена: " + products.get(productIndex).price + " ₾" +
                "\n     |Категория: " + products.get(productIndex).category.toString().toLowerCase() +
                "\n" + "─".repeat(100)
        );
    }
}