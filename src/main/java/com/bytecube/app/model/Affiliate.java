/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.model;

import javax.persistence.*;

import lombok.Data;

/**
 *
 * @author hp
 */

@Data
@Entity
@Table(name = "affiliates", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "affiliateCode"
        })
})
public class Affiliate extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "affiliate_Code")
    private String affiliateCode;

    @Column(name = "affiliate_Name")
    private String affiliateName;

    @Column(name = "affiliate_Desc")
    private String affiliateDesc;
}

