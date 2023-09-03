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
