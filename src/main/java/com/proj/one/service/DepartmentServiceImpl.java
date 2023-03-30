package com.proj.one.service;

import com.proj.one.Error.DepartmentNotFoundException;
import com.proj.one.entity.Department;
import com.proj.one.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws  DepartmentNotFoundException {
        Optional<Department> department =
         departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department Not Available");
        }
        else
            return department.get();
    }

    @Override
    public List<Department> saveDepartmentBulk(List<Department> departmentList) {

        return departmentRepository.saveAll(departmentList);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        depDB.setDepartmentName(department.getDepartmentName());
        depDB.setDepartmentAddress(department.getDepartmentAddress());
        depDB.setDepartmentCode(department.getDepartmentCode());
        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findBydepartmentNameIgnoreCase(departmentName);
    }
}
