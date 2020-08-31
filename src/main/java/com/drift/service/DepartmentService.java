package com.drift.service;

import java.util.List;
import com.drift.entity.Department;
import com.drift.entity.DepartmentExample;
public interface DepartmentService{

    List<Department> getAllDep();

    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Department record,DepartmentExample example);

    int updateByExample(Department record,DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

}
