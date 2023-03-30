package com.proj.one.controller;

import com.proj.one.Error.DepartmentNotFoundException;
import com.proj.one.entity.Department;
import com.proj.one.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER =  LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment");
       return  departmentService.saveDepartment(department);
    }
    @GetMapping("/getdepartments")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }
    @GetMapping("/getdepartment/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }
    @PostMapping("/departments/_bulk")
    public List<Department> saveDepartmentBulk(@RequestBody List<Department> departmentList){
        return departmentService.saveDepartmentBulk(departmentList);
    }
    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
          departmentService.deleteDepartment(departmentId);
    }
    @PutMapping("/updatedepartments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
    @GetMapping("/getByName/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
