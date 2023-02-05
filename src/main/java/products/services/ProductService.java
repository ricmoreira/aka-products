package products.services;

import org.springframework.stereotype.Service;
import products.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Value("${product.id}")
    private String defaultProductID;
    @Value("${product.name}")
    private String defaultProductName;
    @Value("${product.price}")
    private double defaultProductPrice;

    public List<Product> list(){
        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product("1", "Product 1", 1.00));
        productsList.add(new Product("2", "Product 2", 2.00));
        return productsList;
    }

    public Product getOne(){
        return new Product(defaultProductID, defaultProductName, defaultProductPrice);
    }
}
