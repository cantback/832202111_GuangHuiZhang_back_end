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

    private boolean target;
    private String email;
    private String address;
    private String media_account;
    @ElementCollection
    @CollectionTable(
            name = "phone_numbers",
            joinColumns = @JoinColumn(name = "contact_id")
    )
    @Column(name = "number")
    private List<String> numbers = new ArrayList<>();
    public Contacts() {
    }

    public Contacts(Long id, String name, boolean target, String email, String address, String media_account) {
        this.id = id;
        this.name = name;
        this.target = target;

        this.email = email;
        this.address = address;
        this.media_account = media_account;
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
