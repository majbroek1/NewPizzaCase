package pizza.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maart on 15-11-2016.
 */
@NamedQueries({
        @NamedQuery(name = "getAllProducts", query = "SELECT p FROM Product p")
})

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    @Id @GeneratedValue
    private int id;

    private String name;
    private float price;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }

}
