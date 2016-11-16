package pizza.services;

import pizza.entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by maart on 15-11-2016.
 */
@Stateless
public class ProductServiceImpl implements ProductService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product save(Product prod) {
        em.persist(prod);
        return prod;
    }

    @Override
    public List<Product> getAllProducts(){
        Query query = em.createNamedQuery("getAllProducts");
        return query.getResultList();
    }

}
