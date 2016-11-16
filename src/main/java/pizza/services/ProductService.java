package pizza.services;

import pizza.entities.Product;

import java.util.List;

/**
 * Created by maart on 15-11-2016.
 */
public interface ProductService{

    Product save(Product prod);

    List<Product> getAllProducts();
}
