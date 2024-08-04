package com.webmvcHomework.__home_work.controller;

import org.springframework.web.bind.annotation.RestController;

import com.webmvcHomework.__home_work.DTO.departmentDTO;
import com.webmvcHomework.__home_work.service.departmentService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path = "/department")
public class departmentController {

    private final departmentService departmentService;

    public departmentController(departmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<departmentDTO> createNewDepartment(@RequestBody @Valid departmentDTO inputData){
        departmentDTO savedDepartmentDTO= departmentService.createNewDepartment(inputData);
        return new ResponseEntity<>(savedDepartmentDTO , HttpStatus.CREATED);
    }

    @GetMapping(path="/{departmentId}")
    public ResponseEntity<departmentDTO> getDepartmentById(@PathVariable (name = "departmentId") Long id){
       Optional<departmentDTO> savedData= departmentService.getDepartmentById(id);
        return savedData
                        .map(data01-> ResponseEntity.ok(data01))
                        .orElse(ResponseEntity.notFound().build());
                         
    }

    @GetMapping
    public ResponseEntity<List<departmentDTO>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PutMapping(path="/{departmentId}")
    public ResponseEntity<departmentDTO> updateById(@PathVariable Long departmentId ,@RequestBody departmentDTO departmentDTO){
        return ResponseEntity.ok(departmentService.updateById(departmentId, departmentDTO));
    }

    @DeleteMapping(path="/{departmentId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long departmentId){
        Boolean deleted= departmentService.deleteById(departmentId);
        if (deleted) {
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
