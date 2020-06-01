package com.bytecube.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "root_gl", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "root_gl_code"
        })
})
public class RootGL extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "root_Gl_code")
    private String rootGlCode;

    @Column(name = "root_Gl_Name")
    private String rootGlName;

    @Column(name = "root_Gl_Desc")
    private String rootGlDesc;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "gl_Category")
    private GLCategory glCategory;

    @Column(name = "root_Gl_Status")
    private String rootGlStatus;
}

