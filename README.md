# springdatajpa-hibernate
## 1. CURD
  1. Create Project with following starters
     DATA JPA
     H2
     LOMBOK
     
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
     
1.CURD 2.Generators 3.Spring Data Finder Methods 4.Paging and Sorting 6.JPQL 7.Paging and Sorting JPQL 8.NATIVE SQL 9.INHERITANCE MAPPING 10.COMPONENET MAPPING  11.HIBERNATE MAPPINGS 12.HIBERNATE CACHING 13.TRANSACTION MANAGEMENT
