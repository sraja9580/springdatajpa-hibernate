package com.raja.practice.datajpa.crud;

import com.raja.practice.datajpa.crud.product.entities.Product;
import com.raja.practice.datajpa.crud.product.repo.ProductRepo;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CrudDataJpaApplicationTests {

	@Autowired
	ProductRepo productRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate(){
		Product product = new Product();
		product.setName("Oneplus 7");
		product.setDescription("Never Settle");
		product.setPrice(28000.0);
		productRepo.save(product);
	}

    @Test
    void testBulkCreate(){
        Product product = new Product();
        product.setName("Oneplus 7T");
        product.setDescription("Never Settle");
        product.setPrice(32000.0);

        Product product1 = new Product();
        product1.setName("Oneplus 8");
        product1.setDescription("Not a Flagship Killer Anymore");
        product1.setPrice(60000.0);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);

        productRepo.saveAll(productList);

    }

	@Test
	void testRead(){
		Optional<Product> productOptional = productRepo.findById(1);
		Product product = productOptional.isPresent() ? productOptional.get() : null;
		Assertions.assertNotNull(product);
		Assertions.assertEquals("Oneplus 7",product.getName());
	}

	@Test
	void updateTest(){
		Optional<Product> productOptional = productRepo.findById(1);
		Product product = productOptional.isPresent() ? productOptional.get() : null;
		if(product!=null){
			product.setPrice(25000.0);
		}
		productRepo.save(product);
	}

	@Test
	void delete(){
		productRepo.deleteById(1);
	}

	@Test
	void testIsExist(){
        Assertions.assertTrue(productRepo.existsById(2));
    }

    @Test
    void testCount(){
        System.out.println("Total Record in Product Table: "+productRepo.count());
    }

}
