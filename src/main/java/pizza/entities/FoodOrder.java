package pizza.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by maart on 15-11-2016.
 */
@Entity
@Data
@AllArgsConstructor
public class FoodOrder{

    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
    private List<OrderItem> orderItems;

    public FoodOrder(){
        orderItems = new ArrayList<>();
    }

    public float getTotalPrice(){
        float result = 0F;
        for (OrderItem item: orderItems){
            result += item.getSubTotal();
        }
        return result;
    }

    public void addProduct(Product product){
        Iterator<OrderItem> itemIterator = orderItems.iterator();
        boolean found = false;
        while (itemIterator.hasNext()){
            OrderItem item = itemIterator.next();
            if( item.getProduct().equals(product)){
                found = true;
                item.addItem();
            }
        }
        if (!found){
            orderItems.add(new OrderItem(product));
        }
    }

    public void removeProduct(Product product){
        Iterator<OrderItem> itemIterator = orderItems.iterator();
        while(itemIterator.hasNext()){
            OrderItem item = itemIterator.next();
            if (item.getProduct().equals(product)){
                if (item.getQuantity() > 1){
                    item.removeItem();
                }
                else{
                    itemIterator.remove();
                }
            }
        }
    }
    
}
