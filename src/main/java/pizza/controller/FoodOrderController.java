package pizza.controller;

import lombok.Data;
import pizza.entities.FoodOrder;
import pizza.entities.OrderItem;
import pizza.entities.Product;
import pizza.services.FoodOrderService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by maart on 15-11-2016.
 */
@Data
@Named
@SessionScoped
@ManagedBean
public class FoodOrderController implements Serializable{

    private FoodOrder foodOrder;

    @EJB
    private FoodOrderService service;

    public FoodOrderController(){
        foodOrder = new FoodOrder();
    }

    public void addOrderItem(Product product){
        foodOrder.addProduct(product);
    }

    public void removeOrderItem(Product product){
        foodOrder.removeProduct(product);
    }

    public void saveFoodOrder(){
        service.save(foodOrder);
    }

    public float calculateTotalPrice(){
        float result = 0F;
        for (OrderItem item: foodOrder.getOrderItems()){
            result += item.getSubTotal();
        }
        return result;
    }

}
