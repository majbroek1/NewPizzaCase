package pizza.services;

import pizza.entities.FoodOrder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by maart on 15-11-2016.
 */
@Stateless
public class FoodOrderServiceImpl implements FoodOrderService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public FoodOrder save(FoodOrder foodOrder) {
        em.persist(foodOrder);
        return foodOrder;
    }
}
