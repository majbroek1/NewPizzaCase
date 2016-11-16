package pizza.controller;

import pizza.entities.Product;
import pizza.services.ProductService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by maart on 15-11-2016.
 */
@Named
@RequestScoped
@ManagedBean
public class ProductController{

    private Product product;

    @EJB
    private ProductService service;

    public ProductController() {
        product = new Product();
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public void saveProduct(Product prod){
        service.save(prod);
        product = new Product();
    }

}
