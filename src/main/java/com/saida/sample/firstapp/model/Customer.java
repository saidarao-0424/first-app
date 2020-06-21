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

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    public Customer() {
        super();
    }

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
