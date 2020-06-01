package com.bytecube.app.model.Customer;

import com.bytecube.app.model.UserDateAudit;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Customer_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "customer_Type_Name"
        })
})
public class CustomerType extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_Type_Name")
    private String customerTypeName;

    @Column(name = "customer_Type_Desc")
    private String customerTypeDesc;
}
