package Dao;

import pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    public Employee selectById(int i);
    public void insert(Employee employee);
    public void update(Employee employee);
    public void delete(int i);

    public List<Employee> selectByItem(Employee employee);
}
