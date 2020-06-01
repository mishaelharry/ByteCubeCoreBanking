package com.bytecube.app.model.Customer;

import com.bytecube.app.model.Branch;
import com.bytecube.app.model.DateAudit;
import lombok.Data;

import javax.persistence.*;


    @Data
    @Entity
    @Table(name = "customer_account", uniqueConstraints = {
            @UniqueConstraint(columnNames = {
                    "customerNo"
            })
    })
    public class CustomerAccount extends DateAudit {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @ManyToOne(fetch=FetchType.EAGER)
        @Column(name = "branch")
        private Branch branch;

        @Column(name = "customer_Account_No")
        private String customerAccountNo;

        @Column(name = "customer_Account_Name")
        private String customerAccountName;

        @ManyToOne(fetch=FetchType.EAGER)
        @Column(name = "customer")
        private Customer customer;

        @Column(name = "currency")
        private String currency;

        @ManyToOne(fetch=FetchType.EAGER)
        @Column(name = "account_Class")
        private AccountClass accountClass;

        @Column(name = "account_Status_PND")
        private boolean accountStatusPND;

        @Column(name = "account_Status_PNC")
        private boolean accountStatusPNC;

        @Column(name = "account_Status_Block")
        private boolean accountStatusBlock;

        @Column(name = "account_Status_Stop_Pay")
        private boolean accountStatusStopPay;

        @Column(name = "account_Status_Dormant")
        private boolean accountStatusDormant;

        @Column(name = "joint_Account_Indicator")
        private String jointAccountIndicator; //S for single(Individual) or J for joint

        @Column(name = "account_Opening_Date")
        private String accountOpeningDate;

        @Column(name = "account_Statement_Day")
        private String accountStatementDay;


        @Column(name = "account_Statement_Cycle")
        private String accountStatementCycle;

        @Column(name = "alternative_Account_No")
        private String alternativeAccountNo;

        @Column(name = "cheque_Book_Facility")
        private boolean chequeBookFacility;

        @Column(name = "atm_Facility")
        private boolean atmFacility;

        @Column(name = "passbook_Facility")
        private boolean passbookFacility;

        @Column(name = "account_Statement_Type")
        private String accountStatementType;

        @Column(name = "account_Statement_Frozen")
        private String accountStatementFrozen;
        




    }
