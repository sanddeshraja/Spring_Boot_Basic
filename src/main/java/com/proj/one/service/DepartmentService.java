package com.proj.one.service;

import com.proj.one.Error.DepartmentNotFoundException;
import com.proj.one.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartment();
    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    List<Department> saveDepartmentBulk(List<Department> departmentList);

    void deleteDepartment(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
