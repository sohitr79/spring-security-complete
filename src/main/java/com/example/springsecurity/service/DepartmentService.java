package com.example.springsecurity.service;

import com.example.springsecurity.entity.Department;
import com.example.springsecurity.entity.MetaInfo;
import com.example.springsecurity.repository.DepartmentCrudRepository;
import com.example.springsecurity.repository.MetaInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentCrudRepository departmentCrudRepository;

    @Autowired
    MetaInfoRepository metaInfoRepository;

    public Department saveDepartment(Department department) {
        return departmentCrudRepository.save(department); // Saves and returns the entity with generated ID
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.SUPPORTS)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveDepartmentWithTransaction(Department department) {
        departmentCrudRepository.save(department);
    }


//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.SUPPORTS)
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMetaInfo(MetaInfo metaInfo) {
        metaInfoRepository.save(metaInfo);
    }

    public Department getDepartment(Long id) {
        return departmentCrudRepository.findById(id).orElse(null);
    }
}

