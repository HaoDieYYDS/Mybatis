package com.example.demo.controller;

import com.example.demo.dao.EmployeeMapper;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/test")
    public Employee selectById(@RequestBody int id) {
        Employee employee = employeeMapper.findById(id);
        System.out.println(employee);
        return employee;
    }

    @RequestMapping("/all")
    public List<Employee> all() {
        List<Employee> employees = employeeMapper.all();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        return employees;
    }

    @RequestMapping("/update")
    public Employee update(@RequestBody Employee employee) {

        if (employee != null) {
            System.out.println("更新成功！！！");
            employeeMapper.update(employee);
            return employee;
        } else {
            System.out.println("数据为空，更新失败");
            return null;
        }

    }

    @RequestMapping("/delete/{id}")
    public Employee delete(@RequestBody @PathVariable int id) {
        Employee employee = employeeMapper.findById(id);
        File file = new File("D:\\VueDemo\\demo\\src\\assets\\"+employee.getPic());
        file.delete();
        employeeMapper.delete(id);
        System.out.println("删除成功！");
        return employee;
    }

    @RequestMapping("/insert")
    public Employee insert(Employee employee) {
        MultipartFile file = employee.getFile();
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            String suffix = null;
            if (originalFilename != null) {
                suffix = originalFilename.substring(originalFilename.indexOf("."));
            }
            String filename = UUID.randomUUID() + suffix;
//            String filePath = "D:\\VueDemo\\demo\\src\\assets\\" + filename;
            try {
                byte[] fileBytes = file.getBytes();
                Path filePath = Paths.get("D:\\VueDemo\\demo\\src\\assets\\" + filename);
                Files.write(filePath, fileBytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
////            File saveFile = new File(filePath);
//            try {
//                file.transferTo(saveFile);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            employee.setPic(filename);

            employee.setId(0);
            System.out.println(employee);
            employeeMapper.insert(employee);
            System.out.println("插入成功！");
            return employee;
        } else {
            System.out.println("图片没有上传成功");
            return null;
        }
    }
    @RequestMapping("/testt")
    public String test(){
        return "This is Test !";
    }
}
