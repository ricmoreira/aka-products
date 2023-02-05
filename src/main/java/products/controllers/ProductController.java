package products.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import products.model.Product;
import products.model.ProductUpdate;
import products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService){
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String insert(@RequestBody Product product){
        return this.productService.insert(product);
    }

    @DeleteMapping("/{id}")
    public String delete(HttpServletResponse servletResponse, @PathVariable String id){
        try {
            return productService.delete(id);
        } catch (Exception e) {
            servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

    }

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getOne(HttpServletResponse servletResponse, @PathVariable String id){
        try {
            return productService.getOne(id);
        } catch (Exception e) {
            servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }

    @PutMapping("/{id}")
    public Product update(HttpServletResponse servletResponse, @PathVariable String id, @RequestBody ProductUpdate productUpdateDTO){
        try {
            return productService.update(id, productUpdateDTO);
        } catch (Exception e) {
            servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }
}
