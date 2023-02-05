package products.controllers;

import products.model.Product;
import products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "name 1", 1.00));
        products.add(new Product("id2", "name 1", 1.00));
        products.add(new Product("id3", "name 1", 1.00));

        return products;
      //  return productService.list();
    }

    @GetMapping("/one")
    public Product getOneProduct(){
        return productService.getOne();
    }

    @PostMapping()
    public Product createProducts(@RequestBody Product product){
        return product;
    }

    @PutMapping()
    public Product updateProducts(@PathVariable String id, @RequestBody Product product){
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProducts(@PathVariable String id){

        return "deleted product";
    }

}
