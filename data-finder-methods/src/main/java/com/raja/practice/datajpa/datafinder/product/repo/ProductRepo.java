package com.raja.practice.datajpa.datafinder.product.repo;

import com.raja.practice.datajpa.datafinder.product.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Integer> {
    List<Product> findByProductName(String name);
    List<Product> findByProductNameAndPrice(String name,Double price);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescriptionContains(String searchString);
    List<Product> findByProductNameLike(String name);
    List<Product> findByPriceBetween(Double minmum,Double maximum);
    List<Product> findByPriceIn(List<Double> priceList);
}
