package com.raja.practice.datajpa.idgenerator.custom.item.repo;

import com.raja.practice.datajpa.idgenerator.custom.item.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item,Integer> {
}
