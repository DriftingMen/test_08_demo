package com.drift.dao;

import com.drift.entity.Employee;
import com.drift.entity.EmployeeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Employee record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Employee record);

    /** 分页查询 */
    List<Employee> getEmployeeByPageByPage(Map<String, Object> map);
    /** 总数查询 */
    int getEmployeeTotal();

    List<Employee> selAll(String name);
}