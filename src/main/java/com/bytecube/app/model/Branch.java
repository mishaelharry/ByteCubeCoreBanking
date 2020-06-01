/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author hp
 */
@Data
@Entity
@Table(name = "branches")
public class Branch extends DateAudit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "branch_code", length = 60)
    private String branchCode;
    
    @Column(name = "branch_name", length = 60)
    private String branchName;
    
    @Column(name = "branch_address", length = 60)
    private String branchAddress;

    public Branch() {
    }
    
}
