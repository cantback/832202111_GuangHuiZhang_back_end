package com.example.interfa.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ExcelProperty("用户编号")
//    @ColumnWidth(20)
    private Long id;
    //    @ExcelProperty("名字")
//    @ColumnWidth(20)
//    @ExcelCell(priority = "B", cellTitle = "名称")
    private String name;
    @ExcelIgnore
    private boolean target;
    @ExcelProperty("邮箱")
    @ColumnWidth(20)
    private String email;
    @ExcelProperty("地址")
    @ColumnWidth(20)
    private String address;
    @ExcelProperty("媒体账号")
    @ColumnWidth(20)
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

    public boolean getTarget() {
        return target;
    }

}
