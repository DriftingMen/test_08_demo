package com.drift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.drift.entity.Department;
import com.drift.entity.DepartmentExample;
import com.drift.dao.DepartmentMapper;
import com.drift.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDep() {
        return departmentMapper.getAllDep();
    }

    @Override
    public long countByExample(DepartmentExample example) {
        return departmentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(DepartmentExample example) {
        return departmentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public List<Department> selectByExample(DepartmentExample example) {
        return departmentMapper.selectByExample(example);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Department record,DepartmentExample example) {
        return departmentMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Department record,DepartmentExample example) {
        return departmentMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentMapper.updateByPrimaryKey(record);
    }

}
