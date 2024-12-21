package eheio.ma.Service;

import eheio.ma.entity.Product;

public class ProductService {
    private Product product;

    public ProductService(Product product) {
        this.product = product;
    }

    // Calculate promotion as a percentage discount on the product's price
    private float promotion(float discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        float discountAmount = (product.getPrice() * discountPercentage) / 100;
        return product.getPrice() - discountAmount;
    }

    // Update the price of the product
    public void updatePrice(float newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        product.setPrice(newPrice);
    }

    // Check if the product is in stock
    public boolean isInStock() {
        return product.isStock() > 0;
    }

    // Restock the product by adding more quantity
    public void restock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        product.setStock(product.isStock() + quantity);
    }

    // Apply a promotion and update the product price
    public void applyPromotion(float discountPercentage) {
        float newPrice = promotion(discountPercentage);
        updatePrice(newPrice);
    }

    // Display product details
    public String displayProductDetails() {
        return String.format(
                "Product Name: %s\nPrice: %.2f\nStock: %d\n",
                product.getName(),
                product.getPrice(),
                product.isStock()
        );
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
