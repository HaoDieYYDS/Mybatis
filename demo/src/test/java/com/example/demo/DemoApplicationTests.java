package com.example.demo;

import com.example.demo.dao.EmployeeMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {
        List<Employee> list = employeeMapper.findByName("张");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

}
