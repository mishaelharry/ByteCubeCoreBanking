package com.bytecube.app.model.Customer;

import com.bytecube.app.model.UserDateAudit;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "account_class", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "account_Class_Name"
        })
})
public class AccountClass extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_Class_Name")
    private String accountClassName;

    @Column(name = "accountClassDesc")
    private String accountClassDesc;
}
