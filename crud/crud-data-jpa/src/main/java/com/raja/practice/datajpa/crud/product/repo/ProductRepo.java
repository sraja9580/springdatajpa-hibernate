package com.raja.practice.datajpa.crud.product.repo;

import com.raja.practice.datajpa.crud.product.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,Integer> {
}
