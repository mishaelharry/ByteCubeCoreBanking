package com.bytecube.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "base_gl", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "branchCode"
        })
})
public class BaseGL extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "gl_code")
    private String glCode;

    @Column(name = "gl_Name")
    private String glName;

    @Column(name = "gl_Desc")
    private String glDesc;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "node_gl")
    private NodeGL nodeGL;

    @Column(name = "gl_Type")
    private String glType;//internal and Customer

    @Column(name = "gl_Type_Set")
    private String glTypeSet;// Normal, Misc. Debit, Misc. Credit, and Nostro

    @Column(name = "branch_Restriction")
    private String branchRestriction;//Head office GL, Branch GL or ALL

    @Column(name = "posting_Restriction")
    private String postingRestriction;//Direct Posting or Indirect Posting

    @Column(name = "currency_Restriction")
    private String currencyRestriction;//Single Currency, All Foreign Currency, or ALL

    @Column(name = "currency")
    private String currency;//This will appear depending on  the currencyRestriction selected

    @Column(name = "gl_Status")
    private String glStatus;



}
