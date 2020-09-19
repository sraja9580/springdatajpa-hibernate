# CRUD
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
      
   
