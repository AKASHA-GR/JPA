package com.xworkz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer_info")
@NamedQuery(name = "getAllCustomers", query = "select c from CustomerDetailEntity c")
@NamedQuery(name = "getByName",query = "select c from CustomerDetailEntity c where c.name = 'Hemanth'")
@NamedQuery(name = "getByState",query = "select c from CustomerDetailEntity c Where c.state = 'Karnataka'")
@NamedQuery(name = "getByPincode",query = "select c from CustomerDetaiEntity c where c.pincode = '600001'")
@NamedQuery(name = "getByAccontNumber",query = "select c from CustomerDetaiEntity c where c.accountNumber = '87654321'")
@NamedQuery(name = "updateNameByPincode",query = "update CustomerDetaiEntity c set c.name = 'Priya Mudalagi' where c.pincode = '87654321'")
@NamedQuery(name = "updateAccountTypeById",query = "update CustomerDetaiEntity c set c.accountType = 'business' where c.id = 3")
@NamedQuery(name = "updateStateByPin",query = "update CustomerDetaiEntity c set c.state = 'Arunachal' where c.pincode = '680001' ")
@NamedQuery(name = "deleteByName ",query = "delete from CustomerDetaiEntity c where c.name = 'Amit'")
@NamedQuery(name = "deleteByID",query = "delete from CustomerDetaiEntity c where c.id = 6")


public class CustomerDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "state")
    private String state;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "accountNumber")
    private String accountNumber;
    @Column(name = "accountType")
    private String accountType;

    public CustomerDetailEntity(String name, String state, String pincode, String accountNumber, String accountType) {
        this.name = name;
        this.state = state;
        this.pincode = pincode;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }
}
