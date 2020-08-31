package com.drift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.drift.entity.EmployeeExample;
import com.drift.dao.EmployeeMapper;
import com.drift.entity.Employee;
import com.drift.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public long countByExample(EmployeeExample example) {
        return employeeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EmployeeExample example) {
        return employeeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public List<Employee> selectByExample(EmployeeExample example) {
        return employeeMapper.selectByExample(example);
    }

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Employee record,EmployeeExample example) {
        return employeeMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Employee record,EmployeeExample example) {
        return employeeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Employee> getEmployeeByPageByPage(Map<String, Object> map) {

        // 通过List集合进行分页
        int pageSize = (int) map.get("pageSize");
        int currPage = (int) map.get("currPage");
        List list = employeeMapper.getEmployeeByPageByPage(map);

        /*List<Employee> currentPageList = new ArrayList<>();
        //判断list不是空的
        if (list != null && list.size() > 0) {
            //获得每页的第一个数数据  的list下标
            int currIdx = (currPage > 1 ? (currPage - 1) * pageSize : 0);
            //遍历输出每页的数据
            //list.size() - currIdx  防止最后一页的数据超标
            for (int i = 0; i < pageSize && i < list.size() - currIdx; i++) {
                list.get(currIdx + i);
            }
        }
        System.out.println(currentPageList);*/
        return list;
    }

    @Override
    public int getEmployeeTotal() {
        return employeeMapper.getEmployeeTotal();
    }

    @Override
    public List<Employee> selAll(String queryText) {
        List<Employee> employees = employeeMapper.selAll(queryText);
        return employees;
    }

}
