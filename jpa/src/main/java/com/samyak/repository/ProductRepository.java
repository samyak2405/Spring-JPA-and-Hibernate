package com.samyak.repository;

import com.samyak.constants.SQLConstants;
import com.samyak.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.data.repository.query.Param;

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

    //Named JPQL Queries
    List<Product> findByPrice(BigDecimal price);

    List<Product> findByImageUrl(String imageUrl);

    //JPQL Queries
    @Query(SQLConstants.SELECT_PRODUCT_NAME_AND_DESCRIPTION_INDEX)
    public Product findProductNameAndDescriptionJQLIndexParam(@Param("name") String name,@Param("description")String description);

    @Query(SQLConstants.SELECT_PRODUCT_NAME_AND_DESCRIPTION_NAMED)
    Product findProductNameAndDescriptionJQLNamedParam(String name, String description);

    //Native Queries
    @Query(value = SQLConstants.SELECT_PRODUCT_NAME_AND_DESCRIPTION_NATIVE_INDEX,nativeQuery = true)
    Product findProductNameAndDescriptionNativeIndexParam(String name, String description);

    @Query(value=SQLConstants.SELECT_PRODUCT_NAME_AND_DESCRIPTION_NATIVE_NAMED,nativeQuery = true)
    Product findProductNameAndDescriptionNativeNamedParam(String name, String description);

    //Named Native Queries
    @Query(nativeQuery=true)
    Product findBySku(String sku);

    @Query(nativeQuery = true)
    List<Product> findBySkuOrDescription(String sku,String description);



}
