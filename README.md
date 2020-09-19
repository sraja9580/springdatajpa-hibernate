# DATA JPA
* [CRUD](#crud)

## CRUD
Data JPA provides **CrudRepository** for CRUD operations

```
public interface ProductRepo extends CrudRepository<Product,Integer> {
}
```

  * Save - productRepo.save(product)
  * Save List - productRepo.save(productList)          
  * find - productRepo.findById(1)
  * update - productRepo.save(1)
       product = productRepo.findById(1)
       product.setName("new name")
       productRepo.findById(product)
  * delete - productRepo.deleteById(1)
  * isExist - productRepo.existsById(1)
  * COUNT - productRepo.count()
     
 ## 11.HIBERNATE MAPPINGS    
  2.Generators 3.Spring Data Finder Methods 4.Paging and Sorting 6.JPQL 7.Paging and Sorting JPQL 8.NATIVE SQL 9.INHERITANCE MAPPING 10.COMPONENET MAPPING  11.HIBERNATE MAPPINGS 12.HIBERNATE CACHING 13.TRANSACTION MANAGEMENT
