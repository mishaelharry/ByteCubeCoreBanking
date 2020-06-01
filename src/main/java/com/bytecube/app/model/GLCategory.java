package com.bytecube.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gl_category", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "gl_category_name"
        })
})
public class GLCategory extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gl_category_name")
    private String glCategoryName;

    @Column(name = "gl_category_desc")
    private String glCategoryDesc;

}

