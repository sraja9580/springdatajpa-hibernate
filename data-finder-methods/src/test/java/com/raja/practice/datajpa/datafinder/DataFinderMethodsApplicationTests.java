package com.raja.practice.datajpa.datafinder;

import com.raja.practice.datajpa.datafinder.product.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class DataFinderMethodsApplicationTests {

	@Autowired
	ProductRepo productRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testFindById(){
		System.out.println(productRepo.findById(1).toString());
	}

	@Test
	void testFindByName(){
		System.out.println("testFindByName START **********");
		productRepo.findByProductName("Oneplus7").forEach(product -> System.out.println( product.toString()));
		System.out.println("testFindByName END ************");
	}


	@Test
	void testFindByMultipleFields(){
		System.out.println("testFindByMultipleFields START **********");
		productRepo.findByProductNameAndPrice("Moto G9",12000d).forEach(product -> System.out.println(product.toString()));
		System.out.println("testFindByMultipleFields END ************");
	}

	@Test
	void testFindByGreaterThan(){
		System.out.println("testFindByGreaterThan START **********");
		productRepo.findByPriceGreaterThan(25000d).forEach(product -> System.out.println(product.toString()));
		System.out.println("testFindByGreaterThan END ************");
	}

	@Test
	void testFindByContaines(){
		System.out.println("testFindByContaines START **********");
		productRepo.findByDescriptionContains("Never").forEach(product -> System.out.println(product.toString()));
		System.out.println("testFindByContaines END ************");
	}

	@Test
	void testFindByLike(){
		System.out.println("testFindByLike START **********");
		productRepo.findByProductNameLike("Oneplus%").forEach(product -> System.out.println(product.toString()));
		System.out.println("testFindByLike END ************");
	}

	@Test
	void testFindByBetween(){
		System.out.println("testFindByBetween START **********");
		productRepo.findByPriceBetween(20000d,100000d).forEach(product -> System.out.println(product.toString()));
		System.out.println("testFindByBetween END ************");
	}

	@Test
	void testFindByIn(){
		System.out.println("testFindByIn START **********");
		productRepo.findByPriceIn(Arrays.asList(7500d,19000d)).forEach(product -> System.out.println(product.toString()));
		System.out.println("testFindByIn END ************");
	}
}
