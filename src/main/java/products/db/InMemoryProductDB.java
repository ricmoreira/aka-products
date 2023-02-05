package products.db;

import org.springframework.stereotype.Component;
import products.model.Product;
import products.model.ProductUpdate;

import java.util.HashMap;
import java.util.List;

// Our In Memory DB
@Component
public class InMemoryProductDB implements DBInterface<Product> {
    private final HashMap<String, Product> products;

    public InMemoryProductDB(){
        this.products = new HashMap<>();
        seedProducts();
    }

    @Override
    public String insert(Product product) {
        this.products.put(product.getId(), product);
        return product.getId();
    }

    @Override
    public Product getOne(String id) throws Exception {
        if(this.products.containsKey(id)){
            return this.products.get(id);
        }
        throw new Exception("Product with id " + id + " not found");
    }

    @Override
    public List<Product> getAll() {
        return this.products.values().stream().toList();
    }

    @Override
    public Product update(String id, Object productUpdateDto) throws Exception {
        if(!this.products.containsKey(id)) throw new Exception("Product with id " + id + " does not exist");

        ProductUpdate productData = (ProductUpdate)productUpdateDto;

        Product productUpdated = new Product(id, productData.getName(), productData.getPrice());
        this.products.put(id, productUpdated);
        return productUpdated;
    }

    @Override
    public String delete(String id) throws Exception{
        if(!this.products.containsKey(id)) throw new Exception("Product with id " + id + " does not exist");
        this.products.remove(id);
        return id;
    }

    private void seedProducts(){
        this.products.put("1", new Product("1", "Product 1", 1.00));
        this.products.put("2", new Product("2", "Product 2", 2.00));
        this.products.put("3", new Product("3", "Product 3", 3.00));
    }
}
