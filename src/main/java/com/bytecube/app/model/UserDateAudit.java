/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author mishael.harry
 */
@MappedSuperclass
@JsonIgnoreProperties(
        value = {"created_by", "update_by"},
        allowGetters = true
)
public class UserDateAudit extends DateAudit {
    
    @CreatedBy
    @Column(name="created_by", updatable = false)
    private Long createdBy;
    
    @LastModifiedBy
    @Column(name="updated_by")
    private Long updatedBy;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public void setId(Long id) {

    }
}
