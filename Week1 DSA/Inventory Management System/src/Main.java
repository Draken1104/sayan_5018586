//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Map;

class Product {
    private final String productId;
    private final String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class Inventory {
    private final Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product ID " + product.getProductId() + " already exists. Use updateProduct to update it.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added: " + product);
        }
    }

    public void updateProduct(String productId, int quantity, double price) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            Product removedProduct = products.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        }
        else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product("001", "Laptop", 10, 999.99);
        Product product2 = new Product("002", "Smartphone", 20, 499.99);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.displayProducts();

        inventory.updateProduct("001", 15, 1099.99);
        inventory.displayProducts();

        inventory.deleteProduct("002");
        inventory.displayProducts();
    }
}