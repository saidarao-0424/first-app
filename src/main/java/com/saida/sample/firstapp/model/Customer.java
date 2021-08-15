package com.saida.sample.firstapp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME", length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "CONTACT_NUM", length = 12)
    private String contactNum;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    public Customer() {
        super();
    }


}
