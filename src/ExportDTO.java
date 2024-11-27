package com.example.interfa.DTO;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.example.interfa.entity.Contacts;
import com.example.interfa.service.ContactService;
import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
@Data
public class ExportDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty("用户编号")
    @ColumnWidth(20)
    private Long id;
    @ExcelProperty("名字")
    @ColumnWidth(20)
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
    @ExcelProperty("号码列表")
    private String number;

    public static ExportDTO from(Contacts contact) {
        ExportDTO dto = new ExportDTO();
        dto.setId(contact.getId());
        dto.setName(contact.getName());
        dto.setNumber(String.join(", ", contact.getNumber())); // List转String
        dto.setEmail(contact.getEmail());
        dto.setAddress(contact.getAddress());
        dto.setMedia_account(contact.getMedia_account());
        return dto;
    }

    // 批量转换方法
    public static List<ExportDTO> fromList(List<Contacts> contacts) {
        return contacts.stream()
                .map(ExportDTO::from)
                .collect(Collectors.toList());
    }
}
// 2. 转换数据

// 3. 导出
