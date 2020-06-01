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
@Table(name = "banks")
public class Bank extends DateAudit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "bank_code")
    private String bankCode;
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "bank_address")
    private String bankAddress;

    public Bank() {
    }
   
}
