package com.parameterized.test.controller;

import com.parameterized.test.service.ObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectController {

    private ObjectService objectService;

    public ObjectController(ObjectService objectService){
        this.objectService = objectService;
    }

    @GetMapping("/getObject")
    public ResponseEntity<?> getObject(@PathVariable Long id){
        return ResponseEntity.ok().body(objectService.testService(id));
    }
}
