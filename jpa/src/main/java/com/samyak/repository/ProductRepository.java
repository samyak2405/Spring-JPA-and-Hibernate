package com.samyak.repository;

import com.samyak.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     * Find By Name
     * @param name
     * @return
     */
    Product findByName(String name);

    /**
     * Find By active and price
     * @param active
     * @param price
     * @return
     */
    List<Product> findByActiveAndPrice(boolean active, BigDecimal price);

    /**
     * Find By active or price
     * @param active
     * @param price
     * @return
     */
    List<Product> findByActiveOrPrice(boolean active, BigDecimal price);

    /**
     * Find distinct price product
     * @param price
     * @return
     */
    List<Product> findDistinctByPrice(BigDecimal price);

    /**
     * Find product with price greater than
     * @param price
     * @return
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Find product with price Lesser than
     * @param price
     * @return
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Find by name containing certain string
     * @param name
     * @return list of products
     */
    List<Product> findByNameContaining(String name);

    /**
     * Find by name like given string
     * @param name
     * @return list of products
     */
    List<Product> findByNameLike(String name);

    /**
     * find products between price range
     * @param startPrice
     * @param endPrice
     * @return list of products
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByNameIn(List<String> names);
}
