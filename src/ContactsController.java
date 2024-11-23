package com.example.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.entity.Contacts;
import com.example.back.service.ContactService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/Contact")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactsController {

    @Resource
    private ContactService contactSer;

    //获取所有用户
    @PostMapping("/findAll")
    public ResponseEntity<Map<String, Object>> findAll() {
        List<Contacts> contacts = contactSer.getAllContacts();
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "success");
        response.put("data", contacts);
        return ResponseEntity.ok(response);
    }

    //增加
    @PostMapping
    public Contacts addContact(@RequestBody Contacts contacts) {
        return contactSer.addContact(contacts);

    }

    // 更新用户信息
    @PutMapping("/{id}")
    public ResponseEntity<Contacts> updateContacts(@PathVariable Long id, @RequestBody Contacts contactsDetails) {

        Contacts updatedContacts = contactSer.updateContacts(id, contactsDetails);

        return ResponseEntity.ok(updatedContacts);

    }

    // 删除用户
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {

        contactSer.deleteContact(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}/start")
    public ResponseEntity<Contacts> startContacts(@PathVariable Long id) {

        Contacts updatedContacts = contactSer.updateStartTarget(id);

        return ResponseEntity.ok(updatedContacts);
    }

}
