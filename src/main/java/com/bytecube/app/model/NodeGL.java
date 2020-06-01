package com.bytecube.app.model;

import lombok.Data;

import javax.persistence.*;

    @Data
    @Entity
    @Table(name = "node_gl", uniqueConstraints = {
            @UniqueConstraint(columnNames = {
                    "node_gl_code"
            })
    })
    public class NodeGL extends UserDateAudit {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @Column(name = "node_gl_code")
        private String nodeGlCode;

        @Column(name = "node_gl_Name")
        private String nodeGlName;

        @Column(name = "node_gl_Desc")
        private String nodeGlDesc;

        @ManyToOne(fetch=FetchType.EAGER)
        @Column(name = "root_gl")
        private RootGL rootGL;

        @Column(name = "node_Gl_Status")
        private String nodeGlStatus;
}
