# CRUD
Data JPA provides **CrudRepository** for CRUD operations

```
public interface ProductRepo extends CrudRepository<Product,Integer> {
}
```

  * Save - productRepo.save(product)
