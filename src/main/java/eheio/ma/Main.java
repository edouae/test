package eheio.ma;

import eheio.ma.entity.Product;
import eheio.ma.Service.ProductService;

import java.util.TreeSet;

record person(int age, String name) { }


public class Main implements Cloneable {
    public static void main(String[] args) {
        TreeSet<person> persons = new TreeSet<>();


          Product product = new Product("Laptop", 1500.0f, 10);
          Product product2 = product.clone();
          Product product3 = product2.clone();

          System.out.println(product2);
          System.out.println(product3);
//
//        ProductService productService = new ProductService(product);
//
//        System.out.println("Initial Product Details:");
//        System.out.println(productService.displayProductDetails());
//
//        System.out.println("Applying a 20% promotion...");
//        productService.applyPromotion(20);
//
//        System.out.println("Product Details After Promotion:");
//        System.out.println(productService.displayProductDetails());
//
//        System.out.println("Restocking product by 5 units...");
//        productService.restock(5);
//
//        System.out.println("Product Details After Restocking:");
//        System.out.println(productService.displayProductDetails());
//
//        if (productService.isInStock()) {
//            System.out.println("The product is in stock.");
//        } else {
//            System.out.println("The product is out of stock.");
//        }
//
//        System.out.println("Updating the product price to 1200...");
//        productService.updatePrice(1200);
//
//        System.out.println("Final Product Details:");
//        System.out.println(productService.displayProductDetails());
    }
}
