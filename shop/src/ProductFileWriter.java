import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductFileWriter {
    ProductFileReader pfu = new ProductFileReader();

    public void saveProducts(Product product, boolean append) throws IOException {

        if (pfu.catalogFile.exists()) {
            StringBuilder sb = new StringBuilder();
            BufferedWriter bw = new BufferedWriter(new FileWriter(pfu.catalogFile, append));
            if (append) sb.append("\n");
            sb.append(product.name).append(",").append(product.description).append(",").append(product.category).append(",").append(product.price).append(",").append(product.dateOfAdding);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } else {
            System.out.println("\nУпс! Кажется файла с продуктами не существует или он находится в неправильной папке. " +
                    "Файл каталога должен находиться в корневой папке проекта shop:"
                    + pfu.catalogFilePath +
                    "При создании нового продукта, продукт будет добавлен в список товаров, НО записи утеряются при перезапуске приложения");
        }
    }

    public void rewriteProductCatalog(ArrayList<Product> products) throws IOException {
        if (pfu.catalogFile.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(pfu.catalogFile, false));
            StringBuilder sb = new StringBuilder();
            for (Product product : products) {
                if (!sb.isEmpty()) {
                    sb.append("\n");
                }
                sb.append(product.name).append(",").append(product.description).append(",").append(product.category).append(",").append(product.price).append(",").append(product.dateOfAdding);
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } else {
            System.out.println("Упс! Кажется файла с логами не существует или он находится в неправильной папке. Файл каталога должен находиться в корневой папке проекта shop "
                    + pfu.catalogFilePath +
                    "\nПри создании нового лога, запись добавится в массив," +
                    "\nНО записи утеряются при перезапуске приложения");
        }
    }
}
