# Spring-JPA-and-Hibernate

## Configuration for Spring Data JPA
In application.properties file add following code

```
spring.datasource.url=jdbc:mysql://localhost:3306/{Database_name}?useSSL=false
spring.datasource.username={mysql_username}
spring.datasource.password={mysql_password}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format-sql=true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```
In spring.jpa.hibernate.auto-ddl we can give following options
  1. none: disables the hbm2ddl.auto tool, so Hibernate is not going to take any action for managing the underlying database schema
  2. create-only: tells hibernate to generate the database schema from the entity model
  3. drop: tells hibernate to drop the database schema using the entity model as a reference for the DDL DROP statements.
  4. create: Tells hibernate to drop the database schema and recreate it afterward using the entity model as a reference.
  5. create-drop: Tells hibernate to drop the database schema and recreate it afterward using the entity model as a reference. And upon closing the JPA EntityMangerFactory or the Hibernate SessionFactory, the database schema will be dropped again.
  6. validate: Tells hibernate to validate the underlying database schema against the entity mappings.
  7. update:  Tells hibernate that alter the database tables as per entity mapping changes.

## Important Annotations
    1. @Entity: specifies that the class is an entity. This annotation can be applied to Class, Interface of Enums.
    2. @GeneratedValue(strategy=GenerationType.{})
        IDENTITY: This strategy relies on the database auto-increment column and lets the database generate a new value with each insert operation.
        AUTO: (Default) lets persistence provider choose the generation strategy.
            If you use Hibernate as your persistence provider, it selects a generation strategy based on the database-specific dialect.
        SEQUENCE: generate primary key values and uses a database sequence to generate unique values.
                  It requires additional select statements to get the next value from a database sequence. Bt this has no performance impact on most applications.
                  The @SequenceGenerator annotation lets you define the name of the generator, the name and schema of the database sequence and the allocation size of the sequence.
        TABLE: simulates a sequence by storing and updating its current value in a database table which requires the use of pessimistic locks which put all transactions into sequential order.
        NOTE: PREFERRED- SEQUENCE
## Query Generation from method names
- Spring data JPA query methods can be used to select records from the database without writing SQL queries.
- Spring data JPA will create SQL queries based on the query method and execute the query for us.
Eg: SELECT id,name,description,active,image_url,prie,sku from products where name="product name"
    can be written as findByName(String name) in Spring data JPA Query Method --> also known as Finder Methods
- How it works?
      1. We write Query Method using Spring data JPA.
      2. Spring Data JPA parse Query Method and creates JPA Criteria(Parsing query method names is divided into subject and predicate. The first part(find..By,exists...By) defines the subject of the query, the second part forms the predicate)
      3. JPA criteria creates JPQL query and executes it.

- Query method structure
Eg: public List<Product> findByNameAndDescription(String name,String description)
    - List<Product> ---> return type
    - findBy ---> Query Method subject keyword
    - NameAndDescription ---> Query Method predicate keyword
    - (String name,String description) ---> Query Method parameters

 **[Rules to create Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords)**
 1. The name of our query method must start with one of the following prefixes
    - find...By
    - read...By
    - query...By
    - count...By
    - get...By
    - Eg: findByName, readByName, queryByName, getByName
2. If we want to limit the number of returned query results, we can add the First or the Top keywords before the first By word
    - Eg: findFirstByName, readFirst2ByName, findTop10ByName
3. If we want to select unique results, we have to add the Distinct keyword before the first by word.
    - Eg: findDistinctByName or findNameDistinctBy
4. Combine property expression with AND and OR.
    - Eg: findByNameOrDescription, findByNameAndDescription
5. GreaterThan and LessThan
    - Eg: findByPriceGreaterThan(BigDecimal price), findByPriceLessThan(BigDecimal price)

## Dependencies needed
```
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jersey</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.restdocs</groupId>
			<artifactId>spring-restdocs-mockmvc</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```


        
