//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Product Name: " + productName + ", Category: " + category;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }
}

public class ECommercePlatform {

    // Linear search to find a product by productName
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search to find a product by productName
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Phone", "Electronics"),
                new Product(3, "Shirt", "Apparel"),
                new Product(4, "Shoes", "Footwear"),
                new Product(5, "Watch", "Accessories")
        };

        // Sort products array for binary search
        Arrays.sort(products);

        // Linear search
        System.out.println("Linear Search:");
        Product linearResult = linearSearch(products, "Phone");
        if (linearResult != null) {
            System.out.println("Found: " + linearResult);
        } else {
            System.out.println("Product not found.");
        }

        // Binary search
        System.out.println("\nBinary Search:");
        Product binaryResult = binarySearch(products, "Phone");
        if (binaryResult != null) {
            System.out.println("Found: " + binaryResult);
        } else {
            System.out.println("Product not found.");
        }
    }
}
