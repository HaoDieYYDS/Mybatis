package Dao;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Employee;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapperTest extends TestCase {
    EmployeeMapper employeeMapper;
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testSelectById() {
        SqlSession session = MybatisUtils.getSqlSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        System.out.println(employeeMapper.selectById(1));
        session.close();
    }

    public void testInsert() {
        SqlSession session = MybatisUtils.getSqlSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(200,"老六",40,"董事长");
        employeeMapper.insert(employee);
        session.commit();
        session.close();
        System.out.println("插入成功！");
    }

    public void testUpdate() {
        SqlSession session = MybatisUtils.getSqlSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(1,"小红",80,"创始人");
        employeeMapper.update(employee);
        session.commit();
        session.close();
        System.out.println("更新成功！");
    }

    public void testDelete() {
        SqlSession session = MybatisUtils.getSqlSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        employeeMapper.delete(5);
        session.commit();
        session.close();
        System.out.println("删除成功！");
    }

    public void testTestSelectByItem() {
        SqlSession session = MybatisUtils.getSqlSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setName("李四");
         employee.setAge(35);
        List<Employee> list = employeeMapper.selectByItem(employee);

        for(Employee employee1:list)
        {
            System.out.println(employee1);
        }
        session.commit();
        session.close();
    }
}