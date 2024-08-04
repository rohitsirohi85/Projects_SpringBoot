package com.webmvcHomework.__home_work.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.webmvcHomework.__home_work.DTO.departmentDTO;
// import com.webmvcHomework.__home_work.controller.departmentController;
import com.webmvcHomework.__home_work.entity.departmentEntity;
import com.webmvcHomework.__home_work.repository.departmentRepo;

@Service
public class departmentService {
    private final departmentRepo departmentRepo;
    private final ModelMapper ModelMapper;

    

    
    
    
    
    public departmentService(com.webmvcHomework.__home_work.repository.departmentRepo departmentRepo,
            org.modelmapper.ModelMapper modelMapper) {
        this.departmentRepo = departmentRepo;
        ModelMapper = modelMapper;
    }


    public departmentDTO createNewDepartment(departmentDTO inputData) {
        departmentEntity forSaveDepartmentEntity = ModelMapper.map(inputData, departmentEntity.class);
        departmentEntity savedEntity = departmentRepo.save(forSaveDepartmentEntity);
        return ModelMapper.map(savedEntity , departmentDTO.class);
    }


    public Optional<departmentDTO> getDepartmentById(Long id) {
       return departmentRepo.findById(id).map(departmentEntity-> ModelMapper.map(departmentEntity, departmentDTO.class ));
        
    }



    public List<departmentDTO> getAllDepartment() {
        // Fetch all employee entities from the repository
        List<departmentEntity> depEntities = departmentRepo.findAll();

        // Map each employeeEntity to employeeData and collect as a List
        return depEntities
                .stream()
                .map(depEntity -> ModelMapper.map(depEntity, departmentDTO.class))
                .toList();
    }




    public departmentDTO updateById(Long departmentId, departmentDTO departmentDTO) {
          departmentEntity departmentEntity = ModelMapper.map(departmentDTO , departmentEntity.class);
          departmentEntity.setId(departmentId);
          departmentEntity savedEntity = departmentRepo.save(departmentEntity);
          return ModelMapper.map(savedEntity, departmentDTO.class);
    }




    public boolean deleteById(Long departmentId) {
         boolean exist=departmentRepo.existsById(departmentId);
         departmentRepo.deleteById(departmentId);

         if (exist) {
            return true;
         }
         return false;
    }




}
