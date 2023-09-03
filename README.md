# Spring-JPA-and-Hibernate

## Configuration for Spring Data JPA
In application.properties file add following code

    spring.datasource.url=jdbc:mysql://localhost:3306/{Database_name}?useSSL=false
    spring.datasource.username={mysql_username}
    spring.datasource.password={mysql_password}
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.auto-ddl=none
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format-sql=true

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


        
