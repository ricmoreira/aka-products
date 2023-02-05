package products.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import products.db.DBInterface;
import products.model.Product;
import products.model.ProductUpdate;

import java.util.List;

@Repository
public class ProductRepository {

    private final DBInterface inMemoryProductDB;

    @Autowired
    public ProductRepository(DBInterface inMemoryProductDB){
        this.inMemoryProductDB = inMemoryProductDB;
    }

    public String insert(Product product){
        return inMemoryProductDB.insert(product);
    }

    public String delete(String id) throws Exception{
        return inMemoryProductDB.delete(id);
    }

    public Product update(String id, ProductUpdate productUpdateDTO) throws Exception{
        return (Product)inMemoryProductDB.update(id, productUpdateDTO);
    }

    public Product getOne(String id) throws Exception{
        return (Product)inMemoryProductDB.getOne(id);
    }

    public List<Product> getAll(){
        return inMemoryProductDB.getAll();
    }
}
