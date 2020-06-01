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
@Table(name = "branches", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "branchCode"
        })
})
public class Branch extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "branch_Code")
    private String branchCode;

    @Column(name = "branch_Name")
    private String branchName;

    @Column(name = "branch_Address")
    private String branchAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "affiliate")
    private Affiliate affiliate;


}