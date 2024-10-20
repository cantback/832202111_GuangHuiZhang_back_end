package com.example.interfa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.interfa.entity.Contacts;
import com.example.interfa.repository.ContactRepository;

@Service
public class ContactService {

    // @Resource
    // private contactMapper contactMapper;
    @Autowired
    private ContactRepository ContactRepository;

    public Optional<Contacts> getContactById(Long id) {

        return ContactRepository.findById(id);

    }

    public void clearAllContacts() {
        ContactRepository.deleteAll();
    }

    // String contactName, String phoneNumber
    public Contacts addContact(Contacts contacts) {
        return ContactRepository.save(contacts);
    }

    public void deleteContact(Long id) {
        ContactRepository.deleteById(id);
    }

    public Contacts updateContacts(Long id, Contacts contactsDetails) {

        Contacts contacts = ContactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        contacts.setContactName(contactsDetails.getContactName());

        contacts.setPhoneNumber(contactsDetails.getPhoneNumber());

        return ContactRepository.save(contacts);

    }

    public List<Contacts> getAllContacts() {
        return ContactRepository.findAll();
    }
}
