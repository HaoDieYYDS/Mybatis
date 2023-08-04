package com.example.demo.dao;

import com.example.demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    public Employee findById(int id);
    public List<Employee> all();

    public void update(Employee employee);
    public void delete(int id);

    public void  insert(Employee employee);

    public List<Employee> findByName(String username);
}
