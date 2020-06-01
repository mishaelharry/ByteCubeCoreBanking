package com.bytecube.app.model;

import lombok.Data;

import javax.persistence.*;


    @Data
    @Entity
    @Table(name = "currency", uniqueConstraints = {
            @UniqueConstraint(columnNames = {
                    "currencyCode"
            })
    })
    public class Currency extends UserDateAudit {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "currency_Code")
        private String currencyCode;

        @Column(name = "currency_Name")
        private String currencyName;
}
