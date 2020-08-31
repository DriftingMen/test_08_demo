package com.drift.service;

import java.util.List;
import java.util.Map;

import com.drift.entity.EmployeeExample;
import com.drift.entity.Employee;
public interface EmployeeService{


    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Employee record,EmployeeExample example);

    int updateByExample(Employee record,EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    /** 分页查询 */
    List<Employee> getEmployeeByPageByPage(Map<String, Object> map);
    /** 总数查询 */
    int getEmployeeTotal();

    List<Employee> selAll(String queryText);

}
