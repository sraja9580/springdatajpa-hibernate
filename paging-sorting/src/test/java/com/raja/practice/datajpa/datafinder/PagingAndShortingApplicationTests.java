package com.raja.practice.datajpa.datafinder;

import com.raja.practice.datajpa.datafinder.product.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

@SpringBootTest
class PagingAndShortingApplicationTests {

	@Autowired
	ProductRepo productRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testPaging(){
		System.out.println("testPaging START **********");
		Pageable pageable = PageRequest.of(0,2);
		productRepo.findAll(pageable).forEach(System.out::println);
		System.out.println("testPaging END **********");
	}

	@Test
	void testSorting(){
		System.out.println("testSorting START **********");
		productRepo.findAll(Sort.by(Sort.Direction.DESC,"productName")).forEach(System.out::println);
		System.out.println("testSorting END **********");
	}

	@Test
	void testSortByMultipeProperties(){
		System.out.println("testSortByMultipeProperties START **********");
		productRepo.findAll(Sort.by(Sort.Direction.DESC,"productName","price")).forEach(System.out::println);
		System.out.println("testSortByMultipeProperties END **********");
	}

	@Test
	void testSortByMultipePropertiesAndMultipleDirection(){
		System.out.println("testSortByMultipePropertiesAndMultipleDirection START **********");
		productRepo.findAll(Sort.by(Sort.Order.asc("productName"), Sort.Order.desc("price"))).forEach(System.out::println);
		System.out.println("testSortByMultipePropertiesAndMultipleDirection END **********");
	}

	@Test
	void testPagingAndSorting(){
		System.out.println("testPagingAndSorting START **********");
		System.out.println("PAGE 1");
		Pageable pageable = PageRequest.of(0,3,Sort.by(Sort.Order.asc("productName"), Sort.Order.desc("price")));
		productRepo.findAll(pageable).forEach(System.out::println);
		System.out.println("PAGE 2");
		pageable = PageRequest.of(1,3,Sort.by(Sort.Order.asc("productName"), Sort.Order.desc("price")));
		productRepo.findAll(pageable).forEach(System.out::println);
		System.out.println("testPagingAndSorting END **********");
	}

	@Test
	void testCustomFinderPagingAndSorting(){
		System.out.println("testCustomFinderPagingAndSorting START **********");
		System.out.println("PAGE 1");
		Pageable pageable = PageRequest.of(0,3,Sort.by(Sort.Order.asc("productName"), Sort.Order.desc("price")));
		productRepo.findByPriceGreaterThan(8000d,pageable).forEach(System.out::println);
		System.out.println("PAGE 2");
		pageable = PageRequest.of(1,3,Sort.by(Sort.Order.asc("productName"), Sort.Order.desc("price")));
		productRepo.findByPriceGreaterThan(8000d,pageable).forEach(System.out::println);
		System.out.println("testCustomFinderPagingAndSorting END **********");
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
