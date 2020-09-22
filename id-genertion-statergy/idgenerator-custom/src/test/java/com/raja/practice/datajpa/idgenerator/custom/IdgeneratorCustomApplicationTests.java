package com.raja.practice.datajpa.idgenerator.custom;

import com.raja.practice.datajpa.idgenerator.custom.item.repo.ItemRepo;
import com.raja.practice.datajpa.idgenerator.custom.item.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorCustomApplicationTests {

	@Autowired
	ItemRepo empRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testIDGenerator(){
		Item itm = new Item();
		itm.setItemName("OnePlus 8");
		empRepo.save(itm);
	}
}
