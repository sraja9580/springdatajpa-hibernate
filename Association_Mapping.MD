
# Association Mapping
## ONE-TO-MANY
<img src="images/one-to-many.GIF" alt="One to Many">

### Steps
1. Create Project with following starters<br/>
     - DATA JPA <br/>
     - H2 <br/>
     - LOMBOK <br/>
     - Spring Web <br/>
     
  2. Add schema.sql file in resource folder <br/>
      create table customer(id int PRIMARY KEY AUTO_INCREMENT,name varchar(20)); <br/>
      create table phone_number(id int PRIMARY KEY AUTO_INCREMENT,customer_id int,number varchar(20),type varchar(20), FOREIGN KEY (customer_id) REFERENCES customer(id) ); <br/>
      
  3. Configure H2 Database in application.properties <br/>
      **H2 Database** <br/> 
      **MODE=MySQL** USED TO RUN H2 in MYSQL mode  <br/>
      spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL; <br/>
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
