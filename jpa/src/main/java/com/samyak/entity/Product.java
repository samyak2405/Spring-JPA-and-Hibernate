/**
 *
 */
package com.samyak.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 */
@Entity
@Table(
        name = "product",
        schema = "user",
        uniqueConstraints = {
                @UniqueConstraint( // A column as unique constraints
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit")
        }
)
@NamedQueries(
        {
                @NamedQuery(
                        name="Product.findByPrice",
                        query = "SELECT p FROM Product p WHERE p.price=?1"
                ),
                @NamedQuery(
                        name="Product.findByImageUrl",
                        query="SELECT p FROM Product p WHERE p.imageUrl=:imageUrl"
                )
        }
)
@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name="Product.findBySku",
                        query="SELECT * FROM product p WHERE p.stock_keeping_unit=:sku",
                        resultClass = Product.class
                ),
                @NamedNativeQuery(
                        name="Product.findBySkuOrDescription",
                        query="SELECT * FROM product p WHERE p.stock_keeping_unit=:sku OR p.description=:description",
                        resultClass = Product.class
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator")
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false, length = 255)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
