# springdatajpa-hibernate
## 1. CURD
  1. Create Project with following starters<br/>
     - DATA JPA<br/>
     - H2<br/>
     - LOMBOK<br/>
     - Spring Web<br/>
     
  2. Add schema.sql file in resource folder <br/>
      create table product(id int PRIMARY KEY,name varchar(20),description varchar(100),price decimal(8,3));
      
  3. Configure H2 Database in application.properties <br/>
      #H2 Database <br/>
      spring.datasource.url=jdbc:h2:file:C:/projects/MavenTraining/restful-web-services/restful-web-services <br/>
      spring.datasource.driverClassName=org.h2.Driver <br/>
      spring.datasource.username=sa <br/>
      spring.datasource.password= <br/>
      spring.jpa.database-platform=org.hibernate.dialect.H2Dialect <br/>
      spring.jpa.show-sql=true <br/>
      spring.h2.console.enabled=true <br/>
      
      After config , start application and try access H2 console(port will change based on your configuration)
      http://localhost:8080/h2-console use spring.datasource.url as jdbc url in console
      
  4. Create Product Entity <br/>
      *define all colums as properties <br/>
      *annotate primary column with @ID <br/>
      
  5. Create ProductRepo interfacce by extending CrudRepository interface <br/>
     CrudRepository provided basic crud functionalities and internally extends Repository
     
  6. Service Layer or Controller Layer <br/>
     Auto wire ProductRepo 
     implement Create,Read,update,delete by calling methods in ProductRepo <br/>
     *Technically ProductRepo does not contain any mathod, CRUD methods are extended from CRUD REPO
     
    @RestController
    @RequestMapping("/product")
    public class ProductController {

      @Autowired
      ProductRepo productRepo;

      //CREATE
      @PostMapping
      public Product save(@RequestBody Product product){
        return productRepo.save(product);
      }

      // READ START
      @DeleteMapping("/{id}")
      public void delete(@PathVariable(name="id") Integer id){
         productRepo.deleteById(id);
      }

      @GetMapping("/all")
      public Iterable<Product> getProductList(){
        return productRepo.findAll();
      }
      // READ END

      // UPDATE
      @PutMapping
      public Product upate(@RequestBody Product product){
        return productRepo.save(product);
      }

      // DELETE
      @GetMapping("/{id}")
      public Product getProduct(@PathVariable(name="id") Integer id){
        return  productRepo.findById(id).get();
      }
    }
     input to test Create
     {
        "id": 100, //ID AUTO GENERATED IN OUR SCENARIO DONT NEED TO GIVE
        "name": "One Plus",
        "description": "Never Settle",
        "price": 30000.0
     }
 ## 2.GENERATORS 
  ### What is ID Generator?
    The <generator> class is a sub-element of id. It is used to generate the unique identifier for the objects of persistent class. There are many generator classes defined in the Hibernate Framework.
	
    All the generator classes implements the org.hibernate.id.IdentifierGenerator interface. The application programmer may create one's own generator classes by implementing the IdentifierGenerator interface. Hibernate framework provides many built-in generator classes

  ### Types of ID Generator Provided by JPA?
    Auto	--> Persistance provider(Hibernate) relay on underlying Database (identity , sequence or table based on database type) 
    Identity	--> Persistance provider use Auto Increment field in table (Database takes care)
    Sequence	--> Persistance provider use Will use Database Sequence
    Table	--> Using special table, Persistance Provider will use the table , it generates the value and store it in given table
    * Mysql dont support Sequence,vice versa ORACLE dont support 
    
  ### IDENTITY
    It is used with mysql where primary key is auto-incremented column.
    Add @Id anotation on primary colum 
    Add @GeneratedValue(strategy=GenerationType.IDENTITY) on primary key column to let Persistance provider know it is IDENTITY(Auto Generated.
    ** Steps: ** 
    1. Create Project with following starters
     - DATA JPA
     - H2
     - LOMBOK
     - Spring Web
    
    2. Add schema.sql file in resource folder
      create table product(id int PRIMARY KEY,name varchar(20),description varchar(100),price decimal(8,3));
    
    3. Configure H2 Database in application.properties
      #H2 Database
      spring.datasource.url=jdbc:h2:file:C:/projects/MavenTraining/restful-web-services/restful-web-services 
      spring.datasource.driverClassName=org.h2.Driver 
      spring.datasource.username=sa 
      spring.datasource.password=  
      spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  
      spring.jpa.show-sql=true  
      spring.h2.console.enabled=true  
      
      After config , start application and try access H2 console(port will change based on your configuration)
      http://localhost:8080/h2-console use spring.datasource.url as jdbc url in console
    
    4. Create Product Entity  
      *define all colums as properties  
      *annotate primary column with @ID  
    
    5. Create ProductRepo interfacce by extending CrudRepository interface  
     CrudRepository provided basic crud functionalities and internally extends Repository
    
    6. Service Layer or Controller Layer  
     Auto wire ProductRepo 
     implement Create,Read,update,delete by calling methods in ProductRepo  
     *Technically ProductRepo does not contain any mathod, CRUD methods are extended from CRUD REPO
 ## 11.HIBERNATE MAPPINGS    
  2.Generators 3.Spring Data Finder Methods 4.Paging and Sorting 6.JPQL 7.Paging and Sorting JPQL 8.NATIVE SQL 9.INHERITANCE MAPPING 10.COMPONENET MAPPING  11.HIBERNATE MAPPINGS 12.HIBERNATE CACHING 13.TRANSACTION MANAGEMENT
