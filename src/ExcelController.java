package com.example.interfa.controller;

import aj.org.objectweb.asm.TypeReference;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.interfa.entity.Contacts;
import com.example.interfa.service.ContactService;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * EasyExcel导入导出
 *
 * @author william@StarImmortal
 */
@RestController
@RequestMapping("/excel")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ExcelController {
    @PostMapping(value = "/importData")
    public Object importManageData(@RequestPart("file") MultipartFile file) throws Exception {
        return CommonUtil.getExcelDataFromFile(file, Contacts.class, 1,2);
    }

    @PostMapping(value = "/exportData")
    public ResponseEntity<byte[]> exportData(@RequestParam("fileName") String fileName){
        List<Contacts> list  = CommonUtil.buildDemoExcel(Contacts.class);
        List<Map<String, Object>> exportView = CommonUtil.buildExportView("测试Title", "测试Sheet",list);
        Workbook workbook = ExcelExportUtil.exportExcel(exportView, ExcelType.XSSF);
        ExcelStyleUtil.addNotExistCell(workbook, 0, 3);
        return CommonUtil.exportWorkbook(workbook, fileName);
    }
//    @Autowired
//    private ContactService contactService;
//
//    @GetMapping("/export")
//    public void exportToExcel(HttpServletResponse response) throws IOException {
//        try {
//            // 设置响应头
//            response.setContentType("application/vnd.ms-excel");
//            response.setCharacterEncoding("utf-8");
//            String fileName = URLEncoder.encode("联系人列表", "UTF-8");
//            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//
//            // 获取所有联系人
//            List<Contacts> contacts = contactService.getAllContacts();
//
//            // 准备导出数据
//            List<Contacts> excelData = new ArrayList<>();
//
//            // 转换数据格式
//            for (Contacts contact : contacts) {
//                List<String> numbers = contact.getNumbers();
//                if (numbers != null && !numbers.isEmpty()) {
//                    // 每个电话号码创建一行
//                    for (String number : numbers) {
//                        Contacts data = new Contacts();
//                        data.setId(contact.getId());
//                        data.setName(contact.getName());
//                        data.setNumbers(Collections.singletonList(number));
//                        data.setAddress(contact.getAddress());
//                        excelData.add(data);
//                    }
//                } else {
//                    // 没有电话号码的情况
//                    Contacts data = new Contacts();
//                    data.setId(contact.getId());
//                    data.setName(contact.getName());
//                    data.setNumbers(Collections.singletonList(""));
//                    data.setAddress(contact.getAddress());
//                    excelData.add(data);
//                }
//            }
//
//            // 使用EasyExcel写入数据
//            EasyExcel.write(response.getOutputStream(), Contacts.class)
//                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
//                    .sheet("联系人列表")
//                    .doWrite(excelData);
//
//        } catch (Exception e) {
//            response.reset();
//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().println("导出Excel失败：" + e.getMessage());
//        }
//    }
}