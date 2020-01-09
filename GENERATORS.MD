# GENERATORS
## What is ID Generator?
The <generator> class is a sub-element of id. It is used to generate the unique identifier for the objects of persistent class. There are many generator classes defined in the Hibernate Framework.

All the generator classes implements the org.hibernate.id.IdentifierGenerator interface. The application programmer may create one's own generator classes by implementing the IdentifierGenerator interface. Hibernate framework provides many built-in generator classes

## Types of ID Generator Provided by JPA?
Auto	--> Persistance provider(Hibernate) relay on underlying Database (identity , sequence or table based on database type) 
Identity	--> Persistance provider use Auto Increment field in table (Database takes care)
Sequence	--> Persistance provider use Will use Database Sequence
Table	--> Using special table, Persistance Provider will use the table , it generates the value and store it in given table
* Mysql dont support Sequence,vice versa ORACLE dont support 

## IDENTITY
It is used with mysql where primary key is auto-incremented column.
Add @Id anotation on primary colum 
Add **@GeneratedValue(strategy=GenerationType.IDENTITY)** on primary key column to let Persistance provider know it is IDENTITY(Auto Generated.
