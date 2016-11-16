package pizza.controller;

import lombok.Data;
import pizza.entities.Product;
import pizza.services.ProductService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maart on 15-11-2016.
 */
@Data
@Named
@ViewScoped
@ManagedBean
public class CatalogController implements Serializable{

    private List<Product> productList = new ArrayList<>();

    @EJB
    private ProductService service;

    @PostConstruct
    public void fillProductsList(){
        productList = service.getAllProducts();
    }



}
