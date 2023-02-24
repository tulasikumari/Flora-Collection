package com.system.floracollection.Service;

import com.system.floracollection.Entity.Product;
import com.system.floracollection.Pojo.ProductPojo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> fetchAll();

    ProductPojo saveProduct(ProductPojo productPojo) throws IOException;


    void deleteById(Integer id);

    Product getSingle(Integer id);

    List<Product> fetchNew();

    List<Product> trending();

    List<Product> mostPopular();

    List<Product> bestSeller();

    Map<Integer, Double> comparePrice(List<Product> products);
}
