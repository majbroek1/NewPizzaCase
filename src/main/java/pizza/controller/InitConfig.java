package pizza.controller;

import pizza.entities.Product;
import pizza.services.ProductService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by maart on 15-11-2016.
 */
@Singleton
@Startup
public class InitConfig {

    @EJB
    private ProductService service;

    @PostConstruct
    public void createData(){
        service.save(Product.builder().name("AA").price(3F).build());
        service.save(Product.builder().name("BB").price(4F).build());
    }

}
