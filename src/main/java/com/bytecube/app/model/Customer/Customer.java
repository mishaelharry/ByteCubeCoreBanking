package com.bytecube.app.model.Customer;


import com.bytecube.app.model.BaseGL;
import com.bytecube.app.model.DateAudit;
import com.bytecube.app.model.User;
import com.bytecube.app.model.UserDateAudit;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;


@Data
@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "customerNo"
        })
})
public class Customer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_No")
    private String customerNo;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "customer_Type")
    private CustomerType customerType;

    @Column(name = "customer_Name")
    private String customerName;

    @Column(name = "short_Name")
    private String shortName;

    @Column(name = "customer_Address")
    private String customerAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "language")
    private String language;

    @Column(name = "local_Branch")
    private String localBranch;

    @Column(name = "liability_No")
    private String liabilityNo;

    @Column(name = "unique_id_name")
    private String uniqueIdName;

    @Column(name = "unique_id_value")
    private String uniqueIdValue;

    @Column(name = "frozen")
    private boolean frozen;

    @Column(name = "deceased")
    private boolean deceased;

    @Column(name = "where_About_UnKnown")
    private boolean whereAboutUnKnown;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "customer_Category")
    private CustomerCategory customerCategory;

    @Column(name = "record_Status")
    private int recordStatus;

    @Column(name = "authorisation_Status")
    private int authorisationStatus;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "maker_Id")
    private User makerId;

    @Column(name = "maker_Date_Stamp")
    private Instant makerDateStamp;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name = "checker_Id")
    private User checkerId;

    @Column(name = "checker_Date_Stamp")
    private Instant checkerDateStamp;

    @Column(name = "over_All_Limit")
    private double overAllLimit;

    @Column(name = "swift_Code")
    private String swiftCode;

    @Column(name = "utility_Provider")
    private String utilityProvider;

    @Column(name = "utility_Provider_Id")
    private String utilityProviderId;

    @Column(name = "utility_Provider_Type")
    private String utilityProviderType;

    @Column(name = "bvn")
    private String bvn;

    @Column(name = "tin")
    private String tin;

    @Column(name = "is_PEP")
    private boolean isPEP;

    @Column(name = "aml_Required")
    private boolean amlRequired;

    @Column(name = "aml_Customer_Group")
    private String amlCustomerGroup;

    @Column(name = "customer_Classification")
    private String customerClassification;


    @Column(name = "introducer")
    private String introducer;

    @Column(name = "generate_MT940")
    private boolean generateMT940;

    @Column(name = "is_Staff")
    private boolean isStaff;

    @Column(name = "kyc_Details")
    private String kycDetails;

    @Column(name = "is_Joint_Venture")
    private boolean isJointVenture;

    @Column(name = "rm_Id")
    private String rmId;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "statement_Day")
    private String statementDay;

    @Column(name = "is_Forgotten")
    private boolean isForgotten;


}
