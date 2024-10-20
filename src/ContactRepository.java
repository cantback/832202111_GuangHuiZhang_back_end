package com.example.interfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.interfa.entity.Contacts;

public interface ContactRepository extends JpaRepository<Contacts, Long> {

    //List是数组对象HistoryRecord是实体类
}
