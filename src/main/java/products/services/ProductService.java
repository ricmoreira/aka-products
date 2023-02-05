package products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.model.Product;
import products.model.ProductUpdate;
import products.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public String insert(Product product){
        return productRepository.insert(product);
    }

    public String delete(String id) throws Exception {
        return productRepository.delete(id);
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Product getOne(String id) throws Exception {
        return productRepository.getOne(id);
    }

    public Product update(String id, ProductUpdate productUpdateDTO) throws Exception {
        return productRepository.update(id, productUpdateDTO);
    }
}
