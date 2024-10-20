package com.example.interfa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private Long id;
    // @Column(name = "name")
    private String name;
    // @Column(name = "number")
    private String number;

    public Contacts() {
    }

    public Contacts(Long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public String getContactName() {
        return name;
    }

    public void setContactName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return number;
    }

    public void setPhoneNumber(String number) {
        this.number = number;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
