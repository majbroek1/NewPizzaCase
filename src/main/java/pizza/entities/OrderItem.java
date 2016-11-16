package pizza.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by maart on 15-11-2016.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private int quantity;

    @ManyToMany(mappedBy = "orderItems")
    private Collection<FoodOrder> foodOrders;

    public OrderItem(Product product){
        this.product = product;
        this.quantity = 1;
    }

    public void addItem(){
        this.quantity++;
    }

    public void removeItem(){
        this.quantity--;
    }

    public float getSubTotal(){
        return product.getPrice() * quantity;
    }



}
