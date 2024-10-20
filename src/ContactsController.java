package com.example.interfa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interfa.entity.Contacts;
import com.example.interfa.service.ContactService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/Contacts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void testConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("数据库连接成功。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Resource
    private ContactService contactSer;

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearAllContacts() {
        contactSer.clearAllContacts();
        return ResponseEntity.ok("All contacts have been cleared.");
    }

    //增加contact
    @PostMapping
    public Contacts addContact(@RequestBody Contacts contacts) {
        return contactSer.addContact(contacts);

    }

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
// 根据ID获取用户

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id) {
        Contacts contacts = contactSer.getContactById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        return ResponseEntity.ok(contacts);
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

}
