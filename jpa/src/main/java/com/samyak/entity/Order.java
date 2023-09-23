package com.samyak.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

/**
 * JSON
 * {
 *     "orderTrackingNumber": "XYZ789",
 *     "totalQuantity": 3,
 *     "totalPrice": 55.50,
 *     "status": "Shipped",
 *     "billingAddress": {
 *         "street": "456 Elm Street",
 *         "city": "Exampletown",
 *         "state": "NY",
 *         "country": "USA",
 *         "zipCode": "54321"
 *     }
 * }
 */

@Entity
@Table(
        name = "orders",
        schema = "user",
        uniqueConstraints = {
                @UniqueConstraint( // A column as unique constraints
                        name = "orderTrackingNumber",
                        columnNames = "orderTrackingNumber")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_SEQ")
    @SequenceGenerator(name = "order_SEQ", sequenceName = "order_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name="orderTrackingNumber")
    private String orderTrackingNumber;

    @Column(name="totalQuantity")
    private int totalQuantity;

    @Column(name="totalPrice")
    private BigDecimal totalPrice;

    @Column(name="status")
    private String status;

    @Column(name="dateCreated")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="lastUpdated")
    @UpdateTimestamp
    private Date lastUpdated;

    //Unidirectional
    //@OneToOne JPA annotation to map Order entity with Address entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="billing_address_id",referencedColumnName = "id")
    private Address billingAddress;


}
