package com.drift.controller;

import com.drift.entity.Department;
import com.drift.entity.Employee;
import com.drift.service.DepartmentService;
import com.drift.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: "周星谕"
 * DateTime: 2020/8/29  15:23
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "currPage",required = false,defaultValue = "1") Integer currPage,  Model model){

        //设置每页的条数
        int pageSize = 3;
        //总条数
        int total = employeeService.getEmployeeTotal();
        //计算分页的页数
        int totalPages = total % pageSize > 0 ? (total/pageSize+1) : (total/pageSize);

        Integer[] pageLabelArr = new Integer[5];
        // 计算查询的开始行    获得分页的数据
        int startRow = (currPage - 1) * pageSize;

        Map<String, Object> map = new HashMap<>();
        map.put("startRow",startRow);
        map.put("pageSize",pageSize);
        map.put("currPage",currPage);

        List<Employee> employeeByPage = employeeService.getEmployeeByPageByPage(map);
        //System.out.println(employeeByPage);
        //返回页面
        model.addAttribute("employees",employeeByPage);
        model.addAttribute("currPage",currPage);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("pageLabelArr",pageLabelArr);
        return "index";
    }

    @RequestMapping("/showAddEmp")
    public String addEmp(Model model){
        //回显部门
        List<Department> list = departmentService.getAllDep();
        System.out.println(list);
        model.addAttribute("list",list);
        return "showAddEmp";
    }

    @RequestMapping("/Emp/register")
    public String registerEmp(Employee employee){
        System.out.println(employee);
        int result = employeeService.insertSelective(employee);
        /*if(result>0){
            return "redirect:/index";
        }else{

            return "error";
        }*/
        return "redirect:/index";
    }




    /**
     * 单条查询
     */
    @RequestMapping("/selectByid")
    public String selectByid(Integer id,Model model){
        //回显部门
        List<Department> list = departmentService.getAllDep();
        System.out.println(list);

        Employee employees = employeeService.selectByPrimaryKey(id);
        System.out.println("huihxian"+employees);
        model.addAttribute("list",list);
        model.addAttribute("employees",employees);
        return "UpdateUser";
    }

   /**
     * 删除
     */
    @RequestMapping("/delete")
    public String deleteByid(Integer id){
        int i = employeeService.deleteByPrimaryKey(id);
        if(i>0){
            return "redirect:/index";
        }else{

            return "error";
        }
    }
    /**
     * 修改用户的操作
     */
    @RequestMapping("/Emp/update")
    public String updateUser(Employee employee){

        // 1. 判空
        if(StringUtils.isEmpty(employee)){
            return "error";
        }
        // 2. 修改数据
        int result = employeeService.updateByPrimaryKeySelective(employee);
        /*// 3. 返回页面
        if(result >0){
            // 返回首页
            return "redirect:/index";
        }else{
            // 返回首页
            return "error";
        }*/
        return "redirect:/index";
    }

    /**
     * 模糊查询
     */
    @RequestMapping("/sellike")
    public String sellike(@RequestParam(value = "currPage",required = false,defaultValue = "1") Integer currPage,
            @RequestParam(value = "queryText", required = false, defaultValue = "") String queryText, Model model){


        //设置每页的条数
        int pageSize = 3;
        //总条数
        int total = employeeService.getEmployeeTotal();
        //计算分页的页数
        int totalPages = total % pageSize > 0 ? (total/pageSize+1) : (total/pageSize);

        Integer[] pageLabelArr = new Integer[5];
        // 计算查询的开始行    获得分页的数据
        int startRow = (currPage - 1) * pageSize;

        Map<String, Object> map = new HashMap<>();
        map.put("startRow",startRow);
        map.put("pageSize",pageSize);
        map.put("currPage",currPage);

        List<Employee> employeeByPage = employeeService.getEmployeeByPageByPage(map);
        //System.out.println(employeeByPage);
        //返回页面
        //model.addAttribute("employees",employeeByPage);
        model.addAttribute("currPage",currPage);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("pageLabelArr",pageLabelArr);
        System.out.println(queryText);
        List<Employee> employees = employeeService.selAll(queryText);
        model.addAttribute("employees",employees);
        System.out.println(employees);
        return "index";
    }


}
