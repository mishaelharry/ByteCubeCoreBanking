package com.bytecube.app.model.Customer;

import com.bytecube.app.model.DateAudit;
import com.bytecube.app.model.UserDateAudit;
import lombok.Data;

import javax.persistence.*;


    @Data
    @Entity
    @Table(name = "customer_category", uniqueConstraints = {
            @UniqueConstraint(columnNames = {
                    "customer_Category_Name"
            })
    })
    public class CustomerCategory extends UserDateAudit {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "customer_Category_Name")
        private String customerCategoryName;

        @Column(name = "customer_Category_Desc")
        private String customerCategoryDesc;
}
