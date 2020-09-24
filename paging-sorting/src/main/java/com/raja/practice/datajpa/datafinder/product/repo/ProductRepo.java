package com.raja.practice.datajpa.datafinder.product.repo;

import com.raja.practice.datajpa.datafinder.product.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//public interface ProductRepo extends CrudRepository<Product,Integer> {
//PagingAndSortingRepository extends CrudRepo and provides additional paging and shorting features
public interface ProductRepo extends PagingAndSortingRepository<Product,Integer> {
    List<Product> findByProductName(String name);
    List<Product> findByProductNameAndPrice(String name,Double price);
    List<Product> findByPriceGreaterThan(Double price, Pageable pageable);
    List<Product> findByDescriptionContains(String searchString);
    List<Product> findByProductNameLike(String name);
    List<Product> findByPriceBetween(Double minmum,Double maximum);
    List<Product> findByPriceIn(List<Double> priceList);
}
