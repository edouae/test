import eheio.ma.entity.Product;
import eheio.ma.Service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductServiceTest {
    private Product product;
    private ProductService productService;

    @Before
    public void setUp() {
        product = new Product("Laptop", 1500.0f, 10);
        productService = new ProductService(product);
    }

    @After
    public void tearDown() {
        // Clean up resources after each test
        product = null;
        productService = null;
    }

    @Test
    public void testApplyPromotion() {
        productService.applyPromotion(20);
        assertEquals(1200.0f, productService.getProduct().getPrice(), 0.01f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApplyInvalidPromotion() {
        productService.applyPromotion(-10);
    }

    @Test
    public void testUpdatePrice() {
        productService.updatePrice(1000.0f);
        assertEquals(1000.0f, productService.getProduct().getPrice(), 0.01f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateInvalidPrice() {
        productService.updatePrice(-500.0f);
    }

    @Test
    public void testRestock() {
        productService.restock(5);
        assertEquals(5, productService.getProduct().isStock());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestockInvalidQuantity() {
        productService.restock(-5);
    }

    @Test
    public void testIsInStock() {
        assertTrue(!productService.isInStock());
    }

    @Test
    public void testIsOutOfStock() {
        product.setStock(0);
        assertFalse(productService.isInStock());
    }


}
